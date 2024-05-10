package net.salesianos.menu;

public class Menu {
    public static String mostrar() {
        final String MENU = """
                1. Añadir palabra.\n
                2. Eliminar palabra.\n
                3. Existe palabra.\n
                4. Mostrar iniciales disponibles.\n
                5. Ver palabras por inicial.\n
                6. Cerrar programa.\n
                    """;
        return MENU;
    }
}
