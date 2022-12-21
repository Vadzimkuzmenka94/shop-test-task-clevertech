package clevertech.com.esm.service.mapper.mapperImpementation;

import clevertech.com.esm.entities.Customer;
import clevertech.com.esm.service.CustomerService;
import clevertech.com.esm.service.dto.CustomerDTO;
import clevertech.com.esm.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapperImplementation implements Mapper<Customer, CustomerDTO> {
    private final CustomerService customerService;

    @Lazy
    @Autowired
    public CustomerMapperImplementation(CustomerService customerService) {
        this.customerService = customerService;
    }


    @Override
    public CustomerDTO mapToDto(Customer entity) {
        CustomerDTO customerDTO = new CustomerDTO(entity);
        customerDTO.setCustomer_id(entity.getCustomer_id());
        customerDTO.setName(entity.getName());
        customerDTO.setSurname(entity.getSurname());
        customerDTO.setPurchaseList(entity.getPurchaseList());
        return customerDTO;
    }

    @Override
    public Customer mapToEntity(CustomerDTO dto) {
        Customer customer = new Customer(dto);
        customer.setCustomer_id(dto.getCustomer_id());
        customer.setName(dto.getName());
        customer.setSurname(dto.getSurname());
        customer.setPurchaseList(dto.getPurchaseList());
        return customer;
    }
}