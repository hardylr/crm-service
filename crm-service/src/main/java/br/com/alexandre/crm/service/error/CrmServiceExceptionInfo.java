package br.com.alexandre.crm.service.error;

import java.io.Serializable;
import java.util.Date;

public class CrmServiceExceptionInfo implements Serializable {

	private static final long serialVersionUID = -1879375130348669069L;

	private String code;
	
	private String message;

	private Date date = new Date();
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
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
