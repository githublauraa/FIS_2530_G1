package bioprint.ModuloUsuarios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repo;

    @InjectMocks
    private UsuarioService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarDevuelveTodosLosUsuarios() {
        List<Usuario> listaMock = Arrays.asList(
                new Usuario("juan", "1234"),
                new Usuario("ana", "abcd")
        );

        when(repo.findAll()).thenReturn(listaMock);

        List<Usuario> resultado = service.listar();

        assertEquals(2, resultado.size());
        verify(repo, times(1)).findAll();
    }

    @Test
    void testGuardarGuardaYDevuelveUsuario() {
        Usuario u = new Usuario("carlos", "pass");
        when(repo.save(u)).thenReturn(u);

        Usuario resultado = service.guardar(u);

        assertEquals(u, resultado);
        verify(repo, times(1)).save(u);
    }

    @Test
    void testValidarUsuarioValido() {
        String nombre = "pepe";
        String contrasena = "123";
        Usuario mockUsuario = new Usuario(nombre, contrasena);

        when(repo.findByNombreAndContrasena(nombre, contrasena))
                .thenReturn(mockUsuario);

        boolean valido = service.validarUsuario(nombre, contrasena);

        assertTrue(valido);
        verify(repo).findByNombreAndContrasena(nombre, contrasena);
    }

    @Test
    void testValidarUsuarioInvalido() {
        String nombre = "pepe";
        String contrasena = "123";

        when(repo.findByNombreAndContrasena(nombre, contrasena))
                .thenReturn(null);

        boolean valido = service.validarUsuario(nombre, contrasena);

        assertFalse(valido);
        verify(repo).findByNombreAndContrasena(nombre, contrasena);
    }
}
