package com.messageprocessor.service.impl;

import com.messageprocessor.bean.Message;
import com.messageprocessor.datasource.DataStore;
import com.messageprocessor.service.MessageParser;
import com.messageprocessor.service.MessageProcessor;
import com.messageprocessor.service.ReportGenerator;

public class MessageProcessorImpl implements MessageProcessor {

	
	MessageParser parser;
	
	ReportGenerator reportGenerator;
	
	public MessageProcessorImpl(){
		this.parser = new MessageParserImpl();
		this.reportGenerator = new ReportGeneratorImpl();
	}
	
	private static int msgProcessedCount=0;
	
	public void processMessage() throws InterruptedException {
		
		while(DataStore.hasNextMessage()){
			Message msg = DataStore.readMessage();
			
			boolean msgProcessed = parser.parseMessage(msg);
			if(msgProcessed)	
				msgProcessedCount++;
			
			if(msgProcessedCount%10==0){
				reportGenerator.generateTotalSaleReport(DataStore.getSalesList());
			}
			if(msgProcessedCount%50==0){
				reportGenerator.generateAdjustmentSaleReport(DataStore.getAdjustments());
				Thread.sleep(20000);
				System.out.println("*****************Application resumed *****************************");
			}
			

				
			
		}
		
	}
}


