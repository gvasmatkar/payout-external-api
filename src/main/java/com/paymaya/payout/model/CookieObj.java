package com.paymaya.payout.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
//@Builder
@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CookieObj {

	    public String path;
	    public String expires;
	    public String name;
	    public boolean httponly;
	    public String value;
	}