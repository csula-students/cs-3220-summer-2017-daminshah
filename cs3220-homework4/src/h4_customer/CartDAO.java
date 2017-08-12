package h4_customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import h4_admin.DAO;
import h4_admin.FoodItem;
import h4_admin.Database;


public class CartDAO implements DAO<FoodItem> {

	@Override
	public List<FoodItem> list() {
		// TODO Auto-generated method stub
		List<FoodItem> list_cart = new ArrayList<>();
		Database db = new Database();
		try (Connection c = db.connection()) {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM carts");
			while (rs.next()) {
				list_cart.add(
						new FoodItem(rs.getInt("id"), rs.getString("item"), rs.getString("description"),
								rs.getString("url"), rs.getDouble("price")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return list_cart;
		}
		return list_cart;

	}

	@Override
	public Optional<FoodItem> get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(FoodItem obj) {
		// TODO Auto-generated method stub
		Database db = new Database();
		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement(
					"INSERT INTO carts (item, description,url,price) VALUES (?,?,?,?)");
			pstmt.setString(1, obj.getName());
			pstmt.setString(2, obj.getDescription());
			pstmt.setString(3, obj.getUrl());
			pstmt.setDouble(4, obj.getPrice());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(FoodItem obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Database db = new Database();
		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement("DELETE FROM carts WHERE carts.id = ? ");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
