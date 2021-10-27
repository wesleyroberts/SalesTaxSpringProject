package com.liferay.salesTaxes.salesTaxes.repository;

import com.liferay.salesTaxes.salesTaxes.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
