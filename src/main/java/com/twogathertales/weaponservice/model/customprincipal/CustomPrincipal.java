package com.twogathertales.weaponservice.model.customprincipal;

import java.io.Serializable;

public class CustomPrincipal implements Serializable {

    private static final long serialVersionUID = 1L;


    private String id;
    private String username;
    private String email;
    private String token;

    public CustomPrincipal() {

    }

    public CustomPrincipal(String username, String email, String id) {
        this.username = username;
        this.email = email;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(String id) { this.id = id; }
    public String getId() { return this.id; }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}