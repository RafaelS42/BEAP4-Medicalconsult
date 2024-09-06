package br.com.rafaelsouza.medicalconsult.usuario.services;

import br.com.rafaelsouza.medicalconsult.usuario.domain.Usuario;
import br.com.rafaelsouza.medicalconsult.usuario.repositories.UsuarioRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }


    public List<Usuario> listarUsuario(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarusuario(Long id){
        return usuarioRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Usuario não encontrado", id));
    }

    public void excluir(Long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario atualizar(Usuario usuario){
        if(usuario.getIdUsuario()==null){
            throw new RuntimeException("Usuario sem id");
        }
        return usuarioRepository.save(usuario);
    }
}
