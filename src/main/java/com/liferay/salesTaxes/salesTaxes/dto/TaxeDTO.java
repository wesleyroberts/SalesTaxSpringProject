package com.liferay.salesTaxes.salesTaxes.dto;

import com.liferay.salesTaxes.salesTaxes.domain.Tax;
import lombok.Getter;

@Getter
public class TaxeDTO {
    private String name;
    private Double value;


    TaxeDTO(){ }

    public TaxeDTO(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public Tax parseTax(){
        return new Tax(getName(),getValue());
    }
}
