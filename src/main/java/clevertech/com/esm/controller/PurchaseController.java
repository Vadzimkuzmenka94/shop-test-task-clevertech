package clevertech.com.esm.controller;

import clevertech.com.esm.service.PurchaseService;
import clevertech.com.esm.service.dto.CustomerDTO;
import clevertech.com.esm.service.dto.PurchaseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<PurchaseDTO> create(@RequestBody PurchaseDTO purchaseDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(purchaseService.save(purchaseDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseDTO> readById(@PathVariable Long id) throws Exception {
        PurchaseDTO purchaseDTO = purchaseService.findById(id);
        createLinks(purchaseDTO);
        return ResponseEntity.status(HttpStatus.OK).body(purchaseDTO);
    }

    private void createLinks(PurchaseDTO purchaseDTO) throws Exception {
        purchaseDTO.add(linkTo(methodOn(PurchaseController.class).readById(purchaseDTO.getPurchaseId())).withSelfRel());
        purchaseDTO.add(linkTo(methodOn(PurchaseController.class).create(new PurchaseDTO())).withRel("purchase link -> create"));
    }
}