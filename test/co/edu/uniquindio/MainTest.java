package co.edu.uniquindio;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Test MainTest
 *
 * Pruebas unitarias de la clase Main
 *
 * @author Yesid Shair Rosas Toro
 * @author Juan David Usma Alzate
 * @author Samara Smith Rincon Montaña
 */
public class MainTest extends TestCase {
    /**
     * Test GestionarFragmentos1
     *
     * Prueba Unitaria del Metodo gestionarFragmento
     * de la clase Main
     *
     * Verifica que la longitud de elementos de
     * la salida sea la esperada
     */
    public void testGestionarFragmentos1() {
        int data = 1500;
        int mtu = 500;
        ArrayList<Fragmento> salida = Main.obtenerFragmentos(data, mtu);

        int expected = 4;
        assertEquals(expected, salida.size());
    }

    /**
     * Test GestionarFragmentos2
     *
     * Prueba Unitaria del Metodo gestionarFragmento
     * de la clase Main
     *
     * Verifica que los fragmentos sean diferentes
     */
    public void testGestionarFragmentos2() {
        int data = 1500;
        int mtu = 500;
        ArrayList<Fragmento> salida = Main.obtenerFragmentos(data, mtu);

        assertNotSame(salida.get(0), salida.get(1));
    }
}