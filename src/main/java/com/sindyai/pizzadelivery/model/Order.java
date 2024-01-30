package com.sindyai.pizzadelivery.model;

import jakarta.servlet.http.HttpServletRequest;

public class Order {
    private Integer id;
    private String name_pizza;

    private String[] topping;
    private Integer user_id;


    public Order(){}

    public Order(String name_pizza, String topping[], Integer user_id) {
        this.name_pizza = name_pizza;
        this.topping = topping;
        this.user_id = user_id;
    }

    public Order(HttpServletRequest request) {
        this.name_pizza = request.getParameter("name_pizza");
        this.topping = request.getParameterValues("top");
    }

    public Integer getId() {
        return id;
    }



    public String getName_pizza() {
        return name_pizza;
    }

    public void setName_pizza(String name_pizza) {
        this.name_pizza = name_pizza;
    }



    public String[] getTopping() {
        return topping;
    }

    public void setTopping(String topping []) {
        this.topping = topping;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name_pizza='" + name_pizza + '\'' +
                ", topping='" + topping + '\'' +
                '}';
    }
}
