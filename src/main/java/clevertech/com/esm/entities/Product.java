package clevertech.com.esm.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "products", schema = "public")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_coast")
    private Double productCoast;
    @Column(name = "promotional_product")
    private Boolean promotionalProduct;
    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    public Product(String productName, Double productCoast, Boolean promotionalProduct) {
        this.productName = productName;
        this.productCoast = productCoast;
        this.promotionalProduct = promotionalProduct;
    }

    public Product() {
    }

    public Long getProductId() {
        return id;
    }

    public void setProductId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductCoast() {
        return productCoast;
    }

    public void setProductCoast(Double productCoast) {
        this.productCoast = productCoast;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isPromotionalProduct() {
        return promotionalProduct;
    }

    public void setPromotionalProduct(Boolean promotionalProduct) {
        this.promotionalProduct = promotionalProduct;
    }
}