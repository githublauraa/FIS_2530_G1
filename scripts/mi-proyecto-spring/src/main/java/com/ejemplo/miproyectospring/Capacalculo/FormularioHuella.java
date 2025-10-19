package com.ejemplo.miproyectospring.Capacalculo;

import java.util.Scanner;

import com.ejemplo.miproyectospring.Sujeto;

public class FormularioHuella extends Sujeto {
    private Scanner sc = new Scanner(System.in);

	private CalculadoraHuellaCarbono calculadora; 

    public FormularioHuella(CalculadoraHuellaCarbono calculadora) {
        this.calculadora = calculadora;
    }

    public double iniciarFormulario(RespuestasFormulario respuestas) {
        
        int auxiliarInt=0;
        double auxiliarDouble=0;
        System.out.println("===  CALCULADORA DE HUELLA DE CARBONO ===");
        System.out.println("Responde con honestidad para obtener recomendaciones en tiempo real.\n");

        try {
            //  ELECTRICIDAD
            while(true){
                System.out.println("\n 1. ELECTRICIDAD");
                System.out.print("Consumo mensual de electricidad (kWh): ");
                auxiliarDouble=sc.nextDouble();
                sc.nextLine();
                if(auxiliarDouble<0){
                    System.out.println("El numero ingresado no puede ser menor que 0");
                    continue;
                }
                break;
            }
            respuestas.setConsumoElectricidad(auxiliarDouble);
            //  AGUA
            while(true){
                System.out.println("\n 2. AGUA");
                System.out.print("Consumo mensual de agua (m³): ");
                auxiliarDouble=sc.nextDouble();
                sc.nextLine();if(auxiliarDouble<0){
                    System.out.println("El numero ingresado no puede ser menor que 0");
                    continue;
                }
                break;
            }
            respuestas.setConsumoAgua(auxiliarDouble);
            //TIPO DE TRANSPORTE
            while(true){
                System.out.println("\n 3. TRANSPORTE");
                System.out.println("Tipo de transporte principal:");
                System.out.println("1. Vehículo propio (gasolina)\n2. Vehículo propio (diésel)\n3. Motocicleta\n4. Transporte público\n5. Bicicleta / caminata\n6. Vehículo eléctrico");
                auxiliarInt=sc.nextInt();
                sc.nextLine();
                if(auxiliarInt>6||auxiliarInt<1){
                    System.out.println("La respuesta no se encuentra entre las opciones dadas");
                    continue;
                }
                break;
            }
            respuestas.setTipoTransporte(auxiliarInt);
            //DISTANCIA DE TRANSPORTE
            while(true){
                System.out.print("Distancia promedio recorrida al día (km): ");
                auxiliarDouble=sc.nextDouble();
                sc.nextLine();
                if(auxiliarDouble<0){
                    System.out.println("El numero ingresado no puede ser menor que 0");
                    continue;
                }
                break;
            }
            respuestas.setDistanciaDiaria(auxiliarDouble);
            //DIAS A LA SEMANA
            while(true){
                System.out.println("Número de días a la semana que usas ese medio: ");
                auxiliarInt=sc.nextInt();
                sc.nextLine();
                if(auxiliarInt<0||auxiliarInt>7){
                    System.out.println("El numero ingresado no puede ser menor que 0 o mayor que 7");
                    continue;
                }
                break;
            }
            respuestas.setDiasPorSemana(auxiliarInt);
            //  ALIMENTACIÓN
            while(true){
                System.out.println("\n 4. ALIMENTACIÓN");
                System.out.println("Tipo de dieta principal:");
                System.out.println("1. Vegetariana\n2. Vegana\n3. Omnívora\n4. Alta en carne roja");
                auxiliarInt=sc.nextInt();
                sc.nextLine();
                if(auxiliarInt>4||auxiliarInt<1){
                    System.out.println("La respuesta no se encuentra entre las opciones dadas");
                    continue;
                }
                break;
            }
            respuestas.setTipoDieta(auxiliarInt);
        } catch (Exception e) {
            System.out.println(" Error en la entrada. Intenta nuevamente.");
        }
        return calculadora.calcularHuellaTotal(respuestas);
    }
}
