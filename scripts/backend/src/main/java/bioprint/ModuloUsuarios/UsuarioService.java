package bioprint.ModuloUsuarios;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public List<Usuario> listar() {
        return repo.findAll();
    }

    public Usuario guardar(Usuario u) {
        return repo.save(u);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public boolean validarUsuario(String nombre, String contrasena) {
        Usuario usuario = repo.findByNombreAndContrasena(nombre, contrasena);
        if (usuario != null) {
            return true;
        } else {
            return false;
        }
    }
}
