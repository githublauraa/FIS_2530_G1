package bioprint.ModuloCalculadora;

public class EstrategiaCarro implements EstrategiaTransporte {
    @Override
    public double calcularCO2(double km) { return km * 0.21; }
}