package com.example.PREMIUSSERVICE.Usuario;

public record ListagemUsuario (Long id, String name, String cpf, String senha){
    public ListagemUsuario(Usuario usr){
        this(usr.getId(), usr.getName(), usr.getCpf(), usr.getSenha());
    }

}
