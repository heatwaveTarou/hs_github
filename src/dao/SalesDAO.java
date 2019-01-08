package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Sales;

public class SalesDAO {

	//購入履歴管理用のDAO

		private final String driver_name = "org.h2.Driver";
		private final String jdbc_url = "jdbc:h2:tcp://localhost/~/db_webApp\\db_a";
		private final String db_user = "sa";
		private final String db_pass = "";

	//購入履歴の追加
		public void insert(Sales sales) {
			Connection con = null;

			try {
				//DBへ接続
				Class.forName(driver_name);
				con = DriverManager.getConnection(jdbc_url, db_user, db_pass);

				//insert文
				String sql = "insert into sales(account,id,price,counts,date) values(?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);

				//?に入れる内容
				ps.setString(1,sales.getAcoount());
				ps.setInt(2,sales.getId());
				ps.setInt(3,sales.getPrice());
				ps.setInt(4,sales.getCounts());
				ps.setString(5,sales.getDate());

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
//※未完成
		//購入履歴をとってくる(IDの大きい順)
		public List<Sales> select(String account) {
			Connection con = null;
			List<Sales> list = new ArrayList<>();

			try {
				//DBへ接続
				Class.forName(driver_name);
				con = DriverManager.getConnection(jdbc_url, db_user, db_pass);

				//select文
				String sql = "select account,id,price,counts,date from sales where=? order by saleid desc";
				PreparedStatement ps = con.prepareStatement(sql);

				//?に入れる内容
				ps.setString(1,account);

				//実行
				ResultSet rs = ps.executeQuery();

				//リストに商品データのインスタンスをつっこむ
				while(rs.next()) {
					String account_a = rs.getString("account");
					int id = rs.getInt("id");
					int price = rs.getInt("price");
					int counts = rs.getInt("counts");
					String date = rs.getString("date");

					Sales sales = new Sales(account_a,id,price,counts,date);
					list.add(sales);
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
			return list;
		}

}
