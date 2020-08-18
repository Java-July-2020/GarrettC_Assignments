package com.productsAndCategories.garrett.repositories;

import org.springframework.data.repository.CrudRepository;

import com.productsAndCategories.garrett.models.CategoryProduct;

public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {

}
