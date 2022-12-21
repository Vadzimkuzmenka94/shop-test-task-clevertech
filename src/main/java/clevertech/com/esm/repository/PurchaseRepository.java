package clevertech.com.esm.repository;

import clevertech.com.esm.entities.Purchase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
    @Query(value = "SELECT * FROM public.purchases WHERE purchase_name = ?1", nativeQuery = true)
    Optional<Purchase> readByName(String name);

    @Query(value = "SELECT SUM(product_coast) from products left join purchases_products pp on products.id = pp.product_id_fk " +
            "where pp.purchase_id_fk = ?1", nativeQuery = true)
    Double calculateTotalCost(Long id);
}