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
	
	//add product function
	public String addProduct(Products product) 
	{
		//if the product successfully adds, it well take the user to the main product page.
		if(pbs.addProduct(product))
		{
			return "MainProductPage.xhtml";
		}
		//if product fails to add, it will take the user to the failed page.
		else
		{
			return "FailPage.xhtml";
		}
	}

	public ProductBusinessService getPbs() {
		return pbs;
	}
}
