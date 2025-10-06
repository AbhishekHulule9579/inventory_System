package com.example.inventory_system.service;

import com.example.inventory_system.model.Product;
import com.example.inventory_system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> updateProduct(Long id, Product productDetails) {
        return productRepository.findById(id).map(product -> {
            product.setName(productDetails.getName());
            product.setDescription(productDetails.getDescription());
            if (productDetails.getStockQuantity() >= 0) {
                product.setStockQuantity(productDetails.getStockQuantity());
            }
            product.setLowStockThreshold(productDetails.getLowStockThreshold());
            return productRepository.save(product);
        });
    }

    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    public Optional<Product> increaseStock(Long id, int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount to add must be positive.");
        }
        return productRepository.findById(id).map(product -> {
            product.setStockQuantity(product.getStockQuantity() + amount);
            return productRepository.save(product);
        });
    }

    @Transactional
    public Optional<Product> decreaseStock(Long id, int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount to remove must be positive.");
        }
        return productRepository.findById(id).map(product -> {
            if (product.getStockQuantity() < amount) {
                throw new IllegalStateException("Insufficient stock available.");
            }
            product.setStockQuantity(product.getStockQuantity() - amount);
            return productRepository.save(product);
        });
    }

    public List<Product> getLowStockProducts() {
        return productRepository.findByStockQuantityLessThanLowStockThreshold();
    }
}
