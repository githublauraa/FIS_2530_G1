package bioprint.ModuloUsuarios;

import java.util.Scanner;

public class MenuUsuarios {
    public static boolean menu(UsuarioService servicio){
        boolean salir=false;
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        while(true){
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Que desea hacer?\n1.iniciar sesion\n2.registrarse");
            opcion=sc.nextInt();
            sc.nextLine();
            if(opcion<1||opcion>2){
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Por favor seleccionar entre las opciones dadas");
                continue;
            }
            break;
        }
        String nombre="";
        String contrasena="";
        if(opcion==1){
            while(true){
                System.out.println("-----------------------------------------------------------------");
                System.out.println("ingrese su usuario (o \"salir\" para volver)");
                nombre=sc.nextLine();
                if(nombre.equals("salir")){
                    return false;
                }
                System.out.println("-----------------------------------------------------------------");
                System.out.println("ingrese su contrasena (o \"salir\" para volver)");
                contrasena=sc.nextLine();
                if(contrasena.equals("salir")){
                    return false;
                }
                if(servicio.validarUsuario(nombre, contrasena)){
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("Sesion iniciada como: "+nombre);
                    return true;
                }
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Usuario o contraseña invalidos, volver a intentar");
            }
        }
        Usuario user=new Usuario();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("ingrese el nuevo usuario (o \"salir\" para volver)");
        nombre=sc.nextLine();
        if(nombre.equals("salir")){
            return false;
        }
        user.setNombre(nombre);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("ingrese la contrasena (o \"salir\" para volver)");
        contrasena=sc.nextLine();
        if(contrasena.equals("salir")){
            return false;
        }
        user.setContrasena(contrasena);
        servicio.guardar(user);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Usuario creado, iniciando Sesion");
        return true;
    }
}

