package br.com.alexandre.crm.service;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alexandre.crm.service.domain.Customer;
import br.com.alexandre.crm.service.error.CrmServiceException;
import br.com.alexandre.crm.service.repository.CustomerRepository;

@Component(value="crmService")
@WebService(endpointInterface="br.com.alexandre.crm.service.CrmService",
			serviceName="CrmService",
			portName="CrmServicePort",
			name="CrmService")
public class CrmServiceImpl implements CrmService {

	@Autowired
	private CustomerRepository customerRepository;
	
	private Logger logger = Logger.getLogger(getClass());

	public Customer getCustomerInfo(final Long id) throws CrmServiceException {
		if (id <= 0) {
			logger.info("Entrada invalida");
			throw CrmServiceException.entradaInvalida();
		}
		
		try {
			final Customer customer = customerRepository.findById(id);
			
			if (customer == null) {
				logger.info("Cliente inexistente com o ID " + id);
				throw CrmServiceException.clienteInexistente();
			} 
			
			return customer;
		} catch (RuntimeException ex) {
			logger.error("Erro ao buscar dados", ex);
			throw CrmServiceException.erroAoBuscarDados();
		}
	}

}
