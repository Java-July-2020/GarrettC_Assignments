package com.productsAndCategories.garrett.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.productsAndCategories.garrett.models.Category;
import com.productsAndCategories.garrett.models.CategoryProduct;
import com.productsAndCategories.garrett.models.Product;
import com.productsAndCategories.garrett.services.MainService;

@Controller
public class ProductController {
	
	@Autowired
	private MainService mainService;
	
	@RequestMapping("/products")
	public String products(Model model) {
		List<Product> products = this.mainService.findProducts();
		model.addAttribute("products", products);
		return "products/product.jsp";
	}
	
	@RequestMapping("/categories")
		public String categories(Model model) {
			List<Category> categories = this.mainService.findCategories();
			model.addAttribute("categories", categories);
			return "categories/category.jsp";
		}
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product, Model model) {
		model.addAttribute("product", product);
		return "products/new.jsp";
	}
	
	@GetMapping("/")
	public String Index(Model model) {
		model.addAttribute("products", mainService.findProducts());
		return "products/index.jsp";
	}
	
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category, Model model) {
		model.addAttribute("category", category);
		return "categories/new.jsp";
	}
	
	@GetMapping("/{id}")
	public String Show(@ModelAttribute("categories_products") CategoryProduct categoryProduct, 
		@PathVariable("id") Long id, Model model) {
		Product thisOne = mainService.getProduct(id);
		List<Category> others = mainService.findCategoriesNotInProduct(thisOne);
		model.addAttribute("product", thisOne);
		model.addAttribute("notInCategories", others);
		return "products/show.jsp";
	}

}
