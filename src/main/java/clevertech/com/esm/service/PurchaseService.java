package clevertech.com.esm.service;

import clevertech.com.esm.entities.Purchase;
import clevertech.com.esm.service.dto.PurchaseDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PurchaseService {
    PurchaseDTO save(PurchaseDTO purchaseDTO) throws Exception;

    PurchaseDTO findById(Long id) throws Exception;

    Optional<Purchase> readByName(String name) throws Exception;

    Double calculateTotalCost(Long id) throws Exception;
}