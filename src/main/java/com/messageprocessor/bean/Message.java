package com.messageprocessor.bean;

import com.messageprocessor.enums.MessageType;

public class Message {

	private MessageType type;

	private Sales transaction;

	public Message(MessageType type, Sales transaction) {
		super();
		this.type = type;
		this.transaction = transaction;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public Sales getTransaction() {
		return transaction;
	}

	public void setTransaction(Sales transaction) {
		this.transaction = transaction;
	}

}
