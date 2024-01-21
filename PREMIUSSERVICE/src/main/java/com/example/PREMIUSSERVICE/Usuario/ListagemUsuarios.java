package com.example.PREMIUSSERVICE.Usuario;

public record ListagemUsuarios(Long ID, String Nome, String CPF, String Senha){
    public ListagemUsuarios(Usuarios usr){
        this(usr.getID(), usr.getNome(), usr.getCPF(), usr.getSenha());
    }

}
