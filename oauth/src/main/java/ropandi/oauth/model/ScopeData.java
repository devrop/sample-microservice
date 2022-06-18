package ropandi.oauth.model;

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
public class ScopeData implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String value;
}
