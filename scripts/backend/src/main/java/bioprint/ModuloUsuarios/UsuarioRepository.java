package bioprint.ModuloUsuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByNombreAndContrasena(String nombre, String contrasena);
    Usuario findByNombre(String nombre);
}
