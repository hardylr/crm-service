package br.com.alexandre.crm.service.error;

import java.io.Serializable;
import java.util.Date;

public class CustomerServiceExceptionInfo implements Serializable {

	private static final long serialVersionUID = -1879375130348669069L;

	private Integer code;
	
	private String message;

	private Date date = new Date();
	
	public CustomerServiceExceptionInfo() { }
	
	public CustomerServiceExceptionInfo(final Integer code, final String message) {
		this.code = code;
		this.message = message;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
