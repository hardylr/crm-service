package br.com.alexandre.crm.security.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.alexandre.crm.security.domain.User;

@Repository(value="userRepository")
public class UserDAO implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public User findByUsername(final String username) {
		final TypedQuery<User> typedQuery = entityManager.createNamedQuery("User.findByUsername", User.class);
		typedQuery.setParameter("username", username);
		
		try {
			return typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		} catch (NonUniqueResultException ex) {
			return null;
		}
	}
	
	

}
