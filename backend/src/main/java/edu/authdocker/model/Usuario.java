package edu.authdocker.model;

import edu.authdocker.dto.usuarioDtos.CadastroUsuarioDTO;
import jakarta.persistence.*;
import lombok.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario_table")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome_usuario", nullable = false, length = 75)
    private String nome;

    @Column(name = "email_usuario", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "password_usuario", nullable = false, length = 250)
    private String senha;

    @Column(name = "url_profile_picture", nullable = true, length = 250, unique = true)
    private String urlFoto;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    public Usuario(CadastroUsuarioDTO cadastroUsuarioDTO) {
        this.nome = cadastroUsuarioDTO.nome();
        this.email = cadastroUsuarioDTO.email();
        this.senha = cadastroUsuarioDTO.senha();
        this.urlFoto = cadastroUsuarioDTO.urlFoto();
    }
}
