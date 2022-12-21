package clevertech.com.esm.controller;

import clevertech.com.esm.service.CustomerService;
import clevertech.com.esm.service.dto.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> readById(@PathVariable Long id) throws Exception {
        CustomerDTO customerDTO = customerService.findById(id);
        createLinks(customerDTO);
        return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> create(@RequestBody CustomerDTO customerDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.save(customerDTO));
    }

    private void createLinks(CustomerDTO customerDTO) throws Exception {
        customerDTO.add(linkTo(methodOn(CustomerController.class).readById(customerDTO.getCustomer_id())).withSelfRel());
        customerDTO.add(linkTo(methodOn(CustomerController.class).create(new CustomerDTO())).withRel("customer link -> create"));
    }
}