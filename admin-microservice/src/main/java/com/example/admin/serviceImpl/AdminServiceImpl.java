package com.example.admin.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.admin.entity.FinancialReport;
import com.example.admin.entity.InventoryDetails;
import com.example.admin.repository.FeedbackRepository;
import com.example.admin.repository.FinancialReportRepository;
import com.example.admin.repository.InventoryDetailsRepository;
import com.example.admin.repository.UserRepository;
import com.example.admin.service.AdminService;
import com.example.admin.entity.Feedback;
import com.example.admin.repository.ReservationRepository;
import com.example.admin.entity.Reservation;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	FinancialReportRepository financialReportRepository;
	@Autowired
	InventoryDetailsRepository inventoryDetailsRepository;
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	FeedbackRepository feedbackRepository;
	@Override
	public int viewMonthlyTotal() {
		String month, year;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		String dateString= now.toString();
		year = dateString.substring(0, 4);
		month = dateString.substring(5, 7);
		List<Integer> billTotals = financialReportRepository.findBillsThisMonth(month, year);
		int total = 0;
		for(int i = 0; i<billTotals.size(); i++) {
			total += billTotals.get(i);
		}
		return total;
	}

	@Override
	public String viewBillsToday() {
		String date, month, year;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		String dateString= now.toString();
		year = dateString.substring(0, 4);
		month = dateString.substring(5, 7);
		date = dateString.substring(8,10);
		List<FinancialReport> reports = financialReportRepository.findReportByDate(date, month, year);
		//List<FinancialReport> reports = financialReportRepository.findAll();
		String result="";
		for(int i=0;i<reports.size();i++) {
			//System.out.println(reports.get(i));
			result+=reports.get(i).toString()+"\n";
		}
		return result;
		//return null;
	}

	@Override
	public String getInventory() {
		// TODO Auto-generated method stub
		List<InventoryDetails> items = inventoryDetailsRepository.findAll();
		String result="";
		for(int i=0;i<items.size();i++) {
			result+=items.get(i).toString()+"\n";
		}
		return result;
	}
	
	@Transactional
	public FinancialReport saveFinancialReport(FinancialReport finReport) {
		FinancialReport finResponse = financialReportRepository.save(finReport);
		return finResponse;
	}

	@Override
	public FinancialReport saveFinReport(String username, int bill, String date, String month, String year, String city) {
		FinancialReport finReport = new FinancialReport(username, bill, date, month, year, city.toLowerCase());
		finReport = saveFinancialReport(finReport);
		return finReport;
	}

	@Override
	public boolean checkInventoryforItem(int id) {
		return inventoryDetailsRepository.existsById(id);
	}

	@Override
	public int findPriceforItem(int id) {
		// TODO Auto-generated method stub
		return inventoryDetailsRepository.findPriceById(id);
	}
	
	@Transactional
	public Reservation saveReservation(Reservation reservation) {
		Reservation reservationResponse = reservationRepository.save(reservation);
		return reservationResponse;
	}
	
	@Override
	public String makeReservation(String username, int members, String date, String month, String year) {
		// TODO Auto-generated method stub
		Reservation reservation = new Reservation(username, members, date, month, year);
		reservation = saveReservation(reservation);
		return reservation.toString();
	}
	
	@Transactional
	public Feedback saveFeedback(Feedback feedback) {
		Feedback feedbackResponse = feedbackRepository.save(feedback);
		return feedbackResponse;
	}

	@Override
	public String saveFeedback(String username, String feedbackContent) {
		// TODO Auto-generated method stub
		Feedback feedback = new Feedback(username, feedbackContent);
		feedback = saveFeedback(feedback);
		return "Thank you for your feedback!";
	}
	

}
