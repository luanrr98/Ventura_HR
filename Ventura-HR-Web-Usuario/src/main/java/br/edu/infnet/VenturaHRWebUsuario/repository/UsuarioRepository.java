package br.edu.infnet.VenturaHRWebUsuario.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.VenturaHRWebUsuario.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>  {

	public Usuario findByEmail(String email);

}
