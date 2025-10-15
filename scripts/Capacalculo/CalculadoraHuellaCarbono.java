package Capacalculo;
// patron singleton
public class CalculadoraHuellaCarbono {
    private static CalculadoraHuellaCarbono instance;

    private CalculadoraHuellaCarbono() {}

    public static CalculadoraHuellaCarbono getInstance() {
        if (instance == null) {
            instance = new CalculadoraHuellaCarbono();
        }
        return instance;
    }

    // Método general para calcular huella total
    public double calcularHuellaTotal(RespuestasFormulario respuestas) {
        double total = 0;

        CategoriaCreacion factory = new CategoriaCreacion();

        total += factory.crearCategoria("electricidad").calcularImpacto(respuestas);
        total += factory.crearCategoria("agua").calcularImpacto(respuestas);
        total += factory.crearCategoria("transporte").calcularImpacto(respuestas);
        total += factory.crearCategoria("alimentacion").calcularImpacto(respuestas);

        return total;
    }
}


