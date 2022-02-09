package com.paymaya.payout.annotation;

import java.io.FileReader;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;

public class CSVFileValidator implements ConstraintValidator<CSVFileValidation, MultipartFile> {

	@Override
	public void initialize(CSVFileValidation constraintAnnotation) {

	}

	@Override
	public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext context) {

		boolean result = true;

		String contentType = multipartFile.getContentType();
		if (!isSupportedContentType(contentType)) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Only csv is allowed.").addConstraintViolation();

			result = false;
		}

		CSVReader reader = null;
		try {
			// parsing a CSV file into CSVReader class constructor
			reader = new CSVReader(new FileReader(multipartFile.getOriginalFilename()));
			String[] nextLine;
			// reads one line at a time
			Integer rowNumbers = 0;
			while ((nextLine = reader.readNext()) != null) {

				rowNumbers++;
			}
			if (rowNumbers > 1000) {

				result = false;
			}
			Double csvFileSize = filesize_in_kiloBytes(multipartFile);

			if (csvFileSize < 1 && csvFileSize > 50) {

				result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	private boolean isSupportedContentType(String contentType) {
		return contentType.equals("csv");
	}

	private static double filesize_in_kiloBytes(MultipartFile multipartFile) {
		return (double) multipartFile.getSize() / 1024;
	}

}
