package h4_admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class FoodItemDAO implements DAO<FoodItem> {

	@Override
	public List<FoodItem> list() {
		List<FoodItem> list = new ArrayList<>();
		Database db = new Database();
		try (Connection c = db.connection()) {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM food_items");
			while (rs.next()) {
				list.add(new FoodItem(rs.getInt("id"), rs.getString("item"), rs.getString("description"),
						rs.getString("image"), rs.getDouble("price")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Optional<FoodItem> get(int id) {
		Optional<FoodItem> hw4items = Optional.empty();
		Database db = new Database();

		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement("SELECT * FROM food_items WHERE food_items.id = ? ");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				FoodItem editFood = new FoodItem(rs.getInt("id"), rs.getString("item"),rs.getString("description"), rs.getString("image"), rs.getDouble("price"));
				hw4items = Optional.of(editFood);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hw4items;
	}

	@Override
	public void add(FoodItem obj) {
		// TODO Auto-generated method stub
		Database db = new Database();
		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement("INSERT INTO food_items (item, description,image,price) VALUES (?,?,?,?)");
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
		
		Database db = new Database();
		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement("UPDATE food_items SET  item = ?, description = ?, image = ?, price = ? WHERE id = ?");
			pstmt.setString(1, obj.getName());
			pstmt.setString(2, obj.getDescription());
			pstmt.setString(3, obj.getUrl());
			pstmt.setDouble(4, obj.getPrice());
			pstmt.setInt(5, obj.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
		Database db = new Database();
		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement("DELETE FROM food_items WHERE food_items.id = ? ");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
