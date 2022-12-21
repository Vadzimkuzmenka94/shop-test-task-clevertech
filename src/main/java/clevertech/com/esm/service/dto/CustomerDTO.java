package clevertech.com.esm.service.dto;

import clevertech.com.esm.entities.Customer;
import clevertech.com.esm.entities.Purchase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO extends RepresentationModel<CustomerDTO> {
    private Long customer_id;
    private String name;
    private String surname;
    List<Purchase> purchaseList;

    public CustomerDTO(Long customer_id, String name, String surname) {
        this.customer_id = customer_id;
        this.name = name;
        this.surname = surname;
    }

    public CustomerDTO(Customer customer) {
    }
}