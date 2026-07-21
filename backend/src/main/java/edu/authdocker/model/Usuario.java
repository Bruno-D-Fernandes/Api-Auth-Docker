package edu.authdocker.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario_table")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome_usuario", nullable = false, length = 75)
    private String nome;

    @Column(name = "email_usuario", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "senha_usuario", nullable = false, length = 250)
    private String senha;

    @Column(name = "url_profile_picture", nullable = true, length = 250, unique = true)
    private String urlFoto;

}
