package clevertech.com.esm.service;

import clevertech.com.esm.service.dto.CustomerDTO;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    CustomerDTO save(CustomerDTO customerDTO);
    CustomerDTO findById(Long id) throws Exception;
}