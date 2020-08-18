package com.productsAndCategories.garrett.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.productsAndCategories.garrett.models.Category;
import com.productsAndCategories.garrett.models.Product;

public interface CategoryRepository extends CrudRepository <Category, Long> {
	
	List<Category> findAll();
	List<Category> findByProductsNotContains(Product product);
}
