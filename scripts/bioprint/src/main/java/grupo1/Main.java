package grupo1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GrupoFuentes grupo = new GrupoFuentes(); // Composite
        Sujeto sujeto = new Sujeto();             // Observable
        sujeto.addObservador(new ConsolaObservador());

        System.out.println("CALCULADORA DE HUELLA DE CARBONO");
        System.out.println("========================================");

        try {
            // Datos generales
            System.out.print("\nNúmero de personas en tu hogar: ");
            int personas = sc.nextInt();
            sc.nextLine();

            // ELECTRICIDAD
            System.out.println("\nSección 1: Electricidad");
            System.out.print("Consumo mensual de electricidad (kWh): ");
            double luz = sc.nextDouble();

            System.out.print("Consumo mensual de gas (m³): ");
            double gas = sc.nextDouble();

            System.out.print("Consumo mensual de agua (m³): ");
            double agua = sc.nextDouble();
            sc.nextLine();

            System.out.println("Fuente de energía principal:");
            System.out.println("1. Hidroeléctrica  2. Solar  3. Eólica  4. Gas/Carbón");
            int fuenteEnergia = sc.nextInt();
            sc.nextLine();

            System.out.println("¿Usas bombillos LED o ahorradores?");
            System.out.println("1. Todos  2. Algunos  3. Ninguno");
            int bombillos = sc.nextInt();
            sc.nextLine();

            System.out.println("¿Dejas aparatos enchufados cuando no los usas?");
            System.out.println("1. Nunca  2. A veces  3. Siempre");
            int aparatos = sc.nextInt();
            sc.nextLine();

            double ajusteEnergia = 1.0;
            if (fuenteEnergia == 4) ajusteEnergia += 0.2;
            if (bombillos == 3) ajusteEnergia += 0.1;
            if (aparatos == 3) ajusteEnergia += 0.1;

            double luzAjustada = luz * ajusteEnergia;
            grupo.addFuente(FuenteHuellaFactory.crearFuente(luzAjustada, gas, agua));

            // AGUA
            System.out.println("\nSección 2: Agua");
            System.out.print("Número de duchas al día (por persona): ");
            int duchas = sc.nextInt();

            System.out.print("Duración promedio de cada ducha (minutos): ");
            int duracionDucha = sc.nextInt();

            System.out.print("¿Tienes dispositivos ahorradores de agua? (1=Sí, 2=No): ");
            int ahorrador = sc.nextInt();
            sc.nextLine();

            double consumoDucha = duchas * duracionDucha * personas * (ahorrador == 1 ? 0.8 : 1.0);
            double extraAgua = consumoDucha * 0.05;
            grupo.addFuente(FuenteHuellaFactory.crearFuente(0, 0, extraAgua));

            // 🚗 TRANSPORTE
            System.out.println("\n🚗 Sección 3: Transporte");
            System.out.println("1. Carro gasolina  2. Carro diésel  3. Moto  4. Transporte público  5. Bicicleta/caminar  6. Vehículo eléctrico");
            int tipoTransporte = sc.nextInt();

            System.out.print("Distancia promedio recorrida al día (km): ");
            double km = sc.nextDouble();

            System.out.print("Número de días a la semana que usas ese medio: ");
            int dias = sc.nextInt();
            sc.nextLine();

            System.out.println("¿Viajas en avión durante el año?");
            System.out.println("1. No viajo  2. 1-2 veces  3. 3-5 veces  4. Más de 5 veces");
            int vuelos = sc.nextInt();

            EstrategiaTransporte estrategia;
            switch (tipoTransporte) {
                case 1 -> estrategia = kmDia -> kmDia * 0.21;
                case 2 -> estrategia = kmDia -> kmDia * 0.25;
                case 3 -> estrategia = kmDia -> kmDia * 0.12;
                case 4 -> estrategia = kmDia -> kmDia * 0.09;
                case 6 -> estrategia = kmDia -> kmDia * 0.03;
                default -> estrategia = kmDia -> 0.0;
            }

            Transporte transporte = new Transporte(estrategia, km * dias);
            grupo.addFuente(FuenteHuellaFactory.crearFuente(transporte));

            double huellaVuelos = switch (vuelos) {
                case 2 -> 500;
                case 3 -> 1200;
                case 4 -> 2500;
                default -> 0;
            };
            FuenteHuella vuelosFuente = () -> huellaVuelos;
            grupo.addFuente(vuelosFuente);

            // ALIMENTACIÓN
            System.out.println("\nSección 4: Alimentación");
            System.out.println("1. Vegetariana  2. Vegana  3. Omnívora  4. Alta en carne roja");
            int tipoDieta = sc.nextInt();
            sc.nextLine();

            System.out.println("Frecuencia de consumo de carne roja:");
            System.out.println("1. Nunca  2. 1–2/semana  3. 3–5/semana  4. Todos los días");
            int carne = sc.nextInt();

            System.out.println("Frecuencia de consumo de lácteos:");
            System.out.println("1. Nunca  2. 1–2/semana  3. 3–5/semana  4. Todos los días");
            int lacteos = sc.nextInt();

            System.out.println("¿Consumes productos locales o importados?");
            System.out.println("1. Locales  2. Mezclado  3. Importados");
            int origen = sc.nextInt();

            String dieta = switch (tipoDieta) {
                case 1 -> "vegetariana";
                case 2 -> "vegana";
                case 3 -> "omnivora";
                case 4 -> "alta en carne roja";
                default -> "omnivora";
            };

            grupo.addFuente(FuenteHuellaFactory.crearFuente(dieta, carne));

            //Cálculo total
            CalculadoraHuella calculadora = CalculadoraHuella.getInstance();
            double total = calculadora.calcularTotal(grupo) / personas;

            Equivalencia eq = new ArbolesAdapter();
            System.out.println("\n========================================");
            System.out.printf("🌿 Su huella total anual por persona: %.2f kgCO₂%n", total);
            System.out.println(eq.mostrar(total));

            sujeto.notificar(total);

            if (total < 2000)
                System.out.println("Excelente: tu huella es muy baja.");
            else if (total < 5000)
                System.out.println("Moderada: podrías mejorar algunos hábitos.");
            else
                System.out.println("Alta: considera reducir transporte y consumo energético.");

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Usa números cuando se soliciten valores numéricos.");
        } finally {
            sc.close();
        }
    }
}