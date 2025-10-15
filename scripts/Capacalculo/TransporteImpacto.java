package Capacalculo;
public class TransporteImpacto extends CategoriaImpacto {
    @Override
    public double calcularImpacto(RespuestasFormulario r) {
        double factor;
        switch (r.getTipoTransporte()) {
            case "Vehículo propio (gasolina)": factor = 0.21; break;
            case "Vehículo propio (diésel)": factor = 0.25; break;
            case "Motocicleta": factor = 0.10; break;
            case "Transporte público": factor = 0.08; break;
            case "Vehículo eléctrico": factor = 0.05; break;
            default: factor = 0.0; break;
        }
        return r.getDistanciaDiaria() * r.getDiasPorSemana() * factor * 4.345; // promedio mensual
    }
}