package br.edu.infnet.VenturaHRWebUsuario.controller;

import br.edu.infnet.VenturaHRWebUsuario.model.Usuario;
import br.edu.infnet.VenturaHRWebUsuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/{id}")
    public ResponseEntity obterPorId(@PathVariable int id) {
        ResponseEntity retorno = ResponseEntity.notFound().build();
        Usuario usuario = this.findById(id);
        if (usuario != null) {
            retorno = ResponseEntity.ok().body(usuario);
        }

        return retorno;

    }

    @GetMapping
    public Iterable<Usuario> buscarTodos(){
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    private Usuario findById(int id) {
        Usuario retorno = null;
        try {
            retorno = usuarioRepository.findById(id).get();
        } catch (Exception e) {

        }
        return retorno;
    }

    @GetMapping("/email/{email}")
    public ResponseEntity obterPorEmail(@PathVariable String email) {
        ResponseEntity retorno = ResponseEntity.notFound().build();
        try {
            Usuario usuario = usuarioRepository.findByEmail(email);
            if (usuario != null) {
                retorno = ResponseEntity.ok().body(usuario);
            }
        } catch (Exception e) {
        }
        return retorno;
    }

    @PostMapping
    ResponseEntity inserirUsuario(@RequestBody Usuario usuario) {
        ResponseEntity retorno = ResponseEntity.badRequest().build();
        if (usuario != null && usuario.getId() == null) {
            Usuario usuarioInserido = usuarioRepository.save(usuario);
            retorno = ResponseEntity.ok().body(usuarioInserido);
        }
        return retorno;
    }

    @PutMapping
    public ResponseEntity atualizarUsuario(@RequestBody Usuario usuario) {
        ResponseEntity retorno = ResponseEntity.badRequest().build();
        if (usuario != null && usuario.getId() != null) {
            Usuario usuarioAtualizado = this.findById(usuario.getId());
            if (usuarioAtualizado != null) {
                try {
                    usuarioAtualizado = usuarioRepository.save(usuario);
                    retorno = ResponseEntity.ok().body(usuarioAtualizado);
                } catch (Exception e) {
                }
            }
        }
        if (usuario != null && usuario.getId() == null) {
            Usuario usuarioInserido = usuarioRepository.save(usuario);
            retorno = ResponseEntity.ok().body(usuarioInserido);
        }

            return retorno;
    }
}

