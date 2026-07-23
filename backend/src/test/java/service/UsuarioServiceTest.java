package service;

import edu.authdocker.dto.usuarioDtos.CadastroUsuarioDTO;
import edu.authdocker.repository.UsuarioRepository;
import edu.authdocker.service.UsuarioService;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private CadastroUsuarioDTO cadastroUsuarioDTO;

    @BeforeEach
    void setup(){
        cadastroUsuarioDTO = new CadastroUsuarioDTO("Pedro", "Pedro@gmail.com", "pedro123");
    }

    void sucessCase1CadastroComFoto(){
        usuarioService.cadastro(cadastroUsuarioDTO);
    }



}
