package br.com.alexandre.crm.service.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;

import br.com.alexandre.crm.service.domain.Customer;

@Repository("customerRepository")
@Transactional
public class CustomerDAO implements CustomerRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public Customer findById(Long id) {
		return entityManager.find(Customer.class, id);
	}
}
