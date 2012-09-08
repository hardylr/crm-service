package br.com.alexandre.crm.service.repository;

import br.com.alexandre.crm.service.domain.Customer;

public interface CustomerRepository {
	public Customer findById(final Long id);
}
