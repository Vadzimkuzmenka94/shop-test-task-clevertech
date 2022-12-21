package clevertech.com.esm.service.mapper.mapperImpementation;

import clevertech.com.esm.entities.Product;
import clevertech.com.esm.entities.Purchase;
import clevertech.com.esm.service.PurchaseService;
import clevertech.com.esm.service.dto.PurchaseDTO;
import clevertech.com.esm.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseMapperImplementation implements Mapper<Purchase, PurchaseDTO> {
    private final PurchaseService purchaseService;

    @Lazy
    @Autowired
    public PurchaseMapperImplementation(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @Override
    public PurchaseDTO mapToDto(Purchase entity) throws Exception {
        PurchaseDTO purchaseDTO = new PurchaseDTO(entity);
        purchaseDTO.setPurchaseId(entity.getId());
        purchaseDTO.setCreateDate(entity.getCreateDate());
        purchaseDTO.setProducts(entity.getProducts());
        if (entity.getProducts().size() <= 5) {
            purchaseDTO.setTotalCost(purchaseService.calculateTotalCost(purchaseDTO.getPurchaseId()));
        } else {
            purchaseDTO.setTotalCost(purchaseService.calculateTotalCost(purchaseDTO.getPurchaseId()) * 0.9);
        }
        return purchaseDTO;
    }

    @Override
    public Purchase mapToEntity(PurchaseDTO purchaseDTO) throws Exception  {
        Purchase purchase = new Purchase();
        purchase.setId(purchaseDTO.getPurchaseId());
        purchase.setCreateDate(purchase.getCreateDate());
        purchase.setProducts(purchaseDTO.getProducts());
        if (checkForDiscount(purchaseDTO.getProducts()) == true) {
            purchase.setTotalCost(purchaseService.calculateTotalCost(purchaseDTO.getPurchaseId()));
        } else {
            purchase.setTotalCost(purchaseService.calculateTotalCost(purchaseDTO.getPurchaseId()) * 0.9);
        }
        return purchase;
    }

    public boolean checkForDiscount(List<Product> productList) {
        boolean getDiscount = false;
        int count = 0;
        for (int i = 0; i < productList.size() - 1; i++) {
            if (productList.get(i).isPromotionalProduct() == true) {
                count++;
            }
        }
        if (count > 5) {
            getDiscount = true;
        }
        return getDiscount;
    }
}