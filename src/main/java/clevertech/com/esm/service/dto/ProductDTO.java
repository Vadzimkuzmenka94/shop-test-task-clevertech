package clevertech.com.esm.service.dto;

import clevertech.com.esm.entities.Purchase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO extends RepresentationModel<ProductDTO> {
    private long productId;
    private String productName;
    private Double productCoast;
    private boolean promotionalProduct;
    private Purchase purchase;
}