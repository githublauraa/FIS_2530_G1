package bioprint.ModuloCalculadora;

public class CalculadoraHuella {
    private static CalculadoraHuella instancia;

    private CalculadoraHuella() {}

    public static CalculadoraHuella getInstance() {
        if (instancia == null) instancia = new CalculadoraHuella();
        return instancia;
    }

    public double calcularTotal(FuenteHuella fuente) {
        return fuente.calcularCO2();
    }
}