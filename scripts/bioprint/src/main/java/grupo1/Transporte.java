package grupo1;

public class Transporte implements FuenteHuella {
    private EstrategiaTransporte estrategia;
    private double km;

    public Transporte(EstrategiaTransporte estrategia, double km) {
        this.estrategia = estrategia;
        this.km = km;
    }

    @Override
    public double calcularCO2() {
        return estrategia.calcularCO2(km);
    }
}