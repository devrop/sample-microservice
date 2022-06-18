package ropandi.auth.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ropandi.auth.entity.MstCredential;
import ropandi.auth.entity.MstScope;
import ropandi.auth.entity.MstScopePK;
import ropandi.auth.model.CredentialRequest;
import ropandi.auth.repository.CredentialRepository;
import ropandi.auth.repository.ScopeRepository;
import ropandi.auth.service.ICredentialService;

@Service
public class CredentialService implements ICredentialService {

	@Autowired
	private CredentialRepository credentialRepository;

	@Autowired
	private ScopeRepository scopeRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public CredentialRequest newCredential(CredentialRequest credentialRequest) {
		// TODO Auto-generated method stub
		try{
         System.out.println("Masuk suni");
        
		final MstCredential credential = MstCredential.builder().id(credentialRequest.getId())
				.email(credentialRequest.getEmail()).name(credentialRequest.getName())
				.password(this.passwordEncoder.encode(credentialRequest.getPassword())).build();
		this.credentialRepository.save(credential);
		System.out.println(" end excute ");
        this.scopeRepository.save(MstScope.builder().mstScopePK(MstScopePK.builder().clientId(credentialRequest.getId()).scopeId("operator").build()).value("Opeartor").build());
		return credentialRequest;
		}catch(Exception e){
			System.out.println("error data");
			return null;
		}
		
	}

}
