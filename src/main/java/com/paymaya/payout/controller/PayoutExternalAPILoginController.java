package com.paymaya.payout.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymaya.payout.model.UserJsonResponse;
import com.paymaya.payout.model.UserResponseModel;
import com.paymaya.payout.service.PayoutExternalAPILoginService;


@RestController
@RequestMapping("/payout")
@CrossOrigin
public class PayoutExternalAPILoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(PayoutExternalAPILoginController.class);
	
	@Autowired
	PayoutExternalAPILoginService payoutExternalAPILoginService;
	
	
	@PostMapping("/sessions")
	public ResponseEntity<?> initiateSession( @RequestHeader(name = "x-api-key", required = true) String xApiKey,
			@RequestBody HashMap<String, Object> userDetails) throws Exception {
		logger.info("Entered: initiateSession()");

	     UserResponseModel userResponseModel = null;
         String apiKey = xApiKey;
		try {
			
			UserJsonResponse userJsonResponse = payoutExternalAPILoginService.generateCSRFToken();
			Boolean isSuccess = payoutExternalAPILoginService.initiateSession(userDetails);
			UserResponseModel.builder().isSucess(isSuccess).build();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage());
		}

		logger.info("Exited: initiateSession()");
		return new ResponseEntity<>(userResponseModel, HttpStatus.CREATED);
	}

}
