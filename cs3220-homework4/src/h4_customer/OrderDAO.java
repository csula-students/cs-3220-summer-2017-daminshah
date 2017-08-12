package h4_customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import h4_admin.DAO;
import h4_admin.Database;

public class OrderDAO implements DAO<Order> {

	@Override
	public List<Order> list() {
		// TODO Auto-generated method stub
		List<Order> orderlist = new ArrayList<>();
		Database db = new Database();
		try (Connection c = db.connection()) {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM orders");
			while (rs.next()) {
				orderlist.add(new Order(rs.getInt("id"), rs.getString("item"),rs.getDouble("price"), rs.getString("customer"), rs.getString("status")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return orderlist;
	}

	@Override
	public Optional<Order> get(int id) {
		// TODO Auto-generated method stub
		Optional<Order> list = Optional.empty();
		Database db = new Database();

		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement("SELECT * FROM orders WHERE orders.id = ? ");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Order newfood = new Order(rs.getInt("id"), rs.getString("item"),	rs.getDouble("price"), rs.getString("customer"), rs.getString("status"));
				list = Optional.of(newfood);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void add(Order obj) {
		// TODO Auto-generated method stub
		Database db = new Database();
		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement("INSERT INTO orders (item,price,customer,status) VALUES (?,?,?,?)");
			pstmt.setString(1, obj.getName());
			pstmt.setDouble(2, obj.getFoodprice());
			pstmt.setString(3, obj.getCustomername());
			pstmt.setString(4, obj.getStatus());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Order obj) {
		// TODO Auto-generated method stub
		Database db = new Database();
		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement("UPDATE orders SET  item = ?, price = ?, customer = ?, status = ? WHERE id = ?");
			pstmt.setString(1, obj.getName());
			pstmt.setDouble(2, obj.getFoodprice());
			pstmt.setString(3, obj.getCustomername());
			pstmt.setString(4, obj.getStatus());
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
			PreparedStatement pstmt = c.prepareStatement("DELETE FROM orders WHERE orders.id = ? ");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
