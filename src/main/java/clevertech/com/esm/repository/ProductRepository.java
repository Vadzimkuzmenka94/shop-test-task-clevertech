package clevertech.com.esm.repository;

import clevertech.com.esm.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository <Product, Long> {
    @Query(value = "SELECT * FROM public.product WHERE product_name = ?1 LIMIT 1", nativeQuery = true)
    Optional<Product> readByName(String name);
}