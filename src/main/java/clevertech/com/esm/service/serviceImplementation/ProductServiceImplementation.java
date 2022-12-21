package clevertech.com.esm.service.serviceImplementation;

import clevertech.com.esm.entities.Product;
import clevertech.com.esm.exceptions.AppException;
import clevertech.com.esm.exceptions.ErrorCode;
import clevertech.com.esm.repository.ProductRepository;
import clevertech.com.esm.service.ProductService;
import clevertech.com.esm.service.dto.ProductDTO;
import clevertech.com.esm.service.validator.ProductVadlidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService {
    private final ProductRepository productRepository;
    private final ProductVadlidator productVadlidator;

    @Autowired
    public ProductServiceImplementation(ProductRepository productRepository, ProductVadlidator productVadlidator) {
        this.productRepository = productRepository;
        this.productVadlidator = productVadlidator;
    }

    @Override
    public Product create(Product product) {
        productVadlidator.validate(product);
        return  productRepository.save(product);
    }

    @Override
    @Transactional
    public Optional<Product> findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        checkingForNull(product);
        return product;
    }

    @Override
    public Optional<Product> readByName(String name) {
        Optional<Product> product = productRepository.readByName(name);
        checkingForNull(product);
        return product;
    }

    private Optional<Product> checkingForNull(Optional<Product> product) {
        if (product.isEmpty()) {
            throw new AppException(ErrorCode.PRODUCT_NOT_FOUND, new Object());
        }
        return product;
    }
}