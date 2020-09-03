package com.hashicorp.vault;

import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.PcfAuthentication;
import org.springframework.vault.authentication.PcfAuthenticationOptions;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

@Configuration
public class AppConfiguration extends AbstractVaultConfiguration {

  private String scheme;
  private String host;
  private String role;

  @Override
  public VaultEndpoint vaultEndpoint() {
    
	scheme = "https";
    host = "vaultdev.app.ford.com";
    VaultEndpoint endpoint = new VaultEndpoint();
    endpoint.setScheme(scheme);
    endpoint.setHost(host);
    endpoint.setPort(443);
    return endpoint;
  }

  @Override
  public ClientAuthentication clientAuthentication() {

    role = "flasktest";
    
    PcfAuthenticationOptions.PcfAuthenticationOptionsBuilder builder =
        PcfAuthenticationOptions.builder().role(role).path("pcf_testing_space/kv/test");

    return new PcfAuthentication(builder.build(), restOperations());
  }
}