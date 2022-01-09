package com.example.admin.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.admin.entity.FinancialReport;
import com.example.admin.entity.InventoryDetails;
import com.example.admin.service.AdminService;

@RestController
@RequestMapping("/admin-service")
public class AdminController {
	
	@Autowired
	AdminService adminService;

	@GetMapping("/viewMonthlyFinancials")
	public int viewMonthlyFinancials() {
		return adminService.viewMonthlyTotal();
	}
	@GetMapping("/viewBillsToday")
	public String viewBillsToday() {
		return adminService.viewBillsToday();
	}
	@GetMapping("/getInventory")
	public String getInventory(){
		return adminService.getInventory();
	}
	@GetMapping("/saveFinancialReport")
	@ResponseBody
	public String saveFinReport(@RequestParam("username")  String username,@RequestParam("bill") int bill,@RequestParam("date") String date,@RequestParam("month") String month,@RequestParam("year") String year, @RequestParam("city") String city) {
		FinancialReport financialreport = adminService.saveFinReport(username, bill, date, month, year, city);
		return financialreport.toString();
	}
	@GetMapping("/checkInventoryforItem/{id}")
	public boolean checkInventoryforItem(@PathVariable int id) {
		return adminService.checkInventoryforItem(id);
	}
	@GetMapping("/findPriceforItem/{id}")
	public int findPriceforItem(@PathVariable int id) {
		return adminService.findPriceforItem(id);
	}
	@GetMapping("/makeReservation")
	@ResponseBody
	public String makeReservation(@RequestParam("username") String username,@RequestParam("members") int members ,@RequestParam("date") String date,@RequestParam("month") String month,@RequestParam("year") String year) {
		return adminService.makeReservation(username, members, date, month, year);
	}
	@GetMapping("/giveFeedback")
	@ResponseBody
	public String saveFeedback(@RequestParam("username") String username,@RequestParam("feedbackContent") String feedbackContent) {
		return adminService.saveFeedback(username, feedbackContent);
	}

}
