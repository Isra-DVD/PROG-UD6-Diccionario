import javax.swing.JOptionPane;

import net.salesianos.menu.Menu;
import net.salesianos.diccionario.Diccionario;
import net.salesianos.validaciones.Validador;

public class App {
    public static void main(String[] args) throws Exception {

        boolean seguirPreguntando = true;
        JOptionPane.showMessageDialog(null, "Bienvenido al super diccionario de DUOLINGO");

        while (seguirPreguntando) {

            String opcionUsuario = JOptionPane.showInputDialog(Menu.mostrar());
            if (Validador.noNulo(opcionUsuario)) {

                switch (opcionUsuario) {
                    case "1":
                        Diccionario.añadirPalabraAlSet();
                        break;

                    case "2":
                        Diccionario.eliminarPalabra();
                        break;

                    case "3":
                        Diccionario.buscarPalabra();
                        break;

                    case "4":
                        Diccionario.mostrarInciales();
                        break;

                    case "5":
                        Diccionario.mostrarPalabrasPorLetra();
                        break;

                    case "6":
                        JOptionPane.showMessageDialog(null, "Adiós\n");
                        seguirPreguntando = false;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Valor invalido, vuelva a intentarlo\n");
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Valor invalido, vuelva a intentarlo\n");
            }
        }
    }
}
