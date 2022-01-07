package com.xadmin.payment.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.payment.dao.PayDAO;
import com.xadmin.payment.model.Pay;

/**
 * Servlet implementation class PayServlet
 */
@WebServlet("/")

public class PayServlet extends HttpServlet
{private static final long serialVersionUID = 1L;
private PayDAO paymentDAO;
/**
 * @see HttpServlet#HttpServlet()
 */
public PayServlet() {
   this.paymentDAO = new PayDAO();
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doGet(request, response);
}

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	String action = request.getServletPath();

	
	switch (action) {
	case "/new":
		showNewForm(request, response);
		break;
	case "/insert":
		try {
		insertPay(request, response);}
		catch (SQLException e) {
			e.printStackTrace();
		}
		break;
	case "/delete":
		try {
		deletePay(request, response);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		break;
	case "/edit":
		try {
		showEditForm(request, response);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		break;
	case "/update":
		try {
		updatePay(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		break;
	default:
		//handle list
		try {
		listPay(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		break;
	}

}
private void listPay(HttpServletRequest request, HttpServletResponse response)
throws SQLException, IOException, ServletException {
List<Pay> listPay = paymentDAO.selectAllPayment();
request.setAttribute("listPay", listPay);
RequestDispatcher dispatcher = request.getRequestDispatcher("payment-list.jsp");
dispatcher.forward(request, response);
}

private void updatePay(HttpServletRequest request, HttpServletResponse response) 
throws SQLException, IOException {
int id = Integer.parseInt(request.getParameter("id"));
String name = request.getParameter("name");
String Tel_No = request.getParameter("Tel_No");
String Payment_Method = request.getParameter("Payment_Method");
String Package = request.getParameter("Package");
String date = request.getParameter("date");
String paid_amount = request.getParameter("paid_amount");

Pay payment = new Pay(id, name, Tel_No, Payment_Method, Package, date, paid_amount);
paymentDAO.updatePay(payment);
response.sendRedirect("list");
}



private void deletePay(HttpServletRequest request, HttpServletResponse response) 
throws SQLException, IOException {
int id = Integer.parseInt(request.getParameter("id"));
paymentDAO.deletePay(id);
response.sendRedirect("list");

}

private void showEditForm(HttpServletRequest request, HttpServletResponse response)
throws SQLException, ServletException, IOException {
int id = Integer.parseInt(request.getParameter("id"));
Pay existingPay = paymentDAO.selectPay(id);
RequestDispatcher dispatcher = request.getRequestDispatcher("payment-form.jsp");
request.setAttribute("payment", existingPay);
dispatcher.forward(request, response);

}

private void showNewForm(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
RequestDispatcher dispatcher = request.getRequestDispatcher("payment-form.jsp");
dispatcher.forward(request, response);
}


private void insertPay(HttpServletRequest request, HttpServletResponse response) 
throws SQLException, IOException {
String name = request.getParameter("name");
String Tel_No = request.getParameter("Tel_No");
String Payment_Method = request.getParameter("Payment_Method");
String Package = request.getParameter("Package");
String date = request.getParameter("date");
String paid_amount = request.getParameter("paid_amount");

Pay newPay = new Pay( name, Tel_No, Payment_Method, Package, date, paid_amount);
paymentDAO.insertPay (newPay);
response.sendRedirect("list");
}
}

