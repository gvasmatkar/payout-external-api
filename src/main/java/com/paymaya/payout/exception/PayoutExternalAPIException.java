package com.paymaya.payout.exception;

public class PayoutExternalAPIException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PayoutExternalAPIException() {
		super();
	}

	public PayoutExternalAPIException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PayoutExternalAPIException(String message, Throwable cause) {
		super(message, cause);
	}

	public PayoutExternalAPIException(String message) {
		super(message);
	}

	public PayoutExternalAPIException(Throwable cause) {
		super(cause);
	}

    
    
}
