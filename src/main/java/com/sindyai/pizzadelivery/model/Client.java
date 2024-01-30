package com.sindyai.pizzadelivery.model;

import jakarta.servlet.http.HttpServletRequest;

public class Client {
    private Integer id;
    private String name;
    private  int number_phone;
    private String email;
    private String address;


    public Client(HttpServletRequest request){
this.name = request.getParameter("name");
this.number_phone = Integer.parseInt(request.getParameter("number_phone"));
this.email = request.getParameter("email");
this.address = request.getParameter("address");
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber_phone() {
        return number_phone;
    }

    public void setNumber_phone(int number_phone) {
        this.number_phone = number_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number_phone=" + number_phone +
                ", email='" + email + '\'' +
                '}';
    }
}
