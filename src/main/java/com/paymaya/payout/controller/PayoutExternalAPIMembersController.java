package com.paymaya.payout.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.paymaya.payout.model.MemberResponseModel;
import com.paymaya.payout.service.PayoutExternalAPIMembersService;

@RestController
@RequestMapping("/payout")
@CrossOrigin
public class PayoutExternalAPIMembersController{
	
	
private static final Logger logger = LoggerFactory.getLogger(PayoutExternalAPIMembersController.class);
	
	@Autowired
	PayoutExternalAPIMembersService payoutExternalAPIMembersService;
	
	
	@PostMapping("/members")
	public ResponseEntity<?> submitMemberFile(@RequestHeader(name = "x-consumer-id", required = true) String xApiKey,
			@Valid @RequestPart(value = "file") MultipartFile[] multipartFileArray) throws Exception {
		logger.info("Entered: submitMemberFile()");

	     MemberResponseModel memberResponseModel = null;

		try {
			Boolean isSuccess = payoutExternalAPIMembersService.submitMemberFile(multipartFileArray);
			MemberResponseModel.builder().isSucess(isSuccess).build();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage());
		}

		logger.info("Exited: submitMemberFile()");
		return new ResponseEntity<>(memberResponseModel, HttpStatus.CREATED);
	}

	
	@GetMapping("/members/{phoneNumber}")
	public ResponseEntity<MemberResponseModel> getMemberRecordStatus(@RequestHeader(name = "x-consumer-id", required = true) String xApiKey, @PathVariable Long phoneNumber) throws Exception {
		logger.info("Entered: getMemberRecordStatus()");

		MemberResponseModel memberResponseModel = null;

		try {
			memberResponseModel = payoutExternalAPIMembersService.getMemberRecordStatus(phoneNumber);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage());
		}

		logger.info("Exited: getMemberRecordStatus()");
		return new ResponseEntity<>(memberResponseModel, HttpStatus.OK);
	}
	
	@GetMapping("/wallet")
	public ResponseEntity<MemberResponseModel> getWallet(@RequestHeader(name = "x-consumer-id", required = true) String xApiKey) throws Exception {
		logger.info("Entered: getWallet()");

		MemberResponseModel memberResponseModel = null;

		try {
			memberResponseModel = payoutExternalAPIMembersService.getWallet();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage());
		}

		logger.info("Exited: getWallet()");
		return new ResponseEntity<>(memberResponseModel, HttpStatus.OK);
	}

}
