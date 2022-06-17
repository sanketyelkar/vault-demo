package com.example.vault;

import com.example.vault.dao.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;
import org.springframework.vault.support.VaultResponseSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URISyntaxException;

@RestController
public class VaultResource {
    @Autowired
    VaultTemplate vaultTemplate;

    @GetMapping("/demo")
    public String demo() throws URISyntaxException {

        VaultResponse response =
                vaultTemplate.write("cubbyhole/demo", new Credentials("sajdsf123", "asdqwe"));

        VaultResponseSupport<Credentials> resp = vaultTemplate.read("cubbyhole/demo", Credentials.class);

        String username="";
        String password="";

        username = resp.getData().getClientId();
        password = resp.getData().getClientSecret();

        return username+" : "+password;
    }

}
