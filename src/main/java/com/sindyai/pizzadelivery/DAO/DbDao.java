package com.sindyai.pizzadelivery.DAO;

import com.sindyai.pizzadelivery.model.Client;
import com.sindyai.pizzadelivery.model.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbDao {
    private final String DB_URL = "jdbc:postgresql://localhost:5432/pizza";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "postgres";
    private final String DB_DRIVER = "org.postgresql.Driver";
    private final Connection connection;

    public DbDao() {
        try {
            Class.forName(DB_DRIVER);
            this.connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("подключение невозможно");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Драйвер не распакован");
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> allPizza() {
        ArrayList<String> pizza = new ArrayList<>();
        pizza.add("Маргарита");
        pizza.add("Четыре сыра");
        pizza.add("Капричоза");
        pizza.add("Гавайская");
        return pizza;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public Client addClient(Client client) {
        try {
            connection.createStatement().executeUpdate(getQueryFromUser(client));
            return client;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getQueryFromUser(Client client) throws SQLException {

        return String.format("INSERT INTO client (name,number_phone,email,address)  VALUES ( '%s', '%d', '%s', '%s')",
                client.getName(),client.getNumber_phone(),client.getEmail(),client.getAddress());

    }


    public void addOrder(Order order) {
        try {
            connection.createStatement().executeUpdate(getQueryFromOrder(order));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private String getQueryFromOrder(Order order) throws SQLException {
        return String.format("INSERT INTO order_pizza (name_pizza,topping)  VALUES ( '%s', '%s')",
                order.getName_pizza(),getStrTopping(order.getTopping()));

    }

    private String getStrTopping(String[]top){
        StringBuilder builder = new StringBuilder();
               for(String t : top){
                   builder.append(t+" ");
               }
            return builder.toString();
    }
}
