package com.ejemplo.miproyectospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ejemplo.miproyectospring.Capacalculo.*;

@SpringBootApplication
public class MiProyectoSpringApplication {

    public static void main(String[] args) {
        // Ejecutar Spring Boot
        SpringApplication.run(MiProyectoSpringApplication.class, args);
        
        RespuestasFormulario respuestas= new RespuestasFormulario();

        FormularioHuella formulario = new FormularioHuella(CalculadoraHuellaCarbono.getInstance());

        double puntaje=formulario.iniciarFormulario(respuestas);
        System.out.print("tu puntaje fue de " + puntaje);
    }
}
