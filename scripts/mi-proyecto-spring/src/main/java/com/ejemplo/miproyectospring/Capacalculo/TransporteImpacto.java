package com.ejemplo.miproyectospring.Capacalculo;
public class TransporteImpacto extends CategoriaImpacto {
    @Override
    public double calcularImpacto(RespuestasFormulario r) {
        double factor;
        switch (r.getTipoTransporte()) {
            case 1: factor = 0.21; break;
            case 2: factor = 0.25; break;
            case 3: factor = 0.10; break;
            case 4: factor = 0.08; break;
            case 5: factor = 0.05; break;
            default: factor = 0.0; break;
        }
        return r.getDistanciaDiaria() * r.getDiasPorSemana() * factor * 4.345; // promedio mensual
    }
}