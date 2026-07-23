package edu.authdocker.dto.usuarioDtos;

import org.springframework.web.multipart.MultipartFile;

public record CadastroUsuarioDTO(
        String nome,
        String email,
        String senha,
        MultipartFile foto
) {

    public CadastroUsuarioDTO(String senha, String email, String nome) {
        this(nome, email, senha, null);
    }
}
