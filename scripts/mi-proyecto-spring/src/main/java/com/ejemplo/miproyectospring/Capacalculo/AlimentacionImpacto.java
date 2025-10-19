package com.ejemplo.miproyectospring.Capacalculo;
public class AlimentacionImpacto extends CategoriaImpacto {
    @Override
    public double calcularImpacto(RespuestasFormulario r) {
        double factor;
        switch (r.getTipoDieta()) {
            case 1: factor = 1.5; break;
            case 2: factor = 2.0; break;
            case 3: factor = 3.5; break;
            case 4: factor = 5.0; break;
            default: factor = 3.0; break;
        }
        return factor * 30; // impacto mensual estimado
    }
}