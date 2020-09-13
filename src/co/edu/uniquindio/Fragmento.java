package co.edu.uniquindio;

/**
 * Clase Fragmento
 *
 * Representa un fragmento de datagrama en la red
 *
 * @author Yesid Shair Rosas Toro
 * @author Juan David Usma Alzate
 * @author Samara Smith Rincon Montaña
 */
public class Fragmento {
    private final int id;
    private final int longitud;
    private final String flag;
    private final int offset;

    /**
     * Constructor del Fragmento
     *
     * @param id        Numeral del fragmento
     * @param longitud  Longitud total del fragmento
     * @param flag      Flags del fragmento
     * @param offset    Offset o desplazamiento del fragmento
     */
    public Fragmento(int id, int longitud, String flag, int offset) {
        this.id = id;
        this.longitud = longitud;
        this.flag = flag;
        this.offset = offset;
    }

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
     * Metodo toString()
     *
     * Genera un String con una representacion en texto del Fragmento
     *
     * @return String : Fragmento en formato de texto
     */
    @Override
    public String toString() {
        String salida = "Fragmento " + id + "\n";
        salida += "Longitud total del fragmento: " + longitud + "\n";
        salida += "Flags: " + flag + "\n";

        String ob = completarDigitos(Integer.toBinaryString(offset), 13);
        salida += "Offset Bin: 0b" + ob + "\n";
        salida += "Offset Dec: " + offset + "\n";

        String hex = completarDigitos(Integer.toHexString(Integer.parseInt(flag+ob, 2)), 4);
        salida += "4 digitos Hex: 0x" + hex + "\n\n";
        return salida;
    }
}
