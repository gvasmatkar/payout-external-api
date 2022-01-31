package com.paymaya.payout.daoImpl;

import org.springframework.stereotype.Repository;

import com.paymaya.payout.dao.PayoutExternalAPIDisbursementDao;
import com.paymaya.payout.model.DisbursementModel;
import com.paymaya.payout.model.DisbursementResponseModel;

@Repository
public class PayoutExternalAPIDisbursementDaoImpl implements PayoutExternalAPIDisbursementDao {

	@Override
	public Boolean submitDisbursementFile(DisbursementModel disbursementDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DisbursementResponseModel submitDisbursementFile(Long disbursementId, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DisbursementResponseModel executeDisbursementFile(Long disbursementId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DisbursementResponseModel listFailedDisbursementRecords(Long disbursementId, int page, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DisbursementResponseModel listSuccessfulDisbursementRecords(Long disbursementId, int page, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

}
