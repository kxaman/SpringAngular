package com.ejemplo2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo2.model.TransaccionesSoap;

public interface TransaccionesSoapRepository extends JpaRepository<TransaccionesSoap, Long> {

	@SuppressWarnings("unchecked")
	TransaccionesSoap save(TransaccionesSoap transaccionesSoap);
	
	//List<TransaccionesSoap> findAll();
}
