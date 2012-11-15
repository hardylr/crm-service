package br.com.alexandre.crm.service.repository;

public class CustomerRepositoryException extends RuntimeException {

	private static final long serialVersionUID = -5633273459441816921L;

	public CustomerRepositoryException() {
	}

	public CustomerRepositoryException(String message) {
		super(message);
	}

	public CustomerRepositoryException(Throwable cause) {
		super(cause);
	}

	public CustomerRepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

}
