package co.edu.uniquindio;

import junit.framework.TestCase;

/**
 * Test FragmentoTest
 *
 * Pruebas unitarias de la clase Fragmento
 *
 * @author Yesid Shair Rosas Toro
 * @author Juan David Usma Alzate
 * @author Samara Smith Rincon Montaña
 */
public class FragmentoTest extends TestCase {
    /**
     * Test CompletarDigitos1
     *
     * Prueba Unitaria del Metodo completarDigitos
     * de la clase Fragmento
     *
     * Verifica que la longitud de la cadena de
     * salida sea la esperada
     */
    public void testCompletarDigitos1() {
        int input = 10;
        String output = Fragmento.completarDigitos("123", input);
        int size = output.length();
        assertEquals(input, size);
    }

    /**
     * Test CompletarDigitos2
     *
     * Prueba Unitaria del Metodo completarDigitos
     * de la clase Fragmento
     *
     * Verifica que la cadena de
     * salida sea la esperada
     */
    public void testCompletarDigitos2() {
        String input = "1010";
        String output = Fragmento.completarDigitos(input, 8);
        assertEquals("00001010", output);
    }
}