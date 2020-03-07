package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import beans.Products;
import business.ProductBusinessService;

@ManagedBean
@ViewScoped
public class ProductController 
{
	@Inject
	ProductBusinessService pbs;
	
	public String addProduct(Products product) 
	{
		pbs.addProduct(product);
		
		return "MainProductPage.xhtml";
	}

	public ProductBusinessService getPbs() {
		return pbs;
	}
}
