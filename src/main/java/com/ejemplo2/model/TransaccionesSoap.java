package com.ejemplo2.model;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transacciones_soap")
@Access(AccessType.FIELD)

public class TransaccionesSoap extends ParentEntity {

	private static final long serialVersionUID = 6519280644111480834L;

	@Getter
	@Setter
	@Column(name = "operId", nullable = false, length = 4)
	private short operId;

	@Getter
	@Setter
	@Column(name = "nodo", nullable = false, length = 30)
	private String nodo;

	@Getter
	@Setter
	@Column(name = "trxId", nullable = false, length = 30)
	private String trxId;

	@Getter
	@Setter
	@Column(name = "request", nullable = false)
	private Date request;

	@Getter
	@Setter
	@Column(name = "response", nullable = false)
	private Date response;

	@Getter
	@Setter
	@Column(name = "duracion", nullable = false)
	private int duracion;

	@Getter
	@Setter
	@Column(name = "errorSOAP", nullable = true)
	private int errorSOAP;

	
}
