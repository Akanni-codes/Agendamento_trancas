package com.agenda.trancas.DTO;

public record AuthRequest(
        String Email,
        String password
) {

    public Object getEmail() {
        return ("");
    }

    public Object getPassword() {
        return ("");
    }
}
