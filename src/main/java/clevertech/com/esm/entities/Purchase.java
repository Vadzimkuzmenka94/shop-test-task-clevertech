package clevertech.com.esm.entities;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Component
@Entity
@Table(name = "purchases", schema = "public")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "create_date")
    private LocalDateTime createDate;
    @Column(name = "total_cost")
    private Double totalCost;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "purchases_products",
            joinColumns = @JoinColumn(name = "purchase_id_fk", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id_fk", referencedColumnName = "id"))
    private List<Product> products;

    public Purchase(Long id, LocalDateTime createDate, Double totalCost) {
        this.id = id;
        this.createDate = createDate;
        this.totalCost = totalCost;
    }

    public Purchase() {
    }

    @PrePersist
    public void prePersist() {
        this.createDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}