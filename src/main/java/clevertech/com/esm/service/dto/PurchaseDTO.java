package clevertech.com.esm.service.dto;

import clevertech.com.esm.entities.Product;
import clevertech.com.esm.entities.Purchase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDTO extends RepresentationModel<PurchaseDTO> {
    private long purchaseId;
    private LocalDateTime createDate;
    private Double totalCost;
    private List<Product> products;

    public PurchaseDTO(long purchaseId, LocalDateTime createDate) {
        this.purchaseId = purchaseId;
        this.createDate = createDate;
    }

    public PurchaseDTO(Purchase purchase) {
    }
}