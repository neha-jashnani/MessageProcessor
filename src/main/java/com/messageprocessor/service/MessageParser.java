package com.messageprocessor.service;

import com.messageprocessor.bean.Message;

public interface MessageParser {

	public boolean parseMessage(Message msg);
}
