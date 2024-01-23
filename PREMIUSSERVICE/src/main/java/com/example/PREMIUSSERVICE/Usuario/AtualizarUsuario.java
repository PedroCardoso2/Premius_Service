package com.example.PREMIUSSERVICE.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizarUsuario(
        @NotNull
        Long ID,
        @NotBlank
        String Nome,
        @NotBlank
        String Senha
) {
}
