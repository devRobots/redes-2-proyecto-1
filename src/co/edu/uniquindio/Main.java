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
     * <p>
     * Completa con 0s los digitos de un numero
     *
     * @param num El numero que se va a completar
     * @param tam El tamaño que deberia tener la cadena de digitos
     * @return String : El numero num con la cantidad de digitos tam
     */
    private static String completarDigitos(String num, int tam) {
        StringBuilder binBuilder = new StringBuilder(num);
        while (binBuilder.length() < tam) {
            binBuilder.insert(0, "0");
        }
        num = binBuilder.toString();
        return num;
    }

    /**
     * Metodo Gestionar Fragmentos
     * <p>
     * Genera los flags, el offset en binario y decimal y la conversion
     * hexadecimal de los 16 bits y los retorna en una cadena.
     *
     * @param data Longitud del datagrama
     * @param mtu  Longitud del MTU de la red
     * @param n    Cantidad de fragmentos resultantes
     * @return String : La salida procesada
     */
    private static String gestionarFragmentos(int data, int mtu, int n) {
        StringBuilder salida = new StringBuilder();
        int offset = 0;

        for (int i = 0; i < n; i++) {
            String flag = i < n - 1 ? "001" : "000";
            String ob = completarDigitos(Integer.toBinaryString(offset), 13);
            String hex = completarDigitos(Integer.toHexString(Integer.parseInt(flag + ob, 2)), 4);

            String text = "Fragmento " + (i + 1) + "\n";
            text += "Longitud total del fragmento: " + (i < n - 1 ? mtu - 20 : data - offset) + "\n";
            text += "Flags: " + flag + "\n";
            text += "Offset Bin: 0b" + ob + "\n";
            text += "Offset Dec: " + offset + "\n";
            text += "4 digitos Hex: 0x" + hex + "\n\n";
            salida.append(text);

            offset += (mtu - 20);
        }

        return salida.toString();
    }

    /**
     * Metodo main
     * <p>
     * Metodo principal donde se ejecuta el codigo
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tamDatagrama, mtu, cantFragmentos;
        String resultado = "\n";

        imprimir("Longitud total del datagrama: ");
        tamDatagrama = scanner.nextInt();

        imprimir("Longitud del MTU de la red: ");
        mtu = scanner.nextInt();

        cantFragmentos = tamDatagrama > mtu ? tamDatagrama / mtu + 1 : 1;
        resultado += "Cantidad de Fragmentos: " + cantFragmentos + "\n\n";

        resultado += gestionarFragmentos(tamDatagrama, mtu, cantFragmentos);

        imprimir(resultado);
        imprimir("------------------------------------\n\n");
    }

    /**
     * Metodo imprimir
     * <p>
     * Imprime un texto
     * Sirve como alias de System.out.print();
     *
     * @param texto Texto a imprimir
     */
    private static void imprimir(String texto) {
        System.out.print(texto);
    }
}
