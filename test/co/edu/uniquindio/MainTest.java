package co.edu.uniquindio;

import junit.framework.TestCase;

public class MainTest extends TestCase {

    public void testCompletarDigitos1() {
        int input = 10;
        String output = Main.completarDigitos("123", input);
        int size = output.length();
        assertEquals(input, size);
    }

    public void testCompletarDigitos2() {
        String input = "1010";
        String output = Main.completarDigitos(input, 8);
        assertEquals("00001010", output);
    }

    public void testGestionarFragmentos() {

    }
}