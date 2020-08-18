package com.productsAndCategories.garrett.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.productsAndCategories.garrett.models.Category;
import com.productsAndCategories.garrett.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);
}
