package com.example.PREMIUSSERVICE.Usuario;

public record UsuarioEncontra(Long ID, String Senha, String CPF, String Nome) {
    public UsuarioEncontra(Usuarios usr){
        this(usr.getID(), usr.getNome(), usr.getCPF(), usr.getSenha());
    }
}
