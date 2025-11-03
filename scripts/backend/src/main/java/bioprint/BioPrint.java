package bioprint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import bioprint.ModuloUsuarios.Usuario;
import bioprint.ModuloUsuarios.UsuarioService;

@SpringBootApplication
public class BioPrint {
    public static void main(String[] args) {
        // Inicializar Spring Boot y obtener el contexto
        ApplicationContext context = SpringApplication.run(BioPrint.class, args);

        // Obtener el bean UsuarioService
        UsuarioService usuarioService = context.getBean(UsuarioService.class);

        // Crear un usuario
        Usuario usuario = new Usuario();
        usuario.setNombre("Prueba Java");
        usuario.setEmail(":(pipipi@ayuda.com");
        Usuario creado = usuarioService.guardar(usuario);
        System.out.println("Usuario creado: " + creado.getNombre() + " ID: " + creado.getId());
        /* 
        // Eliminar un usuario por ID
        usuarioService.eliminar(creado.getId());
        System.out.println("Usuario eliminado con ID: " + creado.getId());
        */
    }
}

