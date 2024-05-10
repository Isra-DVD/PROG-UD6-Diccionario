package net.salesianos.diccionario;

import javax.swing.JOptionPane;
import net.salesianos.validaciones.Validador;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class Diccionario {
    private static Map<Character, Set<String>> coleccionesDeLetras = new HashMap<>();

    public static void añadirPalabraAlSet() {
        String palabraAñadir = JOptionPane.showInputDialog("Introduzca la palabra a añadir");
        palabraAñadir = palabraAñadir.toLowerCase();
        if (Validador.palabraAceptable(palabraAñadir)) {
            palabraAñadir = palabraAñadir.trim();
            Character letraInicial = palabraAñadir.charAt(0);

            if (!coleccionesDeLetras.containsKey(letraInicial)) {
                Set<String> setLetras = new HashSet<>();
                setLetras.add(palabraAñadir);
                coleccionesDeLetras.put(letraInicial, setLetras);
                JOptionPane.showMessageDialog(null, "Palabra añadida con exito");
            } else {
                Set<String> setLetras = coleccionesDeLetras.get(letraInicial);
                if (setLetras.isEmpty()) {
                    setLetras.add(palabraAñadir);
                    JOptionPane.showMessageDialog(null, "Palabra añadida con exito");
                    return;
                }
                if (setLetras.contains(palabraAñadir)) {
                    JOptionPane.showMessageDialog(null, "La palabra ya existe");
                } else {
                    setLetras.add(palabraAñadir);
                    coleccionesDeLetras.replace(letraInicial, setLetras);
                    JOptionPane.showMessageDialog(null, "Palabra añadida con exito");
                }
            }

        }
    }

    public static void mostrarInciales() {
        if (coleccionesDeLetras.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay palabras guardadas ");
            return;
        }

        String mensaje = "Iniciales: \n";
        for (char inicial : coleccionesDeLetras.keySet()) {
            mensaje += (inicial + "\n");
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public static void mostrarPalabrasPorLetra() {
        char letraBuscar = JOptionPane.showInputDialog("Introduzca la inicial de la palabra a buscar").charAt(0);
        letraBuscar = Character.toLowerCase(letraBuscar);

        if (coleccionesDeLetras.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay palabras guardadas ");
            return;
        }

        if (coleccionesDeLetras.containsKey(letraBuscar)) {
            String mensaje = ("Palabras con la inicial " + letraBuscar + " :\n");
            for (String palabra : coleccionesDeLetras.get(letraBuscar)) {
                mensaje += (palabra + "\n");
            }
            JOptionPane.showMessageDialog(null, mensaje);
            return;
        }
        JOptionPane.showMessageDialog(null, "No hay palabras guardadas con esa inicial ");
    }

    public static void buscarPalabra() {
        String palabraBuscar = JOptionPane.showInputDialog("Introduzca la palabra a buscar").toLowerCase();

        if (coleccionesDeLetras.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay palabras guardadas ");
            return;
        }

        if (coleccionesDeLetras.containsKey(palabraBuscar.charAt(0))) {
            if (coleccionesDeLetras.get(palabraBuscar.charAt(0)).contains(palabraBuscar)) {
                JOptionPane.showMessageDialog(null, "La palabra esta en el diccionario");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "La palabra no esta en el diccionario");
    }

    public static void eliminarPalabra() {
        String palabraEliminar = JOptionPane.showInputDialog("Introduzca la palabra a eliminar").toLowerCase();

        if (coleccionesDeLetras.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay palabras guardadas ");
            return;
        }

        if (coleccionesDeLetras.containsKey(palabraEliminar.charAt(0))) {
            if (coleccionesDeLetras.get(palabraEliminar.charAt(0)).remove(palabraEliminar)) {
                JOptionPane.showMessageDialog(null, "La palabra ha sido borrada de manera satisfactoria");
            } else {
                JOptionPane.showMessageDialog(null, "Esa palabra no se encuentra en el diccionario");
            }
        }
    }
}
