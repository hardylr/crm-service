package br.com.alexandre.crm.service.error;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.ws.WebFault;

@WebFault(name="CustomerException")
@XmlAccessorType(XmlAccessType.FIELD)
public class CrmServiceException extends Exception {

	private static final long serialVersionUID = 6146853951687885756L;

	private CrmServiceExceptionInfo getCustomerDetailsExceptionInfo;

	public CrmServiceExceptionInfo getGetCustomerDetailsExceptionInfo() {
		return getCustomerDetailsExceptionInfo;
	}

	public void setGetCustomerDetailsExceptionInfo(
			CrmServiceExceptionInfo getCustomerDetailsExceptionInfo) {
		this.getCustomerDetailsExceptionInfo = getCustomerDetailsExceptionInfo;
	}
	
	public static CrmServiceException clienteInexistente() {
		final CrmServiceExceptionInfo info = new CrmServiceExceptionInfo();
		info.setCode("1");
		info.setMessage("Cliente inexistente");
		
		final CrmServiceException exception = new CrmServiceException();
		exception.setGetCustomerDetailsExceptionInfo(info);
		
		return exception;
	}
	
	public static CrmServiceException entradaInvalida() {
		final CrmServiceExceptionInfo info = new CrmServiceExceptionInfo();
		info.setCode("2");
		info.setMessage("Entrada inválida");
		
		final CrmServiceException exception = new CrmServiceException();
		exception.setGetCustomerDetailsExceptionInfo(info);
		
		return exception;
	}
	
	
	public static CrmServiceException erroAoBuscarDados() {
		final CrmServiceExceptionInfo info = new CrmServiceExceptionInfo();
		info.setCode("3");
		info.setMessage("Erro ao buscar dados");
		
		final CrmServiceException exception = new CrmServiceException();
		exception.setGetCustomerDetailsExceptionInfo(info);
		
		return exception;
	}
	
}
