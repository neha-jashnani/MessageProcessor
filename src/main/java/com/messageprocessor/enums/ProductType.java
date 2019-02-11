package com.messageprocessor.enums;

public enum ProductType {

	APPLE("Apple"), ORANGE("Orange"), PAPAYA("Papaya");

	private String productName;

	private ProductType(String productName) {
		this.productName = productName;
	}

	public String getProductName() {
		return this.productName;
	}

}