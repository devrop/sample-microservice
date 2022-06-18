package ropandi.oauth.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ropandi.oauth.model.CredentialData;
import ropandi.oauth.model.CredentialResponse;
import ropandi.oauth.service.ICredentialService;

@Service
public class CredentialService implements ICredentialService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${custom.url.user}")
	private String baseUrlUser;
	
	@Override
	public CredentialData findOneByUsername(String username) {
		// TODO Auto-generated method stub
		try{
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <CredentialResponse> entity = new HttpEntity<>(headers);
	    StringBuffer sb = new StringBuffer(baseUrlUser);
	    sb.append("/");
	    sb.append("loadByUsername");
	    sb.append("?username=");
	    sb.append(username);
	    CredentialResponse data = restTemplate.exchange(sb.toString(), HttpMethod.GET, entity, CredentialResponse.class).getBody();
		CredentialData dd = new CredentialData();
		dd.setUsername(data.getUsername());
		dd.setPassword(data.getPassword());
		dd.setScopes(data.getScopes());
	    
	    return dd;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	

}
