package com.ejemplo2.service;

import java.util.List;

import com.ejemplo2.model.TransaccionesSoap;

public interface TransaccionesSoapService {

	TransaccionesSoap save(TransaccionesSoap transaccionesSoap);

	List<TransaccionesSoap> findAll();

}
