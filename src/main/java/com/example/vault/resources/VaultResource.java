package com.example.vault.resources;

import com.example.vault.dto.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;
import org.springframework.vault.support.VaultResponseSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.net.URISyntaxException;

@RestController
public class VaultResource {

//    @Autowired
//    VaultConfiguration vaultConfiguration;

    @Autowired
    VaultTemplate vaultTemplate;

    @PostMapping("/store")
    public String store(@RequestBody Credentials credentials) {
        //        VaultTemplate vaultTemplate = vaultConfiguration.vaultTemplate();

        VaultResponse response =
                vaultTemplate.write("cubbyhole/googlefit", new Credentials(credentials.getClientId(), credentials.getClientSecret()));

        if (response == null) {
            return "Unsuccess";
        }

        return "Success";

    }

    @GetMapping("/retrieve")
    public Credentials receive() {

        VaultResponseSupport<Credentials> resp = vaultTemplate.read("cubbyhole/googlefit", Credentials.class);

        if (resp == null) {
            return new Credentials("", "");
        }

        return resp.getData();
    }

}
