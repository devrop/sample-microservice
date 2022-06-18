package ropandi.oauth.service;

import ropandi.oauth.model.CredentialData;

public interface ICredentialService {

	
	public CredentialData findOneByUsername(String username);
}
