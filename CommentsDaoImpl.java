package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Comments;

public class CommentsDaoImpl implements CommentsDao {
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
	public int insert(Comments comments) {
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("insert into comments (comment) values(?)");
			pst.setString(1, comments.getComment());
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int commentid) {
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("delete from comments where commentid = ?");
			pst.setInt(1, commentid);
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;

	}

	@Override
	public List<Comments> view() {
		ArrayList<Comments> list = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from comments");
			while (rs.next()) {
				list.add(new Comments(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Comments view(int id) {
		Comments comments = new Comments();
		try {
			PreparedStatement pst = con.prepareStatement("select * from posts where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				comments = new Comments(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comments;
	}

}
