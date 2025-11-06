package bioprint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import bioprint.ModuloUsuarios.*;
import bioprint.ModuloCalculadora.*;

@SpringBootApplication
public class BioPrint {
    public static void main(String[] args) {
        // Inicializar Spring Boot y obtener el contexto
        ApplicationContext context = SpringApplication.run(BioPrint.class, args);
        Notificador bot = new Notificador();
        // Obtener el bean UsuarioService
        UsuarioService servicio = context.getBean(UsuarioService.class);
        PuntajeService puntajeService = context.getBean(PuntajeService.class);

        boolean[] salirApp={false};
        String[] nombre={""};
        while(!salirApp[0]){
            while(!MenuUsuarios.menu(servicio, salirApp, bot, nombre));
            if(!salirApp[0]){
                double total=Formulario.formulario();
                puntajeService.registrarPuntaje(nombre[0], total);
            }
        }
        SpringApplication.exit(context, () -> 0);
        /* 
        // Crear un usuario
        Usuario usuario = new Usuario();
        usuario.setNombre("Prueba Java");
        usuario.setEmail(":(pipipi@ayuda.com");
        Usuario creado = usuarioService.guardar(usuario);
        System.out.println("Usuario creado: " + creado.getNombre() + " ID: " + creado.getId());
        
        // Eliminar un usuario por ID
        usuarioService.eliminar(creado.getId());
        System.out.println("Usuario eliminado con ID: " + creado.getId());
        */
        
    }
}