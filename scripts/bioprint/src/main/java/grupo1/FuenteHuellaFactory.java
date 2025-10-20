package grupo1;

public class FuenteHuellaFactory {
    // Crear fuente por consumo energético
    public static FuenteHuella crearFuente(double luzKwh, double gasM3, double aguaM3) {
        return new FuenteHuella() {
            @Override
            public double calcularCO2() {
                // Factores de emisión aproximados
                double co2Luz = luzKwh * 0.5;
                double co2Gas = gasM3 * 2.3;
                double co2Agua = aguaM3 * 0.35;
                return co2Luz + co2Gas + co2Agua;
            }
        };
    }

    // Crear fuente por alimentación
    public static FuenteHuella crearFuente(String tipoDieta, int frecuenciaCarneRoja) {
        return new FuenteHuella() {
            @Override
            public double calcularCO2() {
                return switch (tipoDieta.toLowerCase()) {
                    case "vegana" -> 1000;
                    case "vegetariana" -> 1300;
                    case "omnivora" -> 2000 + frecuenciaCarneRoja * 20;
                    case "alta en carne roja" -> 2800 + frecuenciaCarneRoja * 50;
                    default -> 1800;
                };
            }
        };
    }

    //Crear fuente de transporte (usa estrategia ya creada)
    public static FuenteHuella crearFuente(Transporte transporte) {
        return transporte; // El transporte ya implementa FuenteHuella  
    }
}