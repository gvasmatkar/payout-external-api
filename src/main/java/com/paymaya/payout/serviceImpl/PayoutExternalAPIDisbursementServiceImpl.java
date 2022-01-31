package com.paymaya.payout.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymaya.payout.dao.PayoutExternalAPIDisbursementDao;
import com.paymaya.payout.model.DisbursementModel;
import com.paymaya.payout.model.DisbursementResponseModel;
import com.paymaya.payout.service.PayoutExternalAPIDisbursementService;

@Service
public class PayoutExternalAPIDisbursementServiceImpl implements PayoutExternalAPIDisbursementService  {

	@Autowired
	PayoutExternalAPIDisbursementDao payoutExternalAPIDisbursementDao;
	
	@Override
	public Boolean submitDisbursementFile(DisbursementModel disbursementDetails) {
		
		return payoutExternalAPIDisbursementDao.submitDisbursementFile(disbursementDetails);
	}

	@Override
	public DisbursementResponseModel getDisbursementFileStatus(Long disbursementId, String password) {
		
		return payoutExternalAPIDisbursementDao.submitDisbursementFile(disbursementId,password);
	}

	@Override
	public DisbursementResponseModel executeDisbursementFile(Long disbursementId) {
	
		return payoutExternalAPIDisbursementDao.executeDisbursementFile(disbursementId);
		
	}

	@Override
	public DisbursementResponseModel listFailedDisbursementRecords(Long disbursementId, int page, int limit) {
		
		return payoutExternalAPIDisbursementDao.listFailedDisbursementRecords(disbursementId, page,limit);
	}

	@Override
	public DisbursementResponseModel listSuccessfulDisbursementRecords(Long disbursementId, int page, int limit) {
	
		return payoutExternalAPIDisbursementDao.listSuccessfulDisbursementRecords(disbursementId, page,limit);
	}

}
