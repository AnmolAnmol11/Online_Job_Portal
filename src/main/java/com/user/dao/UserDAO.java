package com.user.dao;




import com.user.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    // Create a new user
    public boolean createUser(User user) throws SQLException {
        String query = "INSERT INTO users (username, password, email, role, contact_number) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getRole());
        ps.setString(5, user.getContactNumber());
        return ps.executeUpdate() > 0;
    }

    // Get user by ID
    public User getUserById(int userId) throws SQLException {
        String query = "SELECT * FROM users WHERE user_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new User(
                rs.getInt("user_id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("email"),
                rs.getString("role"),
                rs.getString("contact_number")
            );
        }
        return null;
    }

    // Get all users
    public List<User> getAllUsers() throws SQLException {
        String query = "SELECT * FROM users";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            users.add(new User(
                rs.getInt("user_id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("email"),
                rs.getString("role"),
                rs.getString("contact_number")
            ));
        }
        return users;
    }
}
