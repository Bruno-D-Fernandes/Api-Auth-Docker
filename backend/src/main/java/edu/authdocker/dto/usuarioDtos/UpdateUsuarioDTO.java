package edu.authdocker.dto.usuarioDtos;

public record UpdateUsuarioDTO(
        String nome,
        String email,
        String senha,
        String urlFoto
) {
}
