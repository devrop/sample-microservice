package ropandi.user.service.impl;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ropandi.user.entity.MstUserCredential;
import ropandi.user.model.CredentialData;
import ropandi.user.model.CredentialRequest;
import ropandi.user.model.ScopeData;
import ropandi.user.repository.CredentialRepository;
import ropandi.user.service.ICredentialService;
@Service
@Transactional
public class CredentailService implements ICredentialService {

	@Autowired
	private CredentialRepository credentialRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public CredentialData loadByUsername(String username) {
		// TODO Auto-generated method stub
		Optional<MstUserCredential> opt = credentialRepository.findByUsername(username);
		if(opt.isPresent()){
			
			MstUserCredential c = opt.get();
			Set<ScopeData> list = new HashSet<>();
			if(c.getScopes() !=null){
				final String[] scopes = c.getScopes().split(",");
				int index = 0;
				for(String v : scopes){
					list.add(ScopeData.builder().id(index).value(v).build());
					index++;
				}
				
			}
			return CredentialData
					.builder()
					.username(c.getUsername())
					.password(c.getPassword())
					.scopes(list)
					.build();

		}
		
		return null;
		
				
		 
	}

	@Override
	public int save(CredentialRequest data) {
		// TODO Auto-generated method stub
		try{
			long createdAt = System.currentTimeMillis()/1000;
			credentialRepository
			.save(MstUserCredential
					.builder()
					.id(0L)
					.username(data.getUsername())
					.name(data.getName())
					.password(passwordEncoder.encode(data.getPassword()))
					.scopes(data.getScopes())
					.createdBy("SYSTEM")
					.createdAt(createdAt)
					.build()
					);
			

			return 1;
		}catch(Exception e){
		   System.out.println("ERROR " +e.getMessage());

			return 0;
		}
		
		
	}

}
