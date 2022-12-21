package clevertech.com.esm.service.serviceImplementation;

import clevertech.com.esm.entities.Purchase;
import clevertech.com.esm.exceptions.AppException;
import clevertech.com.esm.exceptions.ErrorCode;
import clevertech.com.esm.repository.PurchaseRepository;
import clevertech.com.esm.service.PurchaseService;
import clevertech.com.esm.service.dto.PurchaseDTO;
import clevertech.com.esm.service.mapper.mapperImpementation.PurchaseMapperImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PurchaseServiceImplementation implements PurchaseService {
    private final PurchaseMapperImplementation purchaseMapperImplementation;
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseServiceImplementation(PurchaseMapperImplementation purchaseMapperImplementation, PurchaseRepository purchaseRepository) {
        this.purchaseMapperImplementation = purchaseMapperImplementation;
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public PurchaseDTO save(PurchaseDTO purchaseDTO) throws Exception {
        Purchase purchaseInDb = purchaseRepository.save(purchaseMapperImplementation.mapToEntity(purchaseDTO));
        return purchaseMapperImplementation.mapToDto(purchaseInDb);
    }

    @Override
    @Transactional
    public PurchaseDTO findById(Long id) throws Exception {
        Optional<Purchase> purchase = purchaseRepository.findById(id);
        checkingForNull(purchase);
        return purchaseMapperImplementation.mapToDto(purchase.orElse(null));
    }

    @Override
    public Optional<Purchase> readByName(String name) {
        Optional<Purchase> purchase = purchaseRepository.readByName(name);
        checkingForNull(purchase);
        return purchase;
    }

    @Override
    public Double calculateTotalCost(Long id) {
        Double totalCost = purchaseRepository.calculateTotalCost(id);
        if (totalCost == null) {
            totalCost = new Double(0);
        }
        return totalCost;
    }

    private Optional<Purchase> checkingForNull(Optional<Purchase> purchase) {
        if (purchase.isEmpty()) {
            throw new AppException(ErrorCode.PURCHASE_NOT_FOUND, new Object());
        }
        return purchase;
    }
}