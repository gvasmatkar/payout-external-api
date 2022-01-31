package com.paymaya.payout.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.paymaya.payout.model.MemberResponseModel;


public interface PayoutExternalAPIMembersService {

	Boolean submitMemberFile(@Valid MultipartFile[] multipartFileArray);

	MemberResponseModel getMemberRecordStatus(Long phoneNumber);

	MemberResponseModel getWallet();

}
