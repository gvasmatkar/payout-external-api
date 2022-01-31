package com.paymaya.payout.model;

import java.io.File;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DisbursementModel {
	
	@NotEmpty(message = "name is required.")
//	@NotNull(message = "name is required.")
	@Size(min = 2, max = 50, message = "The length of full name must be between 2 and 100 characters.")
	@Pattern(regexp = "^\\d{1,5}$", flags = { Flag.CASE_INSENSITIVE, Flag.MULTILINE }, message = "")
	private String name;
	
	@NotEmpty(message = "wallet is required.")
//	@NotNull(message = "wallet is required.")
	@Size(min = 2, max = 50, message = "The length of full name must be between 2 and 100 characters.")
	@Pattern(regexp = "/^[0-9A-F]{8}-[0-9A-F]{4}-[4][0-9A-F]{3}-[89AB][0-9A-F]{3}-[0-9A-F]{12}$/i", flags = { Flag.CASE_INSENSITIVE, Flag.MULTILINE }, message = "")
	private String wallet;
	
	@NotEmpty(message = "CSVFile is required.")
//	@NotNull(message = "CSVFile is required.")
	@Size(min = 2, max = 50, message = "The length of full name must be between 2 and 100 characters.")
	@Pattern(regexp = "^\\d{1,5}$", flags = { Flag.CASE_INSENSITIVE, Flag.MULTILINE }, message = "")
	private File CSVFile;
	
  
}