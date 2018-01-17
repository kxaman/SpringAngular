package com.ejemplo2.util;

import com.ejemplo2.model.TransaccionesSoap;

public class RestResponse {

	private Integer responseCode;

	private String message;

	private TransaccionesSoap transaccionesSoap;


	public RestResponse(Integer responseCode) {
		super();
		this.responseCode=responseCode;
	}
	public RestResponse(Integer responseCode, String message) {
		super();
		this.responseCode=responseCode;
		this.message=message;
	}

	public RestResponse() {
		
	}
	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TransaccionesSoap getTransaccionesSoap() {
		return transaccionesSoap;
	}

	public void setTransaccionesSoap(TransaccionesSoap transaccionesSoap) {
		this.transaccionesSoap = transaccionesSoap;
	}

}
