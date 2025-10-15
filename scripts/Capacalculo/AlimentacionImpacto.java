package Capacalculo;
public class AlimentacionImpacto extends CategoriaImpacto {
    @Override
    public double calcularImpacto(RespuestasFormulario r) {
        double factor;
        switch (r.getTipoDieta()) {
            case "Vegana": factor = 1.5; break;
            case "Vegetariana": factor = 2.0; break;
            case "Omnívora": factor = 3.5; break;
            case "Alta en carne roja": factor = 5.0; break;
            default: factor = 3.0; break;
        }
        return factor * 30; // impacto mensual estimado
    }
}