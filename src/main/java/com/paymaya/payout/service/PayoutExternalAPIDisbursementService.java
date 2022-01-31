package com.paymaya.payout.service;

import com.paymaya.payout.model.DisbursementModel;
import com.paymaya.payout.model.DisbursementResponseModel;
import com.paymaya.payout.model.MemberResponseModel;

public interface PayoutExternalAPIDisbursementService {

	Boolean submitDisbursementFile(DisbursementModel disbursementDetails);

	DisbursementResponseModel getDisbursementFileStatus(Long disbursementId, String password);

	DisbursementResponseModel executeDisbursementFile(Long disbursementId);

	DisbursementResponseModel listFailedDisbursementRecords(Long disbursementId, int page, int limit);

	DisbursementResponseModel listSuccessfulDisbursementRecords(Long disbursementId, int page, int limit);

}
