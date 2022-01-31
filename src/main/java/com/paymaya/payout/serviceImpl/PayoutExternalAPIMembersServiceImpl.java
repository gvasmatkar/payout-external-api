package com.paymaya.payout.serviceImpl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.paymaya.payout.dao.PayoutExternalAPIMembersDao;
import com.paymaya.payout.model.MemberResponseModel;
import com.paymaya.payout.service.PayoutExternalAPIMembersService;

@Service
public class PayoutExternalAPIMembersServiceImpl implements  PayoutExternalAPIMembersService {

	
	@Autowired
	PayoutExternalAPIMembersDao payoutExternalAPIMembersDao;
	

	@Override
	public Boolean submitMemberFile(@Valid MultipartFile[] multipartFileArray) {
		
		return payoutExternalAPIMembersDao.submitMemberFile(multipartFileArray);
	}


	@Override
	public MemberResponseModel getMemberRecordStatus(Long phoneNumber) {
		
		return payoutExternalAPIMembersDao.getMemberRecordStatus(phoneNumber);
	}


	@Override
	public MemberResponseModel getWallet() {
		
		return payoutExternalAPIMembersDao.getWallet();
	}

}
