package com.devops.demo.Service;

import org.springframework.stereotype.Service;

import com.devops.demo.Entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
@Service
public class ProductService {
 
	
	
 
	
	
	    private final List<Product> products = new ArrayList<>();
	    private long idCounter = 1;
 
	    public List<Product> getAllProducts() {
	        return products;
	    }
 
	    public Optional<Product> getProductById(Long id) {
	        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
	    }
 
	    public Product saveProduct(Product product) {
	        if (product.getId() == null) {
	            product.setId(idCounter++);
	        }
	        products.add(product);
	        return product;
	    }
 
	    public void deleteProduct(Long id) {
	        products.removeIf(p -> p.getId().equals(id));
	    }
	}
 
