package com.productsAndCategories.garrett.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.productsAndCategories.garrett.models.CategoryProduct;
import com.productsAndCategories.garrett.services.MainService;

@Controller
public class CategoryProductController {
	
	@Autowired
	private MainService mainService;
	
	@PostMapping("/categories_products/{kind}")
	public String Create(@Valid @ModelAttribute("categories_products") CategoryProduct categoryProduct, BindingResult result, @PathVariable("kind") String kind) {
		if(result.hasErrors())
			return String.format("/%s/show.jsp", kind);
		mainService.createCategoryProduct(categoryProduct);
		return "redirect:/";
	}

}
