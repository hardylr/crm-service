package br.com.alexandre.crm.service;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alexandre.crm.service.domain.Address;
import br.com.alexandre.crm.service.domain.Customer;
import br.com.alexandre.crm.service.error.CustomerServiceException;
import br.com.alexandre.crm.service.interfaces.AddressType;
import br.com.alexandre.crm.service.interfaces.CustomerServiceRequestType;
import br.com.alexandre.crm.service.interfaces.CustomerServiceResponseType;
import br.com.alexandre.crm.service.interfaces.CustomerType;
import br.com.alexandre.crm.service.repository.CustomerRepository;

@Component(value="customerService")
@WebService(endpointInterface="br.com.alexandre.crm.service.CustomerService",
			serviceName="CustomerService",
			portName="CustomerServicePort",
			name="CustomerService")
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	public CustomerServiceImpl(final CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public CustomerServiceResponseType getCustomerInfo(final CustomerServiceRequestType customerServiceRequest) throws CustomerServiceException {
		if (customerServiceRequest == null || "".equals(customerServiceRequest.getCustomerId())) {
			throw new CustomerServiceException(2001, "Entrada Invalida");
		}				
		try {
			return tryToGetCustomerInfo(customerServiceRequest);
		} catch (final RuntimeException e) {
			logger.error("Ocorreu um erro ao invocar o servico: ", e);
			throw new CustomerServiceException(2002, e.getMessage());
		}
	}

	private CustomerServiceResponseType tryToGetCustomerInfo(final CustomerServiceRequestType customerServiceRequest) {
		final Customer customer = customerRepository.findByCustomerId(customerServiceRequest.getCustomerId());
		return CustomerServiceMapper.map(customer);
	}
	
	private static class CustomerServiceMapper {
		public static CustomerServiceResponseType map(final Customer customer) {
			final CustomerType customerType = from(customer);
			
			final CustomerServiceResponseType customerServiceResponseType = new CustomerServiceResponseType();			
			customerServiceResponseType.setCustomer(customerType);
						
			return customerServiceResponseType;
		}
		
		private static CustomerType from(final Customer customer) {
			CustomerType customerType = null;
			
			if (customer != null) {
				customerType = new CustomerType();
				customerType.setName(customer.getName());
				customerType.setSex((customer.getSex() != null)? customer.getSex().toString(): null);
				customerType.setTelephone(customer.getTelephone());
				customerType.setEmail(customer.getEmail());
				customerType.setAddress(from(customer.getAddress()));
			}
			
			return customerType;
		}
		
		private static AddressType from(final Address address) {
			AddressType addressType = null;
			
			if (address != null) {
				addressType = new AddressType();
				addressType.setStreet(address.getStreet());
				addressType.setCity(address.getCity());
				addressType.setZipCode(address.getZipCode());
			}
			
			return addressType;
		}
	}
	
}
