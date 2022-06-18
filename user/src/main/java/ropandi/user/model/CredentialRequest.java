package ropandi.user.model;

import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ropandi.user.model.CredentialData.CredentialDataBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CredentialRequest implements Serializable {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String username;
 private String name;
 private String password;
 private String scopes;

}
