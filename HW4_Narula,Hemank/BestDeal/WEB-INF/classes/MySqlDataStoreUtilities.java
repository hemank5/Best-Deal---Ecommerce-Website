import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class MySqlDataStoreUtilities {
	static Connection conn = null;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdeal", "root", "root");

		} catch (Exception e) {
		}
		return conn;
	}

	public static void insertUser(String username, String password, String usertype) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdeal", "root", "root");

			String insertIntoCustomerRegisterQuery = "INSERT INTO Registration(username,password,usertype) "
					+ "VALUES (?,?,?);";
			PreparedStatement pst = conn.prepareStatement(insertIntoCustomerRegisterQuery);
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, usertype);
			pst.execute();
		} catch (Exception e) {
		}
	}

	public static HashMap<String, User> selectUser() {
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdeal", "root", "root");

			ResultSet rs = null;
			Statement st = conn.createStatement();
			String sql = ("select * from registration");
			rs = st.executeQuery(sql);
			while (rs.next()) {
				HashMap<String, User> user = new HashMap<String, User>();
				String name = rs.getString("username");
				String desc = rs.getString("password");
				String image = rs.getString("usertype");
				user.put("P1", new User(name, desc, image));
				return user;
			}
			rs.close();
			st.close();
			conn.close();

		} catch (Exception e) {
		}
		return null;
	}

	public static HashMap<Integer, ArrayList<OrderPayment>> selectOrder() {
		HashMap<Integer, ArrayList<OrderPayment>> orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();
		try {
			getConnection();
			String selectOrderQuery = "select * from customerorders";
			PreparedStatement pst = conn.prepareStatement(selectOrderQuery);
			ResultSet rs = pst.executeQuery();
			ArrayList<OrderPayment> orderList = new ArrayList<OrderPayment>();
			while (rs.next()) {
				if (!orderPayments.containsKey(rs.getInt("orderid"))) {
					ArrayList<OrderPayment> arr = new ArrayList<OrderPayment>();
					orderPayments.put(rs.getInt("orderid"), arr);
				}
				ArrayList<OrderPayment> listOrderPayment = orderPayments.get(rs.getInt("orderid"));
				OrderPayment order = new OrderPayment(rs.getInt("orderid"), rs.getString("username"),
						rs.getString("ordername"), rs.getDouble("orderprice"), rs.getString("useraddress"),
						rs.getString("creditcardnum"));
				listOrderPayment.add(order);
			}
		} catch (Exception e) {
		}
		return orderPayments;
	}

	public static void insertOrder(int orderid, String username, String ordername, double orderprice,
			String useraddress, String creditcardnum) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdeal", "root", "root");
			String insertIntoCustomerOrderQuery = "INSERT INTO customerOrders(orderid,username,ordername,orderprice,useraddress,creditcardnum) "
					+ "VALUES (?,?,?,?,?,?);";
			PreparedStatement pst = conn.prepareStatement(insertIntoCustomerOrderQuery);
			pst.setInt(1, orderid);
			pst.setString(2, username);
			pst.setString(3, ordername);
			pst.setDouble(4, orderprice);
			pst.setString(5, useraddress);
			pst.setString(6, creditcardnum);
			pst.execute();
		} catch (Exception e) {
		}
	}

	public static void deleteOrder(int orderid, String ordername) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdeal", "root", "root");
			String deleteFromCustomerOrderQuery = "DELETE FROM customerorders WHERE orderid = ? and ordername = ?";
			PreparedStatement ps = conn.prepareStatement(deleteFromCustomerOrderQuery);
			ps.setInt(1, orderid);
			ps.setString(2, ordername);
			ps.execute();
		} catch (Exception e) {
		}
	}

}
