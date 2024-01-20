package com.example.PREMIUSSERVICE.Usuario;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String senha;

    public Usuario (CadastrarUsuario cadastrarUsuario){
        this.name = cadastrarUsuario.name();
        this.cpf = cadastrarUsuario.cpf();
        this.senha = cadastrarUsuario.senha();
    }



}
