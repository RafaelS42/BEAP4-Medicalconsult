package br.com.rafaelsouza.medicalconsult.usuario.resources;

import br.com.rafaelsouza.medicalconsult.usuario.domain.Usuario;
import br.com.rafaelsouza.medicalconsult.usuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//controladora
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResouce {


    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
        Usuario novoUsuario = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuarios = usuarioService.listarUsuario();
        return ResponseEntity.ok().body(usuarios);
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Usuario> buscarUsuario(Long id){
        Usuario usuario = usuarioService.buscarusuario(id);
        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping(value = "/{id}")
    public void excluirPorId(@PathVariable Long id){
        usuarioService.excluir(id);
    }

    @PutMapping
    public Usuario atualizar(@RequestBody Usuario usuario){
        return usuarioService.atualizar(usuario);
    }
}
