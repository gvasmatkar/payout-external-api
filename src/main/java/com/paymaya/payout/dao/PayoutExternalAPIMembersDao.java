package com.paymaya.payout.dao;

import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import com.paymaya.payout.model.MemberResponseModel;
import com.paymaya.payout.model.User;

public interface PayoutExternalAPIMembersDao {

	Boolean submitMemberFile(@Valid MultipartFile[] multipartFileArray);

	MemberResponseModel getMemberRecordStatus(Long phoneNumber);

	MemberResponseModel getWallet();

}
