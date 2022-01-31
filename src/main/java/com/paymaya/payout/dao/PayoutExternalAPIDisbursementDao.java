package com.paymaya.payout.dao;

import com.paymaya.payout.model.DisbursementModel;
import com.paymaya.payout.model.DisbursementResponseModel;

public interface PayoutExternalAPIDisbursementDao {

	Boolean submitDisbursementFile(DisbursementModel disbursementDetails);

	DisbursementResponseModel submitDisbursementFile(Long disbursementId, String password);

	DisbursementResponseModel executeDisbursementFile(Long disbursementId);

	DisbursementResponseModel listFailedDisbursementRecords(Long disbursementId, int page, int limit);

	DisbursementResponseModel listSuccessfulDisbursementRecords(Long disbursementId, int page, int limit);

}
