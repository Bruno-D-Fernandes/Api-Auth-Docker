package edu.authdocker.controller;

import edu.authdocker.dto.usuarioDtos.CadastroUsuarioDTO;
import edu.authdocker.dto.usuarioDtos.LoginUsuarioDTO;
import edu.authdocker.dto.usuarioDtos.UpdateUsuarioDTO;
import edu.authdocker.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrarUsuario(@RequestBody CadastroUsuarioDTO cadastroUsuarioDto) {


        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity loginUsuario(@RequestBody LoginUsuarioDTO loginUsuarioDto) {

        return ResponseEntity.ok().build();
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
