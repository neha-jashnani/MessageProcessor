package com.messageprocessor.bean;

import com.messageprocessor.enums.OperationType;

public class Sales {

	private String productName;

	private Double price;

	private int productUnits;

	private OperationType operation;

	public Sales(String productName, Double price, int productUnits,
			OperationType operation) {
		super();
		this.productName = productName;
		this.price = price;
		this.productUnits = productUnits;
		this.operation = operation;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getProductUnits() {
		return productUnits;
	}

	public void setProductUnits(int productUnits) {
		this.productUnits = productUnits;
	}

	public OperationType getOperation() {
		return operation;
	}

	public void setOperation(OperationType operation) {
		this.operation = operation;
	}

}
