package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Item;

public class ItemDAO {

	//商品情報管理用のDAO

	private final String driver_name = "org.h2.Driver";
	private final String jdbc_url = "jdbc:h2:tcp://localhost/~/db_webApp\\db_a";
	private final String db_user = "sa";
	private final String db_pass = "";



	//ここからユーザー側の操作

	//全件検索(初期表示)
	//IDの大きい順(新商品が先頭に来る)
	public List<Item> select_all() {
		Connection con = null;
		List<Item> list_i = new ArrayList<>();

		try {
			//DBへ接続
			Class.forName(driver_name);
			con = DriverManager.getConnection(jdbc_url, db_user, db_pass);

			//select文
			String sql = "select * from item order by id desc";
			PreparedStatement ps = con.prepareStatement(sql);

			//実行
			ResultSet rs = ps.executeQuery();

			//リストに商品データのインスタンスをつっこむ
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String size = rs.getString("size");
				String textur = rs.getString("textur");
				String photo = rs.getString("photo");
				String explan = rs.getString("explan");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");

				Item item = new Item(id,name,size,textur,photo,explan,stock,price);
				list_i.add(item);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			//データベース切断
			if(con != null) {
				try {
					con.close();
				}catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return list_i;
	}

	//サイズ検索
	public List<Item> select_size(String size) {
		Connection con = null;
		List<Item> list_i = new ArrayList<>();

		try {
			//DBへ接続
			Class.forName(driver_name);
			con = DriverManager.getConnection(jdbc_url, db_user, db_pass);

			//select文
			String sql = "select * from item where size like ? order by id desc";
			PreparedStatement ps = con.prepareStatement(sql);

			//?に入れる内容
			ps.setString(1,size);

			//実行
			ResultSet rs = ps.executeQuery();

			//リストに商品データのインスタンスをつっこむ
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String size_s = rs.getString("size");
				String textur = rs.getString("textur");
				String photo = rs.getString("photo");
				String explan = rs.getString("explan");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");

				Item item = new Item(id,name,size_s,textur,photo,explan,stock,price);
				list_i.add(item);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			//データベース切断
			if(con != null) {
				try {
					con.close();
				}catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return list_i;
	}

	//生地検索
	public List<Item> select_textur(String textur) {
		Connection con = null;
		List<Item> list_i = new ArrayList<>();

		try {
			//DBへ接続
			Class.forName(driver_name);
			con = DriverManager.getConnection(jdbc_url, db_user, db_pass);

			//select文
			String sql = "select * from item where textur like ? order by id desc";
			PreparedStatement ps = con.prepareStatement(sql);

			//?に入れる内容
			ps.setString(1,textur);

			//実行
			ResultSet rs = ps.executeQuery();

			//リストに商品データのインスタンスをつっこむ
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String size = rs.getString("size");
				String textur_t = rs.getString("textur");
				String photo = rs.getString("photo");
				String explan = rs.getString("explan");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");

				Item item = new Item(id,name,size,textur_t,photo,explan,stock,price);
				list_i.add(item);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			//データベース切断
			if(con != null) {
				try {
					con.close();
				}catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return list_i;
	}

	//サイズと生地検索(2項目検索)
	public List<Item> select_two(String size, String textur) {
		Connection con = null;
		List<Item> list_i = new ArrayList<>();

		try {
			//DBへ接続
			Class.forName(driver_name);
			con = DriverManager.getConnection(jdbc_url, db_user, db_pass);

			//select文
			String sql = "select * from item where size like ? and textur like ? order by id desc";
			PreparedStatement ps = con.prepareStatement(sql);

			//?に入れる内容
			ps.setString(1,size);
			ps.setString(2,textur);

			//実行
			ResultSet rs = ps.executeQuery();

			//リストに商品データのインスタンスをつっこむ
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String size_s = rs.getString("size");
				String textur_t = rs.getString("textur");
				String photo = rs.getString("photo");
				String explan = rs.getString("explan");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");

				Item item = new Item(id,name,size_s,textur_t,photo,explan,stock,price);
				list_i.add(item);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			//データベース切断
			if(con != null) {
				try {
					con.close();
				}catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return list_i;
	}

	//在庫数チェック
	public int select_check(int id) {
		Connection con = null;
		int stock = 0;

		try {
			//DBへ接続
			Class.forName(driver_name);
			con = DriverManager.getConnection(jdbc_url, db_user, db_pass);

			//select文
			String sql = "select stock from item where id like ?";
			PreparedStatement ps = con.prepareStatement(sql);

			//?に入れる内容
			ps.setInt(1,id);

			//実行
			ResultSet rs = ps.executeQuery();

			//在庫数を取得
			if (rs.next()) {stock = rs.getInt("stock");}

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
		return stock;
	}

	//商品購入後の在庫数操作
	public void update(int id, int n) {
		Connection con = null;

		try {
			//DBへ接続
			Class.forName(driver_name);
			con = DriverManager.getConnection(jdbc_url, db_user, db_pass);

			//update文
			String sql = "update item set stock = (stock - ?) where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			//?に入れる内容
			ps.setInt(1,n);
			ps.setInt(2,id);

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
	//ここまでユーザー側の処理担当



	//ここから管理者側の操作



}
