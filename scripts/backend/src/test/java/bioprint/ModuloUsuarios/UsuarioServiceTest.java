package bioprint.ModuloUsuarios;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UsuarioServiceTest {

    @Test
    void testValidarUsuarioExitoso() {
        UsuarioRepository repo = mock(UsuarioRepository.class);
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setContrasena("123");

        when(repo.findByNombreAndContrasena("Juan", "123")).thenReturn(usuario);

        UsuarioService service = new UsuarioService(repo);

        assertTrue(service.validarUsuario("Juan", "123"));
    }

    @Test
    void testValidarUsuarioFallido() {
        UsuarioRepository repo = mock(UsuarioRepository.class);
        when(repo.findByNombreAndContrasena("Juan", "123")).thenReturn(null);

        UsuarioService service = new UsuarioService(repo);

        assertFalse(service.validarUsuario("Juan", "123"));
    }
}
