package com.liferay.salesTaxes.salesTaxes.domain;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
public class Tax implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private Double value;

    public Tax(){}

    public Tax(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tax taxe = (Tax) o;
        return Objects.equals(id, taxe.id) && Objects.equals(name, taxe.name) && Objects.equals(value, taxe.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, value);
    }

}
