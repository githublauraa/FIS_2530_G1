package bioprint.metricas;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.stmt.Statement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 * Analizador de calidad del código fuente.
 * Calcula la Complejidad Ciclomática y el Índice de Mantenibilidad
 * de todas las clases en el paquete bioprint.
 *
 * Los resultados incluyen una interpretación cualitativa
 * para facilitar su comprensión.
 */
public class AnalizadorCalidad {

    public static int calcularComplejidadCiclomatica(File archivo) throws IOException {
        ParserConfiguration config = new ParserConfiguration()
                .setLanguageLevel(ParserConfiguration.LanguageLevel.JAVA_17);
        JavaParser parser = new JavaParser(config);

        var parseResult = parser.parse(archivo);
        if (!parseResult.isSuccessful() || parseResult.getResult().isEmpty()) {
            throw new IOException("No se pudo analizar el archivo " + archivo.getName());
        }

        CompilationUnit cu = parseResult.getResult().get();
        int complejidad = 1;

        List<Statement> statements = cu.findAll(Statement.class);
        for (Statement stmt : statements) {
            String tipo = stmt.getClass().getSimpleName();
            if (tipo.contains("If") || tipo.contains("For") || tipo.contains("While")
                    || tipo.contains("Switch") || tipo.contains("Catch")
                    || tipo.contains("ConditionalExpr")) {
                complejidad++;
            }
        }

        return complejidad;
    }

    public static double calcularMantenibilidad(File archivo, int complejidad) throws IOException {
        List<String> lineas = Files.readAllLines(archivo.toPath());
        long lineasTotales = lineas.size();
        long lineasComentadas = lineas.stream()
                .filter(l -> l.trim().startsWith("//") || l.trim().startsWith("/*"))
                .count();

        double ratioComentarios = (double) lineasComentadas / lineasTotales;
        return 171 - 5.2 * Math.log(complejidad + 1)
                - 0.23 * lineasTotales
                + 16.2 * (ratioComentarios * 100);
    }

    /**
     * Devuelve una interpretación textual de la complejidad ciclomática.
     */
    public static String interpretarComplejidad(int complejidad) {
        if (complejidad <= 5)
            return "Baja (código simple y fácil de mantener)";
        else if (complejidad <= 10)
            return "Moderada (estructura con cierta lógica condicional)";
        else if (complejidad <= 20)
            return "Alta (puede requerir pruebas y mantenimiento cuidadoso)";
        else
            return "Muy alta (difícil de entender y propensa a errores)";
    }

    /**
     * Devuelve una interpretación textual del índice de mantenibilidad.
     */
    public static String interpretarMantenibilidad(double indice) {
        if (indice >= 200)
            return "Excelente (muy fácil de mantener)";
        else if (indice >= 150)
            return "Buena (fácil de mantener con pocas mejoras)";
        else if (indice >= 100)
            return "Aceptable (puede mejorarse la legibilidad o comentarios)";
        else
            return "Deficiente (recomendado refactorizar el código)";
    }

    public static void main(String[] args) throws IOException {
        File carpeta = new File("src/main/java/bioprint");
        if (!carpeta.exists()) {
            System.out.println(" No se encontró el directorio: " + carpeta.getAbsolutePath());
            return;
        }

        System.out.println("\n==========  ANÁLISIS DE CALIDAD DEL CÓDIGO  ==========\n");

        Files.walk(carpeta.toPath())
                .filter(p -> p.toString().endsWith(".java"))
                .forEach(path -> {
                    try {
                        File archivo = path.toFile();
                        int complejidad = calcularComplejidadCiclomatica(archivo);
                        double mantenibilidad = calcularMantenibilidad(archivo, complejidad);

                        System.out.println(" Archivo analizado: " + archivo.getName());
                        System.out.println("    Complejidad ciclomática: " + complejidad +
                                "  " + interpretarComplejidad(complejidad));
                        System.out.printf("    Índice de mantenibilidad: %.2f  %s%n",
                                mantenibilidad, interpretarMantenibilidad(mantenibilidad));
                        System.out.println("------------------------------------------------------");

                    } catch (Exception e) {
                        System.out.println("[] No se pudo analizar " + path.getFileName() + ": " + e.getMessage());
                    }
                });

        System.out.println("\n=======================================================");
        System.out.println(" Interpretación general:");
        System.out.println(" - La COMPLEJIDAD CICLOMÁTICA mide la cantidad de caminos lógicos posibles en el código.");
        System.out.println("   Cuanto menor sea el valor, más sencillo y fácil de probar es el programa.");
        System.out.println(" - El ÍNDICE DE MANTENIBILIDAD estima qué tan fácil es comprender, modificar y extender el código.");
        System.out.println("   Valores altos indican mejor calidad estructural y legibilidad.\n");
    }
}
