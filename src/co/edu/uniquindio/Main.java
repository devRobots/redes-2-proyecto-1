package co.edu.uniquindio;

import java.util.Scanner;

public class Main {

    private static String completarDigitos(String bin, int tam) {
        StringBuilder binBuilder = new StringBuilder(bin);
        while (binBuilder.length() < tam) {
            binBuilder.insert(0, "0");
        }
        bin = binBuilder.toString();
        return bin;
    }

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

    public static void main(String[] args) {
        while (true) {
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
    }

    private static void imprimir(String texto) {
        System.out.print(texto);
    }
}
