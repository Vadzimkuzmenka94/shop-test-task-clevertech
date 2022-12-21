package clevertech.com.esm.service;

import clevertech.com.esm.entities.Product;
import clevertech.com.esm.entities.Purchase;
import clevertech.com.esm.service.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProductService {
    public Product create (Product product);
    public Optional<Product> findById(Long id);
    public Optional<Product> readByName (String name) throws Exception;
}