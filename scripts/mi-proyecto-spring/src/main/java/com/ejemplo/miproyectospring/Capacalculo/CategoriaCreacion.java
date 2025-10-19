package com.ejemplo.miproyectospring.Capacalculo;
// Capa de calculo central
public class CategoriaCreacion {
    public CategoriaImpacto crearCategoria(String tipo) {
        switch (tipo.toLowerCase()) {
            case "electricidad":
                return new ElectricidadImpacto();
            case "agua":
                return new AguaImpacto();
            case "transporte":
                return new TransporteImpacto();
            case "alimentacion":
                return new AlimentacionImpacto();
            default:
                throw new IllegalArgumentException("Categoría no válida: " + tipo);
        }
    }
}