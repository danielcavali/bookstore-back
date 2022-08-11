package com.daniel.bookstore.resources.exeptions;

public class StandartError {

	private Long timestamp;
	private Integer status;
	private String erro;

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public StandartError(Long timestamp, Integer status, String erro) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.erro = erro;
	}

	public StandartError() {
		super();
		// TODO Auto-generated constructor stub
	}

}
