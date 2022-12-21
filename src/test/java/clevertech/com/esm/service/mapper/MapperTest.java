package clevertech.com.esm.service.mapper;

import clevertech.com.esm.entities.Customer;
import clevertech.com.esm.service.dto.CustomerDTO;
import clevertech.com.esm.service.mapper.mapperImpementation.CustomerMapperImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MapperTest {
    private static final long CORRECT_ID = 1;
    private static final String CUSTOMER_NAME = "name";
    private static final String CUSTOMER_SURNAME = "surname";
    private Customer customer;
    private CustomerDTO customerDTO;

    @Mock
    CustomerMapperImplementation customerMapperImplementation;

    @BeforeEach
    public void setUp() {
        LocalDateTime now = LocalDateTime.now();
        customer = new Customer(CORRECT_ID, CUSTOMER_NAME, CUSTOMER_SURNAME);
        customerDTO = new CustomerDTO(CORRECT_ID, CUSTOMER_NAME, CUSTOMER_SURNAME, Collections.EMPTY_LIST);
    }

    @Test
    public void mapCustomerFromDataTest() {
        when(customerMapperImplementation.mapToDto(customer)).thenReturn(customerDTO);
        CustomerDTO testCustomerDTO = customerMapperImplementation.mapToDto(customer);
        Assertions.assertEquals(customerDTO, testCustomerDTO);
    }

    @Test
    public void mapCertificateToDataTest() {
        when(customerMapperImplementation.mapToEntity(customerDTO)).thenReturn(customer);
        Customer customer = customerMapperImplementation.mapToEntity(customerDTO);
        Assertions.assertEquals(customerDTO.getName(), customer.getName());
        Assertions.assertEquals(customerDTO.getSurname(), customer.getSurname());
        Assertions.assertEquals(customerDTO.getPurchaseList(), customerDTO.getPurchaseList());
    }
}