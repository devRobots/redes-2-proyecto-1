package co.edu.uniquindio;

import java.util.Scanner;

public class Main {

    /**
     * Método que lee un entero con interfaz
     * @param mensaje Mensaje que indica que debe ingresar
     * @return Número entero capturado
     */
    public static int leerEntero (String mensaje)
    {
        return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
    }

    /**
     * Método que convierte un entero decimal a un string binario
     * @param dec Entero a convertir
     * @return String del entero convertido en binario
     */
    public static String decABin (int dec)
    {
        String res="";
        while (dec>=1)
        {
            res = (dec%2)+res;
            dec = dec/2;
        }
        while (res.length()<13)
        {
            res ="0"+res;
        }
        return res;
    }

    /**
     * Método que realiza la conversión de un String de un número binario a hexadecimal
     * @param bin
     * @return
     */
    public static String binToHex(String bin) {
        int i = Integer.parseInt(bin, 2);
        String hex = Integer.toHexString(i);
        while (hex.length()<4)
        {
            hex ="0"+hex;
        }
        return hex;
    }

    /**
     * Método que recibe la longitud de un datagrama y el mtu por el cual será enviado y determina cuanto se fragmentará
     * @param data Longitud del datagrama
     * @param mtu Tamaño del MTU por el que será enviado
     * @return El número de fragmentos en lo que se fragementará el datagrama
     */
    public static int numFragmentos (int data, int mtu)
    {
        int dg= data;
        int num =0;
        while (dg>0)
        {
            dg -= (mtu - 20);
            num++;
        }
        //System.out.println(dg);
        return num;
    }

    /**
     * Método que gestiona la fragmentación de datagramas
     * @param data Longitud del datagrama
     * @param mtu Tamaño del MTU
     * @param n Número de fragmentos
     * @return Tabla en la que se describe la fragmentación del datagrama e información relevante de esos fragmentos
     */
    public static String[] gestionarFragmentos(int data, int mtu, int n)
    {
        String[] salida=new String[n];
        int offset=0;
        for (int i = 0; i < n; i++) {

            String ob= decABin(offset);
            if(i<n-1)
            {
                String h ="001"+ob;
                String hex = binToHex(h);

                String text = "Fragmento "+(i+1)+"\n";
                text+="longitud del fragmento: "+(mtu-20)+"\n";
                text+="flags: 001"+"\n";
                text+="Offset Binario: "+ob+"\n";
                text+="Offset Decimal: "+offset+"\n";
                text+="Digitos Hexadecimales: "+hex+"\n\n";
                salida[i]=text;
            }
            else
            {
                int rest= data-offset;
                String h ="000"+ob;
                String hex = binToHex(h);

                String text = "Fragmento "+(i+1)+"\n";
                text+="longitud del fragmento: "+rest+"\n";
                text+="flags: 000"+"\n";
                text+="Offset Binario: "+ob+"\n";
                text+="Offset Decimal: "+offset+"\n";
                text+="Digitos Hexadecimales: "+hex+"\n\n";
                salida[i]=text;
            }
            offset+=(mtu-20);
        }

        return salida;
    }

    /**
     * Método que imprime texto en consola
     * @param texto texto a imprimir
     */
    public static void imprimir(String texto) {
        System.out.print(texto);
        
            
        }
    /**
     * Método main
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a, b;
        String respuesta = "";

        imprimir("Ingrese el tamaño del datagrama: ");
        a = scanner.nextInt();

        imprimir("Ingrese el MTU de la red: ");
        b = scanner.nextInt();

        //int a= leerEntero("Ingrese el tamaño del datagrama");
        //int b= leerEntero("Ingrese el tamaño del MTU");
        int c= numFragmentos(a,b);

        if (a>b)
        {
            //System.out.println(c);
            String[]fragmentos= gestionarFragmentos(a,b,c);

            String texto1= "El datagrama ha sido dividido en "+c+" fragmentos"+"\n";
            String texto2= "Longitud total del Datagrama: "+a+"\n";
            String texto3= "Longitud del MTU: "+b+"\n\n";
            String textoF = texto1+texto2+texto3;
            for (int i = 0; i <fragmentos.length; i++) {
                textoF+= fragmentos[i];
            }
            //JOptionPane.showMessageDialog(null, textoF);
            imprimir(textoF);
        }
        else
        {
            String texto= "El datagrama no ha sido fragmentado"+"\n";
            texto+= "Longitud total del Datagrama: "+a+"\n";
            texto+= "Longitud del MTU: "+b+"\n\n";

            texto+="longitud del fragmento: "+a+"\n";
            texto+="flags: 010"+"\n";
            texto+="Offset Binario: "+"0000000000000"+"\n";
            texto+="Offset Decimal: "+"0"+"\n";
            texto+="Digitos Hexadecimales: "+"4000"+"\n\n";

            //JOptionPane.showMessageDialog(null, texto);
            imprimir(texto);
        }



    }
}
