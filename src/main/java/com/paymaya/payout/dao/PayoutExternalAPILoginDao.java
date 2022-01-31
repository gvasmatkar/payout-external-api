package com.paymaya.payout.dao;

import java.util.HashMap;

import com.paymaya.payout.model.User;
import com.paymaya.payout.model.UserJsonResponse;

public interface PayoutExternalAPILoginDao {

	Boolean initiateSession(HashMap<String, Object> userDetails);

	UserJsonResponse generateCSRFToken();

}
