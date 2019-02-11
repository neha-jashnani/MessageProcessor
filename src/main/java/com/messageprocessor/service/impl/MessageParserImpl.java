package com.messageprocessor.service.impl;

import java.util.List;

import com.messageprocessor.bean.Adjustments;
import com.messageprocessor.bean.Message;
import com.messageprocessor.bean.Sales;
import com.messageprocessor.datasource.DataStore;
import com.messageprocessor.enums.MessageType;
import com.messageprocessor.enums.OperationType;
import com.messageprocessor.service.MessageParser;
import com.messageprocessor.service.ReportGenerator;

public class MessageParserImpl implements MessageParser {

	ReportGenerator reportGenerator;
	
	public MessageParserImpl(){
		reportGenerator = new ReportGeneratorImpl();
	}
	public boolean parseMessage(Message msg) {
		DataStore.addSale(msg.getTransaction());
		DataStore.addSalesDetails(msg.getTransaction().getProductName(), msg.getTransaction());
		if(MessageType.ADJUSTMENT.equals(msg.getType())){
			calculateAdjustments(msg.getTransaction());
		}
		return true;
	}
	
	public void calculateAdjustments(Sales transaction) {
		Double adjustedAmount = new Double(0);
		if(DataStore.getSalesDetails().containsKey(transaction.getProductName())){
			List<Sales> salesList = DataStore.getSalesDetails().get(transaction.getProductName());

			if(OperationType.ADD.equals(transaction.getOperation())){
				for (Sales sale : salesList) {
					adjustedAmount = sale.getPrice()+transaction.getPrice();
				}
				
			}
			if(OperationType.SUBTRACT.equals(transaction.getOperation())){
				for (Sales sale : salesList) {
					adjustedAmount = sale.getPrice()-transaction.getPrice();
				}
			}
			if(OperationType.MULTIPLY.equals(transaction.getOperation())){
				for (Sales sale : salesList) {
					adjustedAmount = sale.getPrice()*transaction.getPrice();
				}
				
			}
			DataStore.addAdjustment(new Adjustments(transaction.getProductName(), adjustedAmount, transaction.getOperation()));
		}
		
	}

	
}
