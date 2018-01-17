package com.ejemplo2.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo2.model.TransaccionesSoap;
import com.ejemplo2.service.TransaccionesSoapService;
import com.ejemplo2.util.RestResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class TransaccionSoapController {

	@Autowired
	protected TransaccionesSoapService transaccionesSoapService;

	protected ObjectMapper mapper;

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String userJson)
			throws JsonParseException, JsonMappingException, IOException {

		this.mapper = new ObjectMapper();

		TransaccionesSoap transaccionesSoap = this.mapper.readValue(userJson, TransaccionesSoap.class);
		
		RestResponse restResponse =new RestResponse();
		if (!this.validate(transaccionesSoap, restResponse)) {
			restResponse.setResponseCode(HttpStatus.NOT_ACCEPTABLE.value());
			return restResponse;
		}

		this.transaccionesSoapService.save(transaccionesSoap);

		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
	}

	private boolean validate(TransaccionesSoap transaccionesSoap,RestResponse restResponse) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		boolean isValid = true;
		if (transaccionesSoap.getOperId() == null) {
			isValid = false;
			restResponse.setMessage("Falta OperId \n");
			return isValid;
		}
		if (StringUtils.trimToNull(transaccionesSoap.getNodo()) == null) {
			isValid = false;
			restResponse.setMessage("Falta Nodo \n");
			return isValid;
		}
		if (StringUtils.trimToNull(transaccionesSoap.getTrxId()) == null) {
			isValid = false;
			restResponse.setMessage("Falta TrxId \n");
			return isValid;
		}
		if (StringUtils.trimToNull(transaccionesSoap.getRequest()) == null) {
			isValid = false;
			return isValid;
		} else {
			try {
				sdf.parse(transaccionesSoap.getRequest());
			} catch (ParseException e) {
				isValid = false;
				restResponse.setMessage("Formato de Request invalido \n");
				return isValid;
			}
		}
		if (StringUtils.trimToNull(transaccionesSoap.getResponse()) == null) {
			isValid = false;
			return isValid;
		} else {
			try {
				sdf.parse(transaccionesSoap.getResponse());
			} catch (ParseException e) {
				isValid = false;
				restResponse.setMessage("Formato de Response invalido \n");
				return isValid;
			}
		}
		if (transaccionesSoap.getDuracion() == null) {
			isValid = false;
			restResponse.setMessage("Falta Duracion \n");
			return isValid;
		}
		return isValid;

	}
}
