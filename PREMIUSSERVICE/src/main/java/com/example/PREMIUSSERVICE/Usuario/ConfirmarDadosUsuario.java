package com.example.premiusservice.Usuario;

import jakarta.validation.constraints.NotBlank;

public record ConfirmarDadosUsuario(
        @NotBlank
        String Nome,


        String CPF,


        String Senha
){

    public ConfirmarDadosUsuario(Usuarios usr){
        this(usr.getNome(), usr.getCPF(), usr.getSenha());
    }
}
