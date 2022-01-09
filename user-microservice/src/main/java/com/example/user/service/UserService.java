package com.example.user.service;


public interface UserService {

	String viewInventory();

	String placeOrder(int orderId[], String code, String city);

}