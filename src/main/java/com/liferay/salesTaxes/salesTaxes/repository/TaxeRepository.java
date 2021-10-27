package com.liferay.salesTaxes.salesTaxes.repository;

import com.liferay.salesTaxes.salesTaxes.domain.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxeRepository extends JpaRepository<Tax,Long> {
}
