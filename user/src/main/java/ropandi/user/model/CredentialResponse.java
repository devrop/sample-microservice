package ropandi.user.model;


import java.io.Serializable;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CredentialResponse implements Serializable {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

   private String username;

  private String password;

  private Set<ScopeData> scopes;
  
  


}
