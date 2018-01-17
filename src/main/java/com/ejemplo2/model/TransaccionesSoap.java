package com.ejemplo2.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "transacciones_soap")
@Access(AccessType.FIELD)

public class TransaccionesSoap extends ParentEntity {

	private static final long serialVersionUID = 6519280644111480834L;

	@Column(name = "operid", nullable = false)
	private Integer operId;

	@Column(name = "nodo", nullable = false, length = 30)
	private String nodo;

	@Column(name = "trxid", nullable = false, length = 30)
	private String trxId;

	@Column(name = "request", nullable = false)
	private String request;

	@Column(name = "response", nullable = false)
	private String response;

	@Column(name = "duracion", nullable = false,unique=true)
	private Integer duracion;

	@Column(name = "errorSOAP", nullable = true)
	private int errorSOAP;

	public Integer getOperId() {
		return operId;
	}

	public void setOperId(Integer operId) {
		this.operId = operId;
	}

	public String getNodo() {
		return nodo;
	}

	public void setNodo(String nodo) {
		this.nodo = nodo;
	}

	public String getTrxId() {
		return trxId;
	}

	public void setTrxId(String trxId) {
		this.trxId = trxId;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public int getErrorSOAP() {
		return errorSOAP;
	}

	public void setErrorSOAP(int errorSOAP) {
		this.errorSOAP = errorSOAP;
	}

}
