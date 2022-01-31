package com.paymaya.payout.daoImpl;

import javax.validation.Valid;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.paymaya.payout.dao.PayoutExternalAPIMembersDao;
import com.paymaya.payout.model.MemberResponseModel;

@Repository
public class PayoutExternalAPIMembersDaoImpl implements  PayoutExternalAPIMembersDao{

	@Override
	public Boolean submitMemberFile(@Valid MultipartFile[] multipartFileArray) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberResponseModel getMemberRecordStatus(Long phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberResponseModel getWallet() {
		// TODO Auto-generated method stub
		return null;
	}

}
