package com.xadmin.payment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.payment.model.Pay;



public class PayDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo2?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "lahiru2000";
	
	private static final String INSERT_PAYMENT_SQL = "INSERT INTO payment" + "  (name, Tel_No, Payment_Method, Package, date, paid_amount) VALUES "
			+ " (?, ?, ?, ?, ?, ?);";

	private static final String SELECT_PAYMENT_BY_ID = "select id,name,Tel_No,Payment_Method,Package,date,paid_amount from payment where id =?";
	private static final String SELECT_ALL_PAYMENT = "select * from payment";
	private static final String DELETE_PAYMENT_SQL = "delete from payment where id = ?;";
	private static final String UPDATE_PAYMENT_SQL = "update payment set name = ?, Tel_No = ?, Payment_Method = ?, Package = ?, date= ?, paid_amount =? where id = ?;";


	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	

	public void insertPay(Pay payment) throws SQLException {
		
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PAYMENT_SQL)) {
			preparedStatement.setString(1, payment.getName());
			preparedStatement.setString(2, payment.getTel_No());
			preparedStatement.setString(3, payment.getPayment_Method());
			preparedStatement.setString(4, payment.getPackage());
			preparedStatement.setString(5, payment.getDate());
			preparedStatement.setString(6, payment.getPaid_amount());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//update payment
	public boolean updatePay(Pay payment) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_PAYMENT_SQL);) {
			
			statement.setString(1, payment.getName());
			statement.setString(2, payment.getTel_No());
			statement.setString(3, payment.getPayment_Method());
			statement.setString(4, payment.getPackage());
			statement.setString(5, payment.getDate());
			statement.setString(6, payment.getPaid_amount());
			statement.setInt(7, payment.getID());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	//select payment by id
	public Pay selectPay(int id) {
		Pay payment = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PAYMENT_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String Tel_No = rs.getString("Tel_No");
				String Payment_Method = rs.getString("Payment_Method");
				String Package = rs.getString("Package");
				String date = rs.getString("date");
				String paid_amount = rs.getString("paid_amount");
				payment = new Pay(id, name,Tel_No,Payment_Method,Package,date, paid_amount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return payment;
	}
	//select payment
	public List<Pay> selectAllPayment() {
		List<Pay> payment = new ArrayList<>();
	
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PAYMENT);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String Tel_No = rs.getString("Tel_No");
				String Payment_Method = rs.getString("Payment_Method");
				String Package = rs.getString("Package");
				String date = rs.getString("date");
				String paid_amount = rs.getString("paid_amount");
				payment.add(new Pay(id, name,Tel_No,Payment_Method,Package, date, paid_amount));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		return payment;
	}
	//delete payment
	public boolean deletePay(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PAYMENT_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	

}



