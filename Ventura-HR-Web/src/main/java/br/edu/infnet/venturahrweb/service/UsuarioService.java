package br.edu.infnet.venturahrweb.service;

import br.edu.infnet.venturahrweb.model.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(url = "http://localhost:8081/usuarios", name = "usuarios")
public interface UsuarioService {


    @GetMapping("/email/{email}")
    Usuario obterPorEmail(@PathVariable String email);

    @PostMapping
    Usuario inserirUsuario(Usuario usuario);

    @PutMapping
    Usuario atualizarUsuario(Usuario usuario);
}
