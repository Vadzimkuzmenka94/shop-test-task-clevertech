package clevertech.com.esm.entities;

import clevertech.com.esm.service.dto.CustomerDTO;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customers", schema = "public")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customer_id;
    @Column(name = "customer_name")
    private String name;
    @Column(name = "customer_surname")
    private String surname;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "customers_purchases",
            joinColumns = @JoinColumn(name = "customer_id_fk", referencedColumnName = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "purchases_id_fk", referencedColumnName = "id"))
    List<Purchase> purchaseList;

    public Customer() {
    }

    public Customer(Long customer_id, String name, String surname, List<Purchase> purchaseList) {
        this.customer_id = customer_id;
        this.name = name;
        this.surname = surname;
        this.purchaseList = purchaseList;
    }

    public Customer(Long customer_id, String name, String surname) {
        this.customer_id = customer_id;
        this.name = name;
        this.surname = surname;
    }

    public Customer(CustomerDTO dto) {
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long id) {
        this.customer_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customer_id, customer.customer_id) && Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname) && Objects.equals(purchaseList, customer.purchaseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer_id, name, surname, purchaseList);
    }
}