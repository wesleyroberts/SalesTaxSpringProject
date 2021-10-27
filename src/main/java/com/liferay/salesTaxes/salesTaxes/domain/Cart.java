package com.liferay.salesTaxes.salesTaxes.domain;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    private double totalTaxes;
    private double totalValue;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Product> productList = new ArrayList<Product>();

    public Cart(){
    }

    public Cart(double totalTaxes, double totalValue, List<Product> productList) {
        this.totalTaxes = totalTaxes;
        this.totalValue = totalValue;
        this.productList = productList;
    }
}
