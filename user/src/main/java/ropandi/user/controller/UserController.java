package ropandi.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ropandi.user.model.CreatedResponse;
import ropandi.user.model.CredentialData;
import ropandi.user.model.CredentialRequest;
import ropandi.user.service.ICredentialService;

@RestController
@RequestMapping
public class UserController {

	@Autowired
	private ICredentialService credentialService;
	
	@GetMapping("loadByUsername")
	public ResponseEntity<CredentialData> loadByUsername(@RequestParam("username") String username){
		System.out.println("Call usename");
		CredentialData data = credentialService.loadByUsername(username);
		if(data !=null){
			return new ResponseEntity<CredentialData>(data,HttpStatus.OK);
		}
		
		return new ResponseEntity<CredentialData>(data,HttpStatus.BAD_REQUEST);
		
	}
	
	@PostMapping("save")
	public ResponseEntity<CreatedResponse> save(@RequestBody CredentialRequest body){
	     final int result = credentialService.save(body);
	     if(result ==1){
	    	 final String path = "/loadByUsername/?username="+body.getUsername();
	    	 return new ResponseEntity<CreatedResponse>(CreatedResponse.builder()
	    			 .username(body.getUsername())
	    			 .path(path).build()
	    			 ,HttpStatus.OK);
	    			 
	     }
		
		return new ResponseEntity<CreatedResponse>(CreatedResponse.builder()
   			 .errorMessage("FAILED")
   			 .build()
   			 ,HttpStatus.OK);
	}
	@GetMapping("test")
	public String test(){
		return "OK";
	}
}
