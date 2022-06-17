package com.example.vault.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.vault.config.EnvironmentVaultConfiguration;

@Configuration
@Import(value = EnvironmentVaultConfiguration.class)
public class VaultConfiguration {

    //    @Override
    //    public ClientAuthentication clientAuthentication() {
    //        return new TokenAuthentication("hvs.WQ2workIFWrkMlsACYuoChgb");
    //    }
    //
    //    @Override
    //    public VaultEndpoint vaultEndpoint() {
    //        try {
    //            return VaultEndpoint.from(new URI("http://127.0.0.1:8200"));
    //        } catch (URISyntaxException e) {
    //            throw new RuntimeException(e);
    //        }
    //    }
    //
    //    @Override
    //    public VaultTemplate vaultTemplate() {
    //        VaultTemplate vaultTemplate = new VaultTemplate(
    //               vaultEndpoint(), clientAuthentication()
    //        );
    //        return vaultTemplate;
    //    }

}
