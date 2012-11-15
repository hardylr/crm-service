package br.com.alexandre.crm.service.error;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.ws.WebFault;

@WebFault(name="CustomerException")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerServiceException extends Exception {
	
	private static final long serialVersionUID = 6146853951687885756L;

	private CustomerServiceExceptionInfo customerServiceExceptionInfo;

	public CustomerServiceException() { }
	
	public CustomerServiceException(final Integer code, final String message) {
		super(message);
		this.customerServiceExceptionInfo = new CustomerServiceExceptionInfo(code, message);
	}

	public CustomerServiceExceptionInfo getCustomerServiceExceptionInfo() {
		return customerServiceExceptionInfo;
	}

	public void setCustomerServiceExceptionInfo(CustomerServiceExceptionInfo customerServiceExceptionInfo) {
		this.customerServiceExceptionInfo = customerServiceExceptionInfo;
	}

	
	
}
