package com.productsAndCategories.garrett.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productsAndCategories.garrett.models.Category;
import com.productsAndCategories.garrett.models.CategoryProduct;
import com.productsAndCategories.garrett.models.Product;
import com.productsAndCategories.garrett.repositories.CategoryProductRepository;
import com.productsAndCategories.garrett.repositories.CategoryRepository;
import com.productsAndCategories.garrett.repositories.ProductRepository;

@Service
public class MainService {
	public final ProductRepository productRepo;
	public final CategoryRepository categoryRepo;
	public final CategoryProductRepository cpRepo;
	
	public MainService(ProductRepository productRepo, CategoryRepository categoryRepo, CategoryProductRepository cpRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
		this.cpRepo = cpRepo;
	}
	
	public List<Product> findProducts() {
		return this.productRepo.findAll();
	}
	
	public Product getProduct(Long id) {
		return this.productRepo.findById(id).orElse(null);
	}
	
	public List<Category> findCategories() {
		return this.categoryRepo.findAll();
	}
	
	public Category getCategory(Long id) {
		return this.categoryRepo.findById(id).orElse(null);
	}
	
	public Product createProduct(Product product) {
		return this.productRepo.save(product);
	}
	
	public void deleteProduct(Long id) {
		this.productRepo.deleteById(id);
	}
	
	public Product updateProduct(Product product) {
		return this.productRepo.save(product);
	}
	
	public Category createCategory(Category category) {
		return this.categoryRepo.save(category);
	}
	
	public void deleteCategory(Long id) {
		this.categoryRepo.deleteById(id);
	}
	
	public Category updateCategory(Category category) {
		return this.categoryRepo.save(category);
	}
	
	public List<Category> findCategoriesNotInProduct(Product product) {
		return categoryRepo.findByProductsNotContains(product);
	}
	
	public List<Product> findProductsNotInCategory(Category category) {
		return productRepo.findByCategoriesNotContains(category);
	}
	
	public CategoryProduct createCategoryProduct(CategoryProduct categoryProduct) {
		return this.cpRepo.save(categoryProduct);
	}
	
}