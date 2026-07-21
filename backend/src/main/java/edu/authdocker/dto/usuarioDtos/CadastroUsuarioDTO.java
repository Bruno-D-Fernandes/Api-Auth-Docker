package edu.authdocker.dto.usuarioDtos;

public record CadastroUsuarioDTO(
        String nome,
        String email,
        String senha,
        String urlFoto
) {
}
