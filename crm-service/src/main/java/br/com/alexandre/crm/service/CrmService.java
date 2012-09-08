package br.com.alexandre.crm.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;

import br.com.alexandre.crm.service.domain.Customer;
import br.com.alexandre.crm.service.error.CrmServiceException;

@WebService
//Logging do XML de entrada
@InInterceptors(interceptors = "org.apache.cxf.interceptor.LoggingInInterceptor")
//Logging do XML de saida
@OutInterceptors(interceptors = "org.apache.cxf.interceptor.LoggingOutInterceptor")
public interface CrmService {
	@WebMethod
	@WebResult(name="customer")
	public Customer getCustomerInfo(@WebParam(name="id") Long id) throws CrmServiceException;
}
