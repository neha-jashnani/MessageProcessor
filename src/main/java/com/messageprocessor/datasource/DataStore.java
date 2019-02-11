package com.messageprocessor.datasource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.messageprocessor.bean.Adjustments;
import com.messageprocessor.bean.Message;
import com.messageprocessor.bean.Sales;

public class DataStore {

	private static Queue<Message> messageQueue = new LinkedList<Message>();

	private static List<Sales> salesList = new ArrayList<Sales>();

	private static List<Adjustments> adjustmentList = new ArrayList<Adjustments>();

	private static Map<String, List<Sales>> salesDetails = new HashMap<String,List<Sales>>();

	
	public static boolean hasNextMessage() {
		if (messageQueue.isEmpty()) {
			return false;
		}
		return true;
	}

	public static void addMessage(Message message) {
		messageQueue.add(message);
	}

	public static Message readMessage() {
		return messageQueue.poll();
	}

	public static void addAdjustment(Adjustments adjustments) {
		adjustmentList.add(adjustments);
	}

	public static List<Adjustments> getAdjustments() {
		return adjustmentList;

	}

	public static List<Sales> getSalesList() {
		return salesList;
	}

	public static void addSale(Sales sale) {
		salesList.add(sale);
	}

	public static int totalSales() {
		return salesList.size();
	}

	public static Map<String, List<Sales>> getSalesDetails() {
		return salesDetails;
	}

	public static void addSalesDetails(String productName, Sales sale) {
		List<Sales> sales;
		if (salesDetails.containsKey(productName)) {
			sales = salesDetails.get(productName);

		} else {
			sales = new ArrayList<Sales>();

		}
		sales.add(sale);
		salesDetails.put(productName, sales);
	}

	

}
