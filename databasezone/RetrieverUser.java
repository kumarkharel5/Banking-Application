package databasezone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class RetrieverUser implements UserDao {
	int id;
	
	Scanner scan = new Scanner(System.in);

	private User extractUser(ResultSet rs) throws SQLException {
		User user = new User();

		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setPass(rs.getString("password"));
		user.setAge(rs.getInt("age"));

		return user;
	}

	public User getUser(int id) {
		Connection conn = JDBCConnection.getConnection();
		Statement stmt;

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from Persons where id=" + id);

			if (rs.next()) {
				extractUser(rs);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public List<User> getUserByUserNameAndPassword(String user, String pass) {
		Connection conn = JDBCConnection.getConnection();
		List<User> userList = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM PERSONS WHERE NAME=? AND PASSWORD=?");
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User userData =  extractUser(rs);
				userList.add(userData);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return userList;
	}

	public Set getAllUsers() {
		Connection conn = JDBCConnection.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PERSONS");

			Set users = new HashSet();

			while (rs.next()) {
				User user = new User();
				users.add(user);
			}

			return users;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public boolean insertUser(User user) {
		Connection conn = JDBCConnection.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO PERSONS (NAME, PASSWORD, AGE) VALUES(?, ?,?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getPass());
			ps.setInt(3, user.getAge());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}

	public boolean updateUser(User user) {
		Connection conn = JDBCConnection.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE PERSONS SET name=?, password=?, age=? WHERE id=?");
			ps.setString(1, user.getName());
			ps.setString(2, user.getPass());
			ps.setInt(3, user.getAge());
			ps.setInt(4, user.getAge());
			int i = ps.executeUpdate();

			if (i == 1) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}

	public boolean deleteUser(int id) {
		Connection conn = JDBCConnection.getConnection();

		try {
			Statement stmt = conn.createStatement();
			int i = stmt.executeUpdate("DELETE FROM PERSONS WHERE ID=" + id);

			if (i == 1) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

		return false;
	}

	public void actionChoice() {
		User user = new User();
		System.out.println("Choose from below\n"
				+ "1 -- getUser\n2 -- getUserByUserNameAndPassword\n3 -- getAllUsers\n4-- insertUser\n5 -- updateUser\n6 -- deleteUser");
		int val = scan.nextInt();
		if (val > 6) {
			System.out.println("Invalid action");
		} else {
			switch (Integer.valueOf(val)) {
			case 1:
				getUser(id);
				break;
			case 2:
			//	getUserByUserNameAndPassword(user, pass);
				break;
			case 3:
				getAllUsers();
				break;
			case 4:
				insertUser(user);
				break;
			case 5:
				updateUser(user);
				break;
			case 6:
				deleteUser(id);
				break;
			default:
				break;
			}
		}

	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUserNameAndPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser() {
		// TODO Auto-generated method stub
		return false;
	}
}
