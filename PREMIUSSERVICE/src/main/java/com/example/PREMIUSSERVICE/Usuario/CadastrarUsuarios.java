package com.example.premiusservice.Usuario;

import jakarta.validation.constraints.NotBlank;

public record CadastrarUsuarios(
        @NotBlank
        String Nome,

        @NotBlank
        String CPF,

        @NotBlank
        String Senha

) {



}
