package com.example.vault.dao;

import java.util.Objects;
public class Credentials {
    private String clientId;
    private String clientSecret;

    public Credentials() {

    }
    public Credentials(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Credentials)) return false;
        Credentials that = (Credentials) o;
        return Objects.equals(getClientId(), that.getClientId()) && Objects.equals(getClientSecret(), that.getClientSecret());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientId(), getClientSecret());
    }
}
