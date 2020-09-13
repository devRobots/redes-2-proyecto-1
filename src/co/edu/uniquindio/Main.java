package co.edu.uniquindio;

import java.util.ArrayList;
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
     * Metodo Obtener Fragmentos
     *
     * Genera una lista con los fragmentos en base
     * a la data y al MTU ingresados
     *
     * @param data Longitud del datagrama
     * @param mtu  Longitud del MTU de la red
     * @return ArrayList<Fragmento> : La lista con los fragmentos
     */
    public static ArrayList<Fragmento> obtenerFragmentos(int data, int mtu) {
        int offset = 0;
        int n = data > mtu ? (int)Math.ceil((double)(data - 20) / (mtu - 20)) : 1;

        ArrayList<Fragmento> lista = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String flag = i < n - 1 ? "001" : "000";

            int longitud = i < n - 1 ? mtu : data - offset;
            Fragmento fragmento = new Fragmento(i+1, longitud, flag, offset);
            lista.add(fragmento);

            offset += (mtu - 20);
        }

        return lista;
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

        if (tamDatagrama > 20) {
            if (mtu > 20) {
                imprimirLista(obtenerFragmentos(tamDatagrama, mtu));
                imprimir("------------------------------------\n\n");
            } else {
                imprimir("Error: MTU invalido");
            }
        } else {
            imprimir("Error: Longitud de datagrama incorrecta");
        }
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
     * Metodo  ImprimirLista
     *
     * Imprime el texto de una lista
     *
     * @param lista La lista a imprimir
     */
    private static void imprimirLista(ArrayList<?> lista) {
        imprimir("\n Cantidad de fragmentos: " + lista.size() + "\n\n");
        for (Object elemento : lista) {
            imprimir(elemento.toString());
        }
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
