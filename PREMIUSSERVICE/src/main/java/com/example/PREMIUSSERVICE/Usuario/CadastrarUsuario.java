package com.example.PREMIUSSERVICE.Usuario;

import jakarta.validation.constraints.NotBlank;

public record CadastrarUsuario(
        @NotBlank
        String name,

        @NotBlank
        String cpf,

        @NotBlank
        String senha

) {



}
