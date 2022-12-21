package clevertech.com.esm.controller;

import clevertech.com.esm.entities.Product;
import clevertech.com.esm.service.ProductService;
import clevertech.com.esm.service.dto.CustomerDTO;
import clevertech.com.esm.service.dto.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> readById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.create(product));
    }
}