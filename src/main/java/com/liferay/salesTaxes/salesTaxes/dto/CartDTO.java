package com.liferay.salesTaxes.salesTaxes.dto;

import com.liferay.salesTaxes.salesTaxes.domain.Cart;
import com.liferay.salesTaxes.salesTaxes.domain.Product;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CartDTO {
    private double totalTaxes;
    private double totalValue;
    private List<Product> productList = new ArrayList<Product>();

    public CartDTO(){

    }

    public CartDTO(double totalTaxes, double totalValue, List<Product> productList) {
        this.totalTaxes = totalTaxes;
        this.totalValue = totalValue;
        this.productList = productList;
    }

    public Cart parseCart (){
        return new Cart(getTotalValue(),getTotalValue(),getProductList());
    }
}
