package com.example.PREMIUSSERVICE.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuarios {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String Nome;
    private String CPF;
    private String Senha;

    public Usuarios(CadastrarUsuarios cadastrarUsuario){
        this.Nome = cadastrarUsuario.Nome();
        this.CPF = cadastrarUsuario.CPF();
        this.Senha = cadastrarUsuario.Senha();
    }

    public void AtualizacaoUsuario(AtualizarUsuario dados){
        if(dados.Nome() != null){this.Nome = dados.Nome();}
        if(dados.Senha() != null){this.Senha = dados.Senha();}
    }


}
