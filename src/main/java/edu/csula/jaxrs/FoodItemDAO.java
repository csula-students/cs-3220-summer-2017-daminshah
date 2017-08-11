package edu.csula.jaxrs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import edu.csula.jaxrs.models.FoodItem;

public class FoodItemDAO implements DAOResource<FoodItem> {
    public List<FoodItem> list() {
        List<FoodItem> list = new ArrayList<>();
        DatabaseResource db = new DatabaseResource();
        try (Connection c = db.connection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM menu");
            while (rs.next()) {
                list.add(new FoodItem(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("imgURL"),
                 rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }

    public Optional<FoodItem> get(int id) {
        Optional<FoodItem> lab7items = Optional.empty();
        DatabaseResource db = new DatabaseResource();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("SELECT * FROM menu WHERE menu.id = ? ");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                FoodItem edifood = new FoodItem(rs.getInt("id"),
                                                    rs.getString("name"),
                                                    rs.getString("description"),
                                                    rs.getString("imgURL"),
                                                     rs.getDouble("price"));
                lab7items = Optional.of(edifood);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lab7items;
    }

    public void add(FoodItem obj) {
        DatabaseResource db = new DatabaseResource();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO menu (id, name, description, imgURL, price) VALUES (?, ?, ?, ?, ?)");
            pstmt.setInt(1, obj.getId());
            pstmt.setString(2, obj.getName());
            pstmt.setString(3, obj.getDescription());
            pstmt.setString(4, obj.getImgURL());
            pstmt.setDouble(5,  obj.getPrice());
           
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(FoodItem obj) {
        DatabaseResource db = new DatabaseResource();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("UPDATE menu SET id = ?, name = ?, description = ?, imgURL = ?, price = ? WHERE id = ?");
            pstmt.setInt(1, obj.getId());
            pstmt.setString(2, obj.getName());
            pstmt.setString(3, obj.getDescription());
            pstmt.setString(4, obj.getImgURL());
            pstmt.setDouble(5,  obj.getPrice());
            pstmt.setInt(6, obj.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        DatabaseResource db = new DatabaseResource();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("DELETE FROM menu WHERE menu.id = ? ");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}