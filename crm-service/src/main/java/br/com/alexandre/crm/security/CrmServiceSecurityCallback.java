package br.com.alexandre.crm.security;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.ws.security.WSPasswordCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alexandre.crm.security.domain.User;
import br.com.alexandre.crm.security.repository.UserRepository;

@Component(value="passwordCallback")
public class CrmServiceSecurityCallback implements CallbackHandler {

	@Autowired
	private UserRepository userRepository;
	
	public void handle(final Callback[] callbacks) throws IOException,
	UnsupportedCallbackException {
		for (Callback callback: callbacks) {
			final WSPasswordCallback pc = (WSPasswordCallback) callback;
			
			final User user = userRepository.findByUsername(pc.getIdentifier());
			
			if (user != null) {
				//Será comparado com o enviado
				pc.setPassword(user.getPassword());
			}			
		}
	}

}
