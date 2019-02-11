package com.messageprocessor.service;

import java.util.List;

import com.messageprocessor.bean.Adjustments;
import com.messageprocessor.bean.Sales;

public interface ReportGenerator {

	public void generateAdjustmentSaleReport(List<Adjustments> adjustments);

	public void generateTotalSaleReport(List<Sales> sales);
}
