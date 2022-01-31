package com.paymaya.payout.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paymaya.payout.model.DisbursementModel;
import com.paymaya.payout.model.DisbursementResponseModel;
import com.paymaya.payout.service.PayoutExternalAPIDisbursementService;

@RestController
@RequestMapping("/payout")
@CrossOrigin
public class PayoutExternalAPIDisbursementController {

	private static final Logger logger = LoggerFactory.getLogger(PayoutExternalAPIDisbursementController.class);

	@Autowired
	PayoutExternalAPIDisbursementService payoutExternalAPIDisbursementService;

	@PostMapping("/disbursements")
	public ResponseEntity<?> submitDisbursementFile(@RequestHeader(name = "x-api-key", required = true) String xApiKey,
			@RequestBody DisbursementModel disbursementDetails) throws Exception {
		logger.info("Entered: submitDisbursementFile()");

		DisbursementResponseModel disbursementResponseModel = null;

		try {
			Boolean isSuccess = payoutExternalAPIDisbursementService.submitDisbursementFile(disbursementDetails);
			DisbursementResponseModel.builder().isSucess(isSuccess).build();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage());
		}

		logger.info("Exited: submitDisbursementFile()");
		return new ResponseEntity<>(disbursementResponseModel, HttpStatus.CREATED);
	}

	@GetMapping("/disbursements/{disbursementId}")
	public ResponseEntity<DisbursementResponseModel> getDisbursementFileStatus(
			@RequestHeader(name = "x-api-key", required = true) String xApiKey, @PathVariable Long disbursementId,
			@RequestBody String password) throws Exception {
		logger.info("Entered: getDisbursementFileStatus()");

		DisbursementResponseModel disbursementResponseModel = null;

		try {
			disbursementResponseModel = payoutExternalAPIDisbursementService.getDisbursementFileStatus(disbursementId,
					password);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage());
		}

		logger.info("Exited: getDisbursementFileStatus()");
		return new ResponseEntity<>(disbursementResponseModel, HttpStatus.OK);
	}

	@PostMapping("/disbursements/{disbursementId}")
	public ResponseEntity<DisbursementResponseModel> executeDisbursementFile(
			@RequestHeader(name = "x-api-key", required = true) String xApiKey, @PathVariable Long disbursementId)
			throws Exception {
		logger.info("Entered: executeDisbursementFile()");

		DisbursementResponseModel disbursementResponseModel = null;

		try {
			disbursementResponseModel = payoutExternalAPIDisbursementService.executeDisbursementFile(disbursementId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage());
		}

		logger.info("Exited: executeDisbursementFile()");
		return new ResponseEntity<>(disbursementResponseModel, HttpStatus.OK);
	}

	@GetMapping("/disbursements/{disbursementId}/records-failed")
	public ResponseEntity<DisbursementResponseModel> listFailedDisbursementRecords(
			@RequestHeader(name = "x-api-key", required = true) String xApiKey, @PathVariable Long disbursementId,
			@RequestParam int page, @RequestParam int limit) throws Exception {
		logger.info("Entered: listFailedDisbursementRecords()");

		DisbursementResponseModel disbursementResponseModel = null;

		try {
			disbursementResponseModel = payoutExternalAPIDisbursementService
					.listFailedDisbursementRecords(disbursementId, page, limit);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage());
		}

		logger.info("Exited: listFailedDisbursementRecords()");
		return new ResponseEntity<>(disbursementResponseModel, HttpStatus.OK);
	}

	@GetMapping("/disbursements/{disbursementId}/records-success")
	public ResponseEntity<DisbursementResponseModel> listSuccessfulDisbursementRecords(
			@RequestHeader(name = "x-api-key", required = true) String xApiKey, @PathVariable Long disbursementId,
			@RequestParam int page, @RequestParam int limit) throws Exception {
		logger.info("Entered: listSuccessfulDisbursementRecords()");

		DisbursementResponseModel disbursementResponseModel = null;

		try {
			disbursementResponseModel = payoutExternalAPIDisbursementService
					.listSuccessfulDisbursementRecords(disbursementId, page, limit);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage());
		}

		logger.info("Exited: listSuccessfulDisbursementRecords()");
		return new ResponseEntity<>(disbursementResponseModel, HttpStatus.OK);
	}

}
