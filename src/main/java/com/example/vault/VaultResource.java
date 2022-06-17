package com.example.vault;

import com.example.vault.dto.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;
import org.springframework.vault.support.VaultResponseSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URISyntaxException;

@RestController
public class VaultResource {

//    @Autowired
//    VaultConfiguration vaultConfiguration;

    @Autowired
    VaultTemplate vaultTemplate;

    @GetMapping("/demo")
    public String demo() throws URISyntaxException {
//        VaultTemplate vaultTemplate = vaultConfiguration.vaultTemplate();

        VaultResponse response =
                vaultTemplate.write("cubbyhole/googlefit", new Credentials("sajdsf123", "asdqwe"));

        VaultResponseSupport<Credentials> resp = vaultTemplate.read("cubbyhole/googlefit", Credentials.class);

        String username="";
        String password="";

        username = resp.getData().getClientId();
        password = resp.getData().getClientSecret();

        return username+" : "+password;
    }

}
