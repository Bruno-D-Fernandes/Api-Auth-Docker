package edu.authdocker.service;

import edu.authdocker.config.security.JwtService;
import edu.authdocker.dto.usuarioDtos.CadastroUsuarioDTO;
import edu.authdocker.dto.usuarioDtos.LoginUsuarioDTO;
import edu.authdocker.model.Usuario;
import edu.authdocker.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    @Value("${images.dataPath}")
    private String imagesSource;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    // Fazer tratamento da foto
    @Transactional
    public void cadastro(CadastroUsuarioDTO cadastroUsuarioDto){

        // talvez jogar esse tratamento de imagem para um método privado, por enquanto não funcional
        if(!cadastroUsuarioDto.foto().isEmpty()){
            MultipartFile multipartFile = cadastroUsuarioDto.foto();
            Path path = Paths.get(imagesSource).getRoot();

            System.out.println(path);
        }

        Usuario usuario = new Usuario(cadastroUsuarioDto);


        String encodedPassword = new BCryptPasswordEncoder().encode(cadastroUsuarioDto.senha());
        usuario.setSenha(encodedPassword);

        usuarioRepository.save(usuario);
    }

    public String login(LoginUsuarioDTO loginUsuarioDto){
        Authentication authentication = new UsernamePasswordAuthenticationToken(loginUsuarioDto.email(), loginUsuarioDto.senha(), null);

        authenticationManager.authenticate(authentication);
        return jwtService.generateToken(loginUsuarioDto.email());
    }

}
