package co.edu.uniquindio;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tamanioDatagrama, mtu;
        String respuesta = "";

        imprimir("Ingrese el tamaño del datagrama: ");
        tamanioDatagrama = scanner.nextInt();

        imprimir("Ingrese el MTU de la red: ");
        mtu = scanner.nextInt();
    }

    public static void imprimir(String texto) {
        System.out.print(texto);
    }
}
