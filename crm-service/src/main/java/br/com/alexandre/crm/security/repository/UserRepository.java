package br.com.alexandre.crm.security.repository;

import br.com.alexandre.crm.security.domain.User;

public interface UserRepository {
	public User findByUsername(final String username);
}
