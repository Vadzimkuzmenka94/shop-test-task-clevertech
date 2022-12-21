package clevertech.com.esm.service.serviceImplementation;

import clevertech.com.esm.entities.Customer;
import clevertech.com.esm.exceptions.AppException;
import clevertech.com.esm.exceptions.ErrorCode;
import clevertech.com.esm.repository.CustomerRepository;
import clevertech.com.esm.service.CustomerService;
import clevertech.com.esm.service.dto.CustomerDTO;
import clevertech.com.esm.service.mapper.mapperImpementation.CustomerMapperImplementation;
import clevertech.com.esm.service.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService {
    private final CustomerMapperImplementation customerMapperImplementation;
    private final CustomerRepository customerRepository;
    private final CustomerValidator customerValidator;

    @Autowired
    public CustomerServiceImplementation(CustomerMapperImplementation customerMapperImplementation, CustomerRepository customerRepository, CustomerValidator customerValidator) {
        this.customerMapperImplementation = customerMapperImplementation;
        this.customerRepository = customerRepository;
        this.customerValidator = customerValidator;
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        customerValidator.validate(customerDTO);
        Customer customerInDb = customerRepository.save(customerMapperImplementation.mapToEntity(customerDTO));
        return customerMapperImplementation.mapToDto(customerInDb);
    }

    @Override
    public CustomerDTO findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        checkingForNull(customer);
        return customerMapperImplementation.mapToDto(customer.orElse(null));
    }

    private Optional<Customer> checkingForNull(Optional<Customer> customer) {
        if (customer.isEmpty()) {
            throw new AppException(ErrorCode.CUSTOMER_NOT_FOUND, new Object());
        }
        return customer;
    }
}