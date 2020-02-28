package com.VoucherService.Software.consumer;

import java.util.List;


public interface ConsumerDaoInterface {

	List<Consumer> findAll();
	void insertConsumer(ConsumerInfo conInfo);
	void updateConsumer(Consumer con);
	String redeemId(String voucherId);
}
