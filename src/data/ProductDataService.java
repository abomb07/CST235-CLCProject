/*Adam Bender
Tyler Wiggins
Milestone 3
March 13, 2020
Product Data Service*/

package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Database;
import beans.Products;

public class ProductDataService {
	
	private Database connection = null;
	
	/**
	 * Non defualt constructor takes database parameter
	 * @param connection
	 */
	public ProductDataService(Database connection) 
	{
		this.connection = connection;
	}

	/**
	 * Insert product to database
	 * @param product
	 * @return boolean
	 */
	public boolean createProduct(Products product) {
		Connection conn = null;

		// tries connecting to the database and entering the product data into a
		// database table,
		// but prints an error message if it fails to connect or insert the data.
		try {
			// get database connection
			conn = DriverManager.getConnection(connection.getUrl(), connection.getUser(), connection.getPass());
			String sql = "INSERT INTO milestone.tbl_products(name, price, image, category, short_description, long_description, quantity) VALUES (?, ?, ?, ?, ?, ?, ?)";

			// prepare sql statement
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, product.getName());
			stmt.setFloat(2, product.getPrice());
			stmt.setString(3, product.getImage());
			stmt.setString(4, product.getCategory());
			stmt.setString(5, product.getShort_description());
			stmt.setString(6, product.getLong_description());
			stmt.setInt(7, product.getQuantity());

			if (stmt.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}

		}
		// prints error message if fails to connect or insert data into the database
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Find all products in the products database table
	 * @return List<Products>
	 */
	public List<Products> findAllProducts() 
	{
		Connection conn = null;

		List<Products> products = new ArrayList<Products>();
		try {
			conn = DriverManager.getConnection(connection.getUrl(), connection.getUser(), connection.getPass());
			String sql = "SELECT * FROM milestone.tbl_products";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				products.add(new Products(rs.getInt("id"), rs.getString("name"), rs.getFloat("price"), rs.getString("image"), rs.getString("category"), rs.getString("short_description"), rs.getString("long_description"), rs.getInt("quantity")));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return products;
	}
	
	public Products findByID(int id) 
	{
		Connection conn = null;
		Products p1 = null;
		
		try {
			conn = DriverManager.getConnection(connection.getUrl(), connection.getUser(), connection.getPass());
			String sql = "SELECT id, name, price, image, category, short_description, long_description, quantity FROM milestone.tbl_products WHERE ID = ?";
			
			//bind id to sql statement
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
			//execute query
			ResultSet rs = stmt.executeQuery();

			//create new product model of result
			while(rs.next())
			{
				p1 = new Products(rs.getInt("id"), rs.getString("name"), rs.getFloat("price"), rs.getString("image"), rs.getString("category"), rs.getString("short_description"), rs.getString("long_description"), rs.getInt("quantity"));
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return p1;
	}
	
	public boolean updateProduct(Products product) 
	{
		Connection conn = null;

		// tries connecting to the database and entering the product data into a
		// database table,
		// but prints an error message if it fails to connect or insert the data.
		try {
			// get database connection
			conn = DriverManager.getConnection(connection.getUrl(), connection.getUser(), connection.getPass());
			String sql = "UPDATE milestone.tbl_products SET name = ?, price = ?, image = ?, category = ?, short_description = ?, long_description = ?, quantity = ? WHERE id = ?";

			// prepare sql statement
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, product.getName());
			stmt.setFloat(2, product.getPrice());
			stmt.setString(3, product.getImage());
			stmt.setString(4, product.getCategory());
			stmt.setString(5, product.getShort_description());
			stmt.setString(6, product.getLong_description());
			stmt.setInt(7, product.getQuantity());
			stmt.setInt(8, product.getId());

			if (stmt.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}

		}
		// prints error message if fails to connect or insert data into the database
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteProduct(int id) 
	{
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(connection.getUrl(), connection.getUser(), connection.getPass());
			String sql = "DELETE FROM milestone.tbl_products WHERE id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			if(stmt.executeUpdate() > 0)
			{
				return true;
			}
			else{
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
	}
}
