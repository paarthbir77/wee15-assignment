package com.example.offlineuser.service;

import java.util.List;

import com.example.offlineuser.entity.FinancialReport;
import com.example.offlineuser.entity.InventoryDetails;
import com.example.offlineuser.entity.Reservation;

public interface UserService {

	String viewInventory();

	String placeOrder(int orderId[], String city);
	
	String makeReservation(String date, String month, String year, int members);
	
	String giveFeedback(String feedback);

}