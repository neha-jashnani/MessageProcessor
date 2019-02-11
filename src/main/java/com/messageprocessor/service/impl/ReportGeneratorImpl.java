package com.messageprocessor.service.impl;

import java.util.Arrays;
import java.util.List;

import com.messageprocessor.bean.Adjustments;
import com.messageprocessor.bean.Sales;
import com.messageprocessor.enums.ProductType;
import com.messageprocessor.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {

	public void generateAdjustmentSaleReport(List<Adjustments> adjustments) {
		List<ProductType> prodcutTypeList = Arrays.asList(ProductType.values());
		System.out
				.println("*************Application pausing and processing Adjustment Reports************");
		for (ProductType prodType : prodcutTypeList) {
			Double totalAmount = adjustments
					.stream()
					.filter(o -> prodType.getProductName() == o
							.getProductName())
					.mapToDouble(x -> x.getAdjustmentAmount()).sum();
			System.out.println(prodType.getProductName()
					+ " : Amount adjusted : " + totalAmount + "P");
		}
	}

	public void generateTotalSaleReport(List<Sales> sales) {
		List<ProductType> prodcutTypeList = Arrays.asList(ProductType.values());
		for (ProductType prodType : prodcutTypeList) {
			int totalUnits = sales
					.stream()
					.filter(o -> prodType.getProductName() == o
							.getProductName())
					.mapToInt(x -> x.getProductUnits()).sum();
			Double totalAmount = sales
					.stream()
					.filter(o -> prodType.getProductName() == o
							.getProductName()).mapToDouble(x -> x.getPrice())
					.sum();
			System.out.println(prodType.getProductName()
					+ " : Total units sold :" + totalUnits + " at "
					+ totalAmount + "P");
		}

	}

}
