package com.ford.vaultteam.vaultpcf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.config.AbstractVaultConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import javax.annotation.PostConstruct;


// @Configuration
// @ComponentScan
// @EnableAutoConfiguration
@SpringBootApplication
@Configuration
@RestController
public class VaultpcfApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaultpcfApplication.class, args);
	}

	@Value("${username}")
   		String username;

	@Value("${password}")
   		String password;

  	@PostConstruct
		private void postConstruct() {
		    System.out.println("##########################");
	   		System.out.println(username);
	   		System.out.println(password);
	    	System.out.println("##########################");
	}

	@RequestMapping("/")
  		public String home() {
    		return "Hello " + username + password;
  }
}

// @RestController
// class SecretGrabberController {
//     @Autowired 
// 	private Environment env;
// 	public String getUsername() {
// 		return env.getProperty("username");
// 	}
//     @RequestMapping("/")
//     String strapp(){
    	
//     	// String secretPath = "kv/test";
// 		// String namespace = "pcf_testing_space";
        
//     	// // (1) Instantiate an object that contains the Vault Configuration 
//     	// AbstractVaultConfiguration vaultConfig = new AppConfiguration();
    	
//     	// // (2) Pass the Vault Configuration to the Vault Template Object
//     	// VaultTemplate vaultTemplate = new NamespaceScopedVaultTemplate(vaultConfig.vaultEndpoint(),vaultConfig.clientAuthentication(), namespace);
   
//     	// // (3) Vault Template Object will read the secret using secretPath.  The secrets will be placed 
//     	// // in the Secrets object
//     	// VaultResponseSupport<Secrets> response = vaultTemplate.read(secretPath, Secrets.class);
          	
//     	// (4) Returns the secrets
// 		String token = env.getProperty("VAULT_TOKEN");
//     	return "<br><u><Secrets</u><br>Username: " + env.getProperty("username") + env.getProperty("VAULT_TOKEN");
//     }
// }