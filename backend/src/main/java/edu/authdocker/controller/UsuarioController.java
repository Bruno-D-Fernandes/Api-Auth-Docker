package edu.authdocker.controller;

import edu.authdocker.dto.usuarioDtos.CadastroUsuarioDTO;
import edu.authdocker.dto.usuarioDtos.LoginUsuarioDTO;
import edu.authdocker.dto.usuarioDtos.UpdateUsuarioDTO;
import edu.authdocker.model.Usuario;
import edu.authdocker.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrarUsuario(@RequestBody CadastroUsuarioDTO cadastroUsuarioDto) {
        usuarioService.cadastro(cadastroUsuarioDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity loginUsuario(@RequestBody LoginUsuarioDTO loginUsuarioDto) {

        String token = usuarioService.login(loginUsuarioDto);
        return ResponseEntity.ok(token);
    }

    @PutMapping("/atualizar")
    public ResponseEntity atualizarUsuario(@RequestBody UpdateUsuarioDTO updateUsuarioDto) {

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarUsuario(@PathVariable Long id) {

        return ResponseEntity.ok().build();
    }
}
