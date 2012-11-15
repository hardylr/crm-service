package br.com.alexandre.crm.service.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;

import br.com.alexandre.crm.service.domain.Customer;

@Repository("customerRepository")
@Transactional
public class CustomerDAO implements CustomerRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public Customer findByCustomerId(final String customerId) {
		Customer customer = null;
		
		final TypedQuery<Customer> typedQuery = entityManager.createNamedQuery("Customer.findByCustomerId", Customer.class);
		typedQuery.setParameter("customerId", customerId);
		
		try {
			customer = typedQuery.getSingleResult();
		} catch (NoResultException e) {
			throw new CustomerRepositoryException("Cliente inexistente", e);
		} catch (NonUniqueResultException e) {
			throw new CustomerRepositoryException("Cliente nao unico", e);
		} catch (PersistenceException e) {
			throw new CustomerRepositoryException("Erro generico de persistencia", e);
		}
		return customer;
	}
}
