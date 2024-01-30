package com.sindyai.pizzadelivery.servlets;

import com.sindyai.pizzadelivery.DAO.DbDao;
import com.sindyai.pizzadelivery.model.Client;
import com.sindyai.pizzadelivery.model.Order;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet("/order")
public class OrderPizza extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            completeRequest(request);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher =
                request.getServletContext().getRequestDispatcher("/templates/allPizza.jsp");
        dispatcher.forward(request, response);

    }

    private void completeRequest(HttpServletRequest request) throws SQLException {
       DbDao dao = new DbDao();
        ArrayList<String>pizza = new ArrayList<>(dao.allPizza());
        request.setAttribute("namesPizza", pizza);



        dao.closeConnection();

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        Client clientAdd = new Client(request);
        Order orderAdd = new Order(request);
        response.setContentType("text/html");
        DbDao dao = new DbDao();
        dao.addClient(clientAdd);
        dao.addOrder(orderAdd);
        request.setAttribute("orderAdded", orderAdd);
        request.setAttribute("clientAdded", clientAdd);

        try {
            dao.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
