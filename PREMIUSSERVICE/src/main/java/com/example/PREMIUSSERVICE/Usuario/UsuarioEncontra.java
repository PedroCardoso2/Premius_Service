package com.example.PREMIUSSERVICE.Usuario;

public record UsuarioEncontra(Long id, String senha, String cpf, String nome) {
    public UsuarioEncontra(Usuarios usr){
        this(usr.getID(), usr.getNome(), usr.getCPF(), usr.getSenha());
    }
}
