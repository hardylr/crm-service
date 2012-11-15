package br.com.alexandre.crm.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;

import br.com.alexandre.crm.service.error.CustomerServiceException;
import br.com.alexandre.crm.service.interfaces.CustomerServiceRequestType;
import br.com.alexandre.crm.service.interfaces.CustomerServiceResponseType;

@WebService
//Logging do XML de entrada
@InInterceptors(interceptors = "org.apache.cxf.interceptor.LoggingInInterceptor")
//Logging do XML de saida
@OutInterceptors(interceptors = "org.apache.cxf.interceptor.LoggingOutInterceptor")
public interface CustomerService {
	@WebMethod
	@WebResult(name="customerServiceResponse")
	public CustomerServiceResponseType getCustomerInfo(@WebParam(name="customerServiceRequest") final CustomerServiceRequestType customerServiceRequest) throws CustomerServiceException;
}
