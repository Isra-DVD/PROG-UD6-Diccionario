package net.salesianos.validaciones;

import javax.swing.JOptionPane;

public class Validador {
    public static boolean esNumero(String texto) {
        try {
            Integer.parseInt(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean noNulo(String texto) {
        if (texto != null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean palabraAceptable(String texto) {

        if (noNulo(texto)) {

            if (texto.length() > 0) {

                if (!esNumero(texto)) {
                    char[] letrasPalabra = texto.toCharArray();

                    for (int i = 0; i < letrasPalabra.length; i++) {
                        char letraParseada = letrasPalabra[i];
                        if (letraParseada < 97 || letraParseada > 122) {
                            JOptionPane.showMessageDialog(null,
                                    "La palabra introducida no puede contener números o caracteres especiales");
                            return false;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "La palabra introducida es aceptable");
                    return true;
                }
                JOptionPane.showMessageDialog(null, "La palabra introducida no puede ser un número");
                return false;
            }
            JOptionPane.showMessageDialog(null, "Te arrepientes de introducir una palabra? pff");
            return false;
        }
        return false;
    }
}
