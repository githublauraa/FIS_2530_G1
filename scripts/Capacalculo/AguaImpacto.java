package Capacalculo;
public class AguaImpacto extends CategoriaImpacto {
    @Override
    public double calcularImpacto(RespuestasFormulario r) {
        double factor = 0.344; // kg CO2/m³ aproximado
        return r.getConsumoAgua() * factor;
    }
}