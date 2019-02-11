package com.messageprocessor.bean;

import com.messageprocessor.enums.OperationType;

public class Adjustments {

	String productName;

	Double adjustmentAmount;

	OperationType type;

	public Adjustments(String productName, Double adjustmentAmount,
			OperationType type) {
		super();
		this.productName = productName;
		this.adjustmentAmount = adjustmentAmount;
		this.type = type;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getAdjustmentAmount() {
		return adjustmentAmount;
	}

	public void setAdjustmentAmount(Double adjustmentAmount) {
		this.adjustmentAmount = adjustmentAmount;
	}

	public OperationType getType() {
		return type;
	}

	public void setType(OperationType type) {
		this.type = type;
	}

}
