package co.edu.uniquindio;

import java.util.Scanner;

/**
 * Proyecto 1 de redes 2
 * Transferencia de Archivos
 *
 * @author Yesid Shair Rosas Toro
 * @author Juan David Usma Alzate
 * @author Samara Smith Rincon Montaña
 */
public class Main {
    /**
     * Metodo Completar Digitos
     *
     * Completa con 0s los digitos de un numero
     *
     * @param num El numero que se va a completar
     * @param tam El tamaño que deberia tener la cadena de digitos
     * @return String : El numero num con la cantidad de digitos tam
     */
    public static String completarDigitos(String num, int tam) {
        StringBuilder binBuilder = new StringBuilder(num);
        while (binBuilder.length() < tam) {
            binBuilder.insert(0, "0");
        }
        num = binBuilder.toString();
        return num;
    }

    /**
     * Metodo Gestionar Fragmentos
     *
     * Genera los flags, el offset en binario y decimal y la conversion
     * hexadecimal de los 16 bits y los retorna en una cadena.
     *
     * @param data Longitud del datagrama
     * @param mtu  Longitud del MTU de la red
     * @return String : La salida procesada
     */
    public static String gestionarFragmentos(int data, int mtu) {
        int offset = 0;
        int n = data > mtu ? data / mtu + 1 : 1;

        StringBuilder salida = new StringBuilder();
        salida.append("Cantidad de Fragmentos: ").append(n).append("\n\n");

        for (int i = 0; i < n; i++) {
            String flag = i < n - 1 ? "001" : "000";

            int longitud = i < n - 1 ? mtu - 20 : data - offset;
            Fragmento fragmento = new Fragmento(i+1, longitud, flag, offset);
            salida.append(fragmento.toString());

            offset += (mtu - 20);
        }

        return salida.toString();
    }

    /**
     * Metodo Main
     *
     * Metodo principal donde se ejecuta el codigo
     */
    public static void main(String[] args) {
        int tamDatagrama, mtu;
        tamDatagrama = leerEntero("Longitud total del datagrama");
        mtu = leerEntero("Longitud del MTU de la red");

        imprimir("\n" + gestionarFragmentos(tamDatagrama, mtu));
        imprimir("------------------------------------\n\n");
    }

    /**
     * Metodo Imprimir
     *
     * Imprime un texto
     * Sirve como alias de System.out.print();
     *
     * @param texto Texto a imprimir
     */
    private static void imprimir(String texto) {
        System.out.print(texto);
    }

    /**
     * Metodo Leer Entero
     *
     * Muestra una pregunta en pantalla y lee un numero entero valido
     *
     * @param pregunta El mensaje que se va a mostrar en pantalla
     * @return int : Entero leido
     */
    private static int leerEntero(String pregunta) {
        Scanner scanner = new Scanner(System.in);
        try {
            imprimir(pregunta + ": ");
            String entrada = scanner.nextLine();
            return Integer.parseInt(entrada);
        } catch (Exception ex) {
            imprimir("Error: Ingrese un numero valido\n\n");
            return leerEntero(pregunta);
        }
    }
}
