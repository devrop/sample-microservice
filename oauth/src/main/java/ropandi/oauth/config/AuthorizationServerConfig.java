package ropandi.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	 /**
	   * One day in seconds for trusted apps
	   */
	  private static final int ONE_DAY = 86400;

	  /**
	   * Three hours in seconds
	   */
	  private static final int THREE_HOURS = 10800;

	  @Autowired
	  private TokenStore tokenStore;
	  @Autowired
	  private JwtAccessTokenConverter jwtAccessTokenConverter;

	 
	
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	  public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
	    oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	  }

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
		.withClient("ecommerce") // ecommerce microservice
        .secret("9ecc8459ea5f39f9da55cb4d71a70b5d1e0f0b78")
        .authorizedGrantTypes("authorization_code", "refresh_token", "implicit",
            "client_credentials")
        .authorities("maintainer", "owner", "user")
        .scopes("read", "write")
        .and()
		.
		withClient("client").secret("secret")
				.authorizedGrantTypes("client_credentials").scopes("resource-server-read", "resource-server-write")
				.authorities("operator")
		        .scopes("trust")
		        .accessTokenValiditySeconds(ONE_DAY)
				;
	}
	@Override
	  public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
	    endpoints.authenticationManager(this.authenticationManager).approvalStoreDisabled()
	        .tokenStore(this.tokenStore).accessTokenConverter(this.jwtAccessTokenConverter);
	  }
}
