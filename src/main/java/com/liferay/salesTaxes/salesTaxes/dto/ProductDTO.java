package com.liferay.salesTaxes.salesTaxes.dto;

import com.liferay.salesTaxes.salesTaxes.domain.Category;
import com.liferay.salesTaxes.salesTaxes.domain.Product;
import com.liferay.salesTaxes.salesTaxes.domain.Tax;
import com.liferay.salesTaxes.salesTaxes.repository.CategoryReository;
import com.liferay.salesTaxes.salesTaxes.repository.TaxeRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
@Getter
public class ProductDTO {
    private String name;
    private Double price;
    private Long categoryId;
    private Long taxeId;

    @Autowired
    CategoryReository categoryReository;

    @Autowired
    TaxeRepository taxeRepository;

    public ProductDTO(){

    }

    public ProductDTO(String name, Double price, Long categoryId, Long taxeId) {
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.taxeId = taxeId;
    }

    public Product parseProduct(Category category,Tax tax){
        return new Product(getName(),getPrice(),category,tax);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(categoryId, that.categoryId) && Objects.equals(taxeId, that.taxeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, categoryId, taxeId);
    }
}
