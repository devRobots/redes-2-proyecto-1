package co.edu.uniquindio;

public class Fragmento {
    private final int id;
    private final int longitud;
    private final String flag;
    private final int offset;

    public Fragmento(int id, int longitud, String flag, int offset) {
        this.id = id;
        this.longitud = longitud;
        this.flag = flag;
        this.offset = offset;
    }

    @Override
    public String toString() {
        String salida = "Fragmento " + id + "\n";
        salida += "Longitud total del fragmento: " + longitud + "\n";
        salida += "Flags: " + flag + "\n";

        String ob = Main.completarDigitos(Integer.toBinaryString(offset), 13);
        salida += "Offset Bin: 0b" + ob + "\n";
        salida += "Offset Dec: " + offset + "\n";

        String hex = Main.completarDigitos(Integer.toHexString(Integer.parseInt(flag+offset, 2)), 4);
        salida += "4 digitos Hex: 0x" + hex + "\n\n";
        return salida;
    }
}
