package ropandi.user.service;

import ropandi.user.model.CredentialData;
import ropandi.user.model.CredentialRequest;

public interface ICredentialService {

	
	public CredentialData loadByUsername(String username);
	
	public int save(CredentialRequest data);
	
}
