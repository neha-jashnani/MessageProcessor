package com.messageprocessor.test;

import org.junit.Before;
import org.junit.Test;

import com.messageprocessor.bean.Message;
import com.messageprocessor.bean.Sales;
import com.messageprocessor.datasource.DataStore;
import com.messageprocessor.enums.MessageType;
import com.messageprocessor.enums.OperationType;
import com.messageprocessor.enums.ProductType;
import com.messageprocessor.service.MessageProcessor;
import com.messageprocessor.service.impl.MessageProcessorImpl;

public class MessageProcessorTest {

	MessageProcessor processor;

	@Before
	public void setup() {
		Message msg1 = new Message(MessageType.SINGLE, new Sales(
				ProductType.APPLE.getProductName(), 120.0, 1,
				OperationType.NONE));
		Message msg2 = new Message(MessageType.MULTI, new Sales(
				ProductType.ORANGE.getProductName(), 20.0, 5,
				OperationType.NONE));
		Message msg3 = new Message(MessageType.ADJUSTMENT, new Sales(
				ProductType.ORANGE.getProductName(), 1.5, 1, OperationType.ADD));
		Message msg4 = new Message(MessageType.SINGLE, new Sales(
				ProductType.PAPAYA.getProductName(), 50.0, 1,
				OperationType.NONE));
		Message msg5 = new Message(MessageType.MULTI,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 2,
						OperationType.NONE));
		Message msg6 = new Message(MessageType.SINGLE,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 1,
						OperationType.NONE));
		Message msg7 = new Message(MessageType.MULTI, new Sales(
				ProductType.ORANGE.getProductName(), 20.0, 5,
				OperationType.NONE));
		Message msg8 = new Message(MessageType.ADJUSTMENT, new Sales(
				ProductType.APPLE.getProductName(), 0.5, 1,
				OperationType.SUBTRACT));
		Message msg9 = new Message(MessageType.SINGLE, new Sales(
				ProductType.PAPAYA.getProductName(), 20.0, 1,
				OperationType.NONE));
		Message msg10 = new Message(MessageType.MULTI,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 2,
						OperationType.NONE));
		Message msg11 = new Message(MessageType.SINGLE,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 1,
						OperationType.NONE));
		Message msg12 = new Message(MessageType.MULTI, new Sales(
				ProductType.ORANGE.getProductName(), 20.0, 5,
				OperationType.NONE));
		Message msg13 = new Message(MessageType.ADJUSTMENT, new Sales(
				ProductType.ORANGE.getProductName(), 0.3, 1,
				OperationType.MULTIPLY));
		Message msg14 = new Message(MessageType.SINGLE, new Sales(
				ProductType.PAPAYA.getProductName(), 20.0, 1,
				OperationType.NONE));
		Message msg15 = new Message(MessageType.MULTI,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 3,
						OperationType.NONE));
		Message msg16 = new Message(MessageType.SINGLE,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 1,
						OperationType.NONE));
		Message msg17 = new Message(MessageType.MULTI, new Sales(
				ProductType.ORANGE.getProductName(), 20.0, 5,
				OperationType.NONE));
		Message msg18 = new Message(MessageType.ADJUSTMENT, new Sales(
				ProductType.PAPAYA.getProductName(), 0.5, 1,
				OperationType.MULTIPLY));
		Message msg19 = new Message(MessageType.SINGLE, new Sales(
				ProductType.PAPAYA.getProductName(), 20.0, 1,
				OperationType.NONE));
		Message msg20 = new Message(MessageType.MULTI,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 5,
						OperationType.NONE));

		Message msg21 = new Message(MessageType.SINGLE,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 1,
						OperationType.NONE));
		Message msg22 = new Message(MessageType.MULTI, new Sales(
				ProductType.ORANGE.getProductName(), 20.0, 5,
				OperationType.NONE));
		Message msg23 = new Message(MessageType.ADJUSTMENT, new Sales(
				ProductType.APPLE.getProductName(), 0.75, 1, OperationType.ADD));
		Message msg24 = new Message(MessageType.SINGLE, new Sales(
				ProductType.PAPAYA.getProductName(), 20.0, 4,
				OperationType.NONE));
		Message msg25 = new Message(MessageType.MULTI,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 1,
						OperationType.NONE));
		Message msg26 = new Message(MessageType.SINGLE,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 1,
						OperationType.NONE));
		Message msg27 = new Message(MessageType.MULTI, new Sales(
				ProductType.ORANGE.getProductName(), 20.0, 5,
				OperationType.NONE));
		Message msg28 = new Message(MessageType.ADJUSTMENT, new Sales(
				ProductType.PAPAYA.getProductName(), 2.0, 1,
				OperationType.SUBTRACT));
		Message msg29 = new Message(MessageType.SINGLE, new Sales(
				ProductType.PAPAYA.getProductName(), 20.0, 1,
				OperationType.NONE));
		Message msg30 = new Message(MessageType.MULTI,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 2,
						OperationType.NONE));
		Message msg31 = new Message(MessageType.SINGLE,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 1,
						OperationType.NONE));
		Message msg32 = new Message(MessageType.MULTI, new Sales(
				ProductType.ORANGE.getProductName(), 20.0, 5,
				OperationType.NONE));
		Message msg33 = new Message(MessageType.ADJUSTMENT, new Sales(
				ProductType.ORANGE.getProductName(), 2.5, 1, OperationType.ADD));
		Message msg34 = new Message(MessageType.SINGLE, new Sales(
				ProductType.PAPAYA.getProductName(), 20.0, 1,
				OperationType.NONE));
		Message msg35 = new Message(MessageType.MULTI, new Sales(
				ProductType.APPLE.getProductName(), 20.0, 10,
				OperationType.NONE));
		Message msg36 = new Message(MessageType.SINGLE,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 1,
						OperationType.NONE));
		Message msg37 = new Message(MessageType.MULTI, new Sales(
				ProductType.ORANGE.getProductName(), 20.0, 5,
				OperationType.NONE));
		Message msg38 = new Message(MessageType.ADJUSTMENT, new Sales(
				ProductType.APPLE.getProductName(), 3.5, 1,
				OperationType.SUBTRACT));
		Message msg39 = new Message(MessageType.SINGLE, new Sales(
				ProductType.PAPAYA.getProductName(), 20.0, 1,
				OperationType.NONE));
		Message msg40 = new Message(MessageType.MULTI,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 1,
						OperationType.NONE));
		Message msg41 = new Message(MessageType.SINGLE,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 1,
						OperationType.NONE));
		Message msg42 = new Message(MessageType.MULTI, new Sales(
				ProductType.ORANGE.getProductName(), 20.0, 5,
				OperationType.NONE));
		Message msg43 = new Message(MessageType.ADJUSTMENT, new Sales(
				ProductType.ORANGE.getProductName(), 0.7, 1, OperationType.ADD));
		Message msg44 = new Message(MessageType.SINGLE, new Sales(
				ProductType.PAPAYA.getProductName(), 20.0, 1,
				OperationType.NONE));
		Message msg45 = new Message(MessageType.MULTI,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 3,
						OperationType.NONE));
		Message msg46 = new Message(MessageType.SINGLE,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 1,
						OperationType.NONE));
		Message msg47 = new Message(MessageType.MULTI, new Sales(
				ProductType.ORANGE.getProductName(), 20.0, 5,
				OperationType.NONE));
		Message msg48 = new Message(MessageType.ADJUSTMENT, new Sales(
				ProductType.APPLE.getProductName(), 0.1, 1,
				OperationType.MULTIPLY));
		Message msg49 = new Message(MessageType.SINGLE, new Sales(
				ProductType.PAPAYA.getProductName(), 20.0, 1,
				OperationType.NONE));
		Message msg50 = new Message(MessageType.MULTI,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 6,
						OperationType.NONE));

		Message msg51 = new Message(MessageType.SINGLE,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 1,
						OperationType.NONE));
		Message msg52 = new Message(MessageType.MULTI, new Sales(
				ProductType.ORANGE.getProductName(), 20.0, 5,
				OperationType.NONE));
		Message msg53 = new Message(MessageType.ADJUSTMENT, new Sales(
				ProductType.PAPAYA.getProductName(), 3.0, 1, OperationType.ADD));
		Message msg54 = new Message(MessageType.SINGLE, new Sales(
				ProductType.PAPAYA.getProductName(), 20.0, 1,
				OperationType.NONE));
		Message msg55 = new Message(MessageType.MULTI,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 2,
						OperationType.NONE));
		Message msg56 = new Message(MessageType.SINGLE,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 1,
						OperationType.NONE));
		Message msg57 = new Message(MessageType.MULTI, new Sales(
				ProductType.ORANGE.getProductName(), 20.0, 5,
				OperationType.NONE));
		Message msg58 = new Message(MessageType.ADJUSTMENT, new Sales(
				ProductType.ORANGE.getProductName(), 1.0, 1,
				OperationType.SUBTRACT));
		Message msg59 = new Message(MessageType.SINGLE, new Sales(
				ProductType.PAPAYA.getProductName(), 20.0, 1,
				OperationType.NONE));
		Message msg60 = new Message(MessageType.MULTI,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 4,
						OperationType.NONE));
		Message msg61 = new Message(MessageType.SINGLE,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 1,
						OperationType.NONE));
		Message msg62 = new Message(MessageType.MULTI, new Sales(
				ProductType.ORANGE.getProductName(), 20.0, 5,
				OperationType.NONE));
		Message msg63 = new Message(MessageType.ADJUSTMENT, new Sales(
				ProductType.APPLE.getProductName(), 1.75, 1, OperationType.ADD));
		Message msg64 = new Message(MessageType.SINGLE, new Sales(
				ProductType.PAPAYA.getProductName(), 20.0, 1,
				OperationType.NONE));
		Message msg65 = new Message(MessageType.MULTI,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 2,
						OperationType.NONE));
		Message msg66 = new Message(MessageType.SINGLE,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 1,
						OperationType.NONE));
		Message msg67 = new Message(MessageType.MULTI, new Sales(
				ProductType.ORANGE.getProductName(), 20.0, 5,
				OperationType.NONE));
		Message msg68 = new Message(MessageType.ADJUSTMENT, new Sales(
				ProductType.ORANGE.getProductName(), 0.1, 1,
				OperationType.MULTIPLY));
		Message msg69 = new Message(MessageType.SINGLE, new Sales(
				ProductType.PAPAYA.getProductName(), 20.0, 1,
				OperationType.NONE));
		Message msg70 = new Message(MessageType.MULTI,
				new Sales(ProductType.APPLE.getProductName(), 20.0, 6,
						OperationType.NONE));

		DataStore.addMessage(msg1);
		DataStore.addMessage(msg2);
		DataStore.addMessage(msg3);
		DataStore.addMessage(msg4);
		DataStore.addMessage(msg5);

		DataStore.addMessage(msg6);
		DataStore.addMessage(msg7);
		DataStore.addMessage(msg8);
		DataStore.addMessage(msg9);
		DataStore.addMessage(msg10);

		DataStore.addMessage(msg11);
		DataStore.addMessage(msg12);
		DataStore.addMessage(msg13);
		DataStore.addMessage(msg14);
		DataStore.addMessage(msg15);

		DataStore.addMessage(msg16);
		DataStore.addMessage(msg17);
		DataStore.addMessage(msg18);
		DataStore.addMessage(msg19);
		DataStore.addMessage(msg20);

		DataStore.addMessage(msg21);
		DataStore.addMessage(msg22);
		DataStore.addMessage(msg23);
		DataStore.addMessage(msg24);
		DataStore.addMessage(msg25);

		DataStore.addMessage(msg26);
		DataStore.addMessage(msg27);
		DataStore.addMessage(msg28);
		DataStore.addMessage(msg29);
		DataStore.addMessage(msg30);

		DataStore.addMessage(msg31);
		DataStore.addMessage(msg32);
		DataStore.addMessage(msg33);
		DataStore.addMessage(msg34);
		DataStore.addMessage(msg35);

		DataStore.addMessage(msg36);
		DataStore.addMessage(msg37);
		DataStore.addMessage(msg38);
		DataStore.addMessage(msg39);
		DataStore.addMessage(msg40);

		DataStore.addMessage(msg41);
		DataStore.addMessage(msg42);
		DataStore.addMessage(msg43);
		DataStore.addMessage(msg44);
		DataStore.addMessage(msg45);

		DataStore.addMessage(msg46);
		DataStore.addMessage(msg47);
		DataStore.addMessage(msg48);
		DataStore.addMessage(msg49);
		DataStore.addMessage(msg50);

		DataStore.addMessage(msg51);
		DataStore.addMessage(msg52);
		DataStore.addMessage(msg53);
		DataStore.addMessage(msg54);
		DataStore.addMessage(msg55);

		DataStore.addMessage(msg56);
		DataStore.addMessage(msg57);
		DataStore.addMessage(msg58);
		DataStore.addMessage(msg59);
		DataStore.addMessage(msg60);

		DataStore.addMessage(msg61);
		DataStore.addMessage(msg62);
		DataStore.addMessage(msg63);
		DataStore.addMessage(msg64);
		DataStore.addMessage(msg65);

		DataStore.addMessage(msg66);
		DataStore.addMessage(msg67);
		DataStore.addMessage(msg68);
		DataStore.addMessage(msg69);
		DataStore.addMessage(msg70);

		processor = new MessageProcessorImpl();
	}

	@Test
	public void testMessageProcessor() {
		try {
			processor.processMessage();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}
