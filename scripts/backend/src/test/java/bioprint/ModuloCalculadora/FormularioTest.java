package bioprint.ModuloCalculadora;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FormularioTest {

    // --- TESTS PARA int ---
    @Test
    void testEnteroDentroDelRango() {
        assertTrue(Formulario.validar(5, 10, 1, false));
    }

    @Test
    void testEnteroFueraDelRangoSinOpciones() {
        assertFalse(Formulario.validar(15, 10, 1, false));
    }

    @Test
    void testEnteroFueraDelRangoConOpciones() {
        assertFalse(Formulario.validar(0, 10, 1, true));
    }

    @Test
    void testEnteroIgualAlMinimo() {
        assertTrue(Formulario.validar(1, 10, 1, false));
    }

    @Test
    void testEnteroIgualAlMaximo() {
        assertTrue(Formulario.validar(10, 10, 1, false));
    }

    // --- TESTS PARA double ---
    @Test
    void testDoubleDentroDelRango() {
        assertTrue(Formulario.validar(5.5, 10.0, 1.0, false));
    }

    @Test
    void testDoubleFueraDelRangoSinOpciones() {
        assertFalse(Formulario.validar(11.0, 10.0, 1.0, false));
    }

    @Test
    void testDoubleFueraDelRangoConOpciones() {
        assertFalse(Formulario.validar(-2.0, 10.0, 1.0, true));
    }

    @Test
    void testDoubleIgualAlMinimo() {
        assertTrue(Formulario.validar(1.0, 10.0, 1.0, false));
    }

    @Test
    void testDoubleIgualAlMaximo() {
        assertTrue(Formulario.validar(10.0, 10.0, 1.0, false));
    }
}
