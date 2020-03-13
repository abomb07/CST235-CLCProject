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
	 * @return
	 */
	public boolean createProduct(Products product) {
		Connection conn = null;

		// tries connecting to the database and entering the product data into a
		// database table,
		// but prints an error message if it fails to connect or insert the data.
		try {
			// get database connection
			conn = DriverManager.getConnection(connection.getUrl(), connection.getUser(), connection.getPass());
			String sql = "INSERT INTO milestone.tbl_products(name, price, image, category, short_description, long_description, 							quantity) VALUES (?, ?, ?, ?, ?, ?, ?)";

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
	 * @return
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
				products.add(new Products(-1, rs.getString("name"), rs.getFloat("price"), rs.getString("image"), 				rs.getString("category"), rs.getString("short_description"), rs.getString("long_description"), 				rs.getInt("quantity")));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return products;
	}
}
