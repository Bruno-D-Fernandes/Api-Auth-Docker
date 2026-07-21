package edu.authdocker.service;

import edu.authdocker.config.security.JwtService;
import edu.authdocker.dto.usuarioDtos.CadastroUsuarioDTO;
import edu.authdocker.dto.usuarioDtos.LoginUsuarioDTO;
import edu.authdocker.model.Usuario;
import edu.authdocker.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    // Fazer tratamento da foto
    @Transactional
    public void cadastro(CadastroUsuarioDTO cadastroUsuarioDto){
        Usuario usuario = new Usuario(cadastroUsuarioDto);

        String encodedPassword = new BCryptPasswordEncoder().encode(cadastroUsuarioDto.senha());
        usuario.setSenha(encodedPassword);

        usuarioRepository.save(usuario);
    }

    public String login(LoginUsuarioDTO loginUsuarioDto){

    }

}
