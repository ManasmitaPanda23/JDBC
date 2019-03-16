package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Posts;

public class PostDaoImpl implements PostsDao {
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(Posts posts) {
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("insert into posts (title,body) values(?,?)");
			pst.setString(1, posts.getTitle());
			pst.setString(2, posts.getBody());
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;

	}

	@Override
	public int update(Posts posts) {
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("update posts set title = ?, body = ? where id = ?");
			pst.setString(1, posts.getTitle());
			pst.setString(2, posts.getBody());
			pst.setInt(3, posts.getId());
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int id) {
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("delete from posts where id = ?");
			pst.setInt(1, id);
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Posts> view() {

		ArrayList<Posts> list = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from posts");
			while (rs.next()) {
				list.add(new Posts(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Posts view(int id) {
		Posts post = new Posts();
		try {
			PreparedStatement pst = con.prepareStatement("select * from posts where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				post = new Posts(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return post;

	}

}
