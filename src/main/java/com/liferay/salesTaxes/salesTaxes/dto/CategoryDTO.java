package com.liferay.salesTaxes.salesTaxes.dto;

import com.liferay.salesTaxes.salesTaxes.domain.Category;
import lombok.Getter;

@Getter
public class CategoryDTO {
    private String name;
    private Double value;

    public CategoryDTO(){

    }
    public CategoryDTO(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public Category parseCategory(){
        return new Category(getName(),getValue());
    }
}
