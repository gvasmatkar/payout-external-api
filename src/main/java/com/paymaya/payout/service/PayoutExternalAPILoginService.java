package com.paymaya.payout.service;

import java.util.HashMap;

import com.paymaya.payout.model.User;
import com.paymaya.payout.model.UserJsonResponse;

public interface PayoutExternalAPILoginService {

	Boolean initiateSession(HashMap<String, Object> userDetails);

	UserJsonResponse generateCSRFToken();

}
