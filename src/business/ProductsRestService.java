package business;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Products;

@RequestScoped
@Path("/products")
@Produces({ "application/json" })
@Consumes({ "application/json" })
public class ProductsRestService 
{
	@Inject
	ProductBusinessService service;
	
	@GET
	@Path("/getAllProducts")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Products> getProductsAsJson()
	{
		return service.findAllProducts();
	}
}
