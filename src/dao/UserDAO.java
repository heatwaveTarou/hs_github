package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO {

	//ユーザー情報管理用のDAO

	private final String driver_name = "org.h2.Driver";
	private final String jdbc_url = "jdbc:h2:tcp://localhost/~/db_webApp\\db_a";
	private final String db_user = "sa";
	private final String db_pass = "";

	//新規登録
	public void insert(User user) {
		Connection con = null;

		try {
			//DBへ接続
			Class.forName(driver_name);
			con = DriverManager.getConnection(jdbc_url, db_user, db_pass);

			//insert文
			String sql = "insert into user(account,pass,name,addre,mail) values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			//?に入れる内容
			ps.setString(1,user.getAccount());
			ps.setString(2,user.getPass());
			ps.setString(3,user.getName());
			ps.setString(4,user.getAddre());
			ps.setString(5,user.getMail());

			//実行
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//データベース切断
			if(con != null) {
				try {
					con.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	//登録情報の変更
	public void update(User user) {
		Connection con = null;

		try {
			//DBへ接続
			Class.forName(driver_name);
			con = DriverManager.getConnection(jdbc_url, db_user, db_pass);

			//update文
			String sql = "update user set name=?,pass=?,addre=?,mail=? where account=?";
			PreparedStatement ps = con.prepareStatement(sql);

			//?に入れる内容
			ps.setString(1,user.getName());
			ps.setString(2,user.getPass());
			ps.setString(3,user.getAddre());
			ps.setString(4,user.getMail());
			ps.setString(5,user.getAccount());

			//実行
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//データベース切断
			if(con != null) {
				try {
					con.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	//ログイン時などの個人特定用の検索
	public int retrieval(String account, String pass) {
		Connection con = null;
		int i = 0;

		try {
			//DBへ接続
			Class.forName(driver_name);
			con = DriverManager.getConnection(jdbc_url, db_user, db_pass);

			//select文
			String sql = "select * from user where account like ? and pass like ?";
			PreparedStatement ps = con.prepareStatement(sql);

			//?に入れる内容
			ps.setString(1,account);
			ps.setString(2,pass);

			//実行
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {i = 1;}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			//データベース切断
			if(con != null) {
				try {
					con.close();
				}catch (SQLException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}
		return i;
	}

	//登録抹消用
	public void delete(String account) {
		Connection con = null;

		try {
			//DBへ接続
			Class.forName(driver_name);
			con = DriverManager.getConnection(jdbc_url, db_user, db_pass);

			//delete文
			String sql = "delete from user where account = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			//?に入れる内容
			ps.setString(1,account);

			//実行
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//データベース切断
			if(con != null) {
				try {
					con.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
