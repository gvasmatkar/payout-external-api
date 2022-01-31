package com.paymaya.payout.serviceImpl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymaya.payout.dao.PayoutExternalAPILoginDao;
import com.paymaya.payout.model.UserJsonResponse;
import com.paymaya.payout.service.PayoutExternalAPILoginService;

@Service
public class PayoutExternalAPILoginServiceImpl implements PayoutExternalAPILoginService {

	@Autowired
	PayoutExternalAPILoginDao payoutExternalAPILoginDao;
	
	@Override
	public Boolean initiateSession(HashMap<String, Object> userDetails) {

		return payoutExternalAPILoginDao.initiateSession(userDetails);
	}

	@Override
	public UserJsonResponse generateCSRFToken() {
		
		return payoutExternalAPILoginDao.generateCSRFToken();
	}

}
