package com.example.admin.service;

import java.util.List;

import com.example.admin.entity.FinancialReport;
import com.example.admin.entity.InventoryDetails;

public interface AdminService {
	int viewMonthlyTotal();
	String viewBillsToday();
	String getInventory();
	FinancialReport saveFinReport(String username, int bill, String date, String month, String year, String city);
	boolean checkInventoryforItem(int id);
	int findPriceforItem(int id);
	String makeReservation(String username, int members, String date, String month, String year);
	String saveFeedback(String username, String feedbackContent);

}
