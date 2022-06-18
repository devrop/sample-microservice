package ropandi.oauth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ropandi.oauth.service.ICredentialService;
@Service
public class CredentialsDetailsService implements UserDetailsService {

	@Autowired
	private ICredentialService credentialService; 
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		// TODO Auto-generated method stub	
		return credentialService.findOneByUsername(id);
	}

}
