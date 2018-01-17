package com.ejemplo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo2.dao.TransaccionesSoapRepository;
import com.ejemplo2.model.TransaccionesSoap;

@Service
public class TransaccionesSoapImpl implements TransaccionesSoapService {

	@Autowired
	protected TransaccionesSoapRepository transaccionesSoapRepository;

	@Override
	public TransaccionesSoap save(TransaccionesSoap transaccionesSoap) {
		return this.transaccionesSoapRepository.save(transaccionesSoap);
	}

}
