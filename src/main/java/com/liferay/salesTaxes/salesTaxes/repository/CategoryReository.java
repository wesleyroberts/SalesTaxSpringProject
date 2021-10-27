package com.liferay.salesTaxes.salesTaxes.repository;

import com.liferay.salesTaxes.salesTaxes.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CategoryReository extends JpaRepository<Category,Long> {

}
