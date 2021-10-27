package com.liferay.salesTaxes.salesTaxes.domain;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private Double price;
    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToOne
    @JoinColumn(name = "taxe_id")
    private Tax taxe;

    public Product(){}
    public Product(String name, Double price, Category category, Tax taxe) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.taxe = taxe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(category, product.category) && Objects.equals(taxe, product.taxe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, category, taxe);
    }

}
