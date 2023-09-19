package ElAhorcado.AhorcadoJuego;

import java.util.Scanner;

public class AhorcadoModularizado {
    /**
     * @param args
     */
    public static void main(String[] args) {

        // Llamamos al método para obtener la palabra secreta .
        String palabraSecreta = getPalabraSecreta();

        // Mostramos la longitud de la palabra secreta

        // Llamada al método para obtener los guiones de la palabra secreta
        char[] guionesPalabras = getGuionesPalabras(palabraSecreta);
        boolean juegoTerminado = false;
        Scanner in = new Scanner(System.in);
        int intentos = 3;

        // bucle para que el usuario introduzca letras y se vayan mostrando los guiones
        // en caso que la letra esté en la palabra secreta
        do {
            System.out.println("JUEGO DEL AHORCADO ");
            System.out.println("\nLa palabra secreta a adivinar tiene " + palabraSecreta.length() + " letras");
            System.out.println("Tienes " + intentos + " intentos");
            System.out.println(guionesPalabras);
            System.out.println("\nIntroduce una letra: ");
            char letra = in.next().charAt(0);
            boolean letraEncontrada = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    guionesPalabras[i] = letra;
                    letraEncontrada = true;
                }
            }
            if (!letraEncontrada)
                System.out.println("La letra " + letra + " no está en la palabra secreta");
            --intentos;
            if (intentos == 0) {
                System.out.println("!Has perdido!");
                juegoTerminado = true;
            } else {
                boolean juegoGanado = !hayGuiones(guionesPalabras);
                if (juegoGanado) {
                    System.out.println("!Enhorabuena, has acertado la palabra secreta!");
                    juegoTerminado = true;
                }
            }
        } while (!juegoTerminado);

    }

    public static String getPalabraSecreta() {
        String[] palabras = { "casa", "avenida", "piscina", "dardo", "naranja", "zebra", "historia", "desierto",
                "matriz" };
        int aleatorio = (int) (Math.random() * palabras.length);
        return palabras[aleatorio];
    }

    public static char[] getGuionesPalabras(String palabras) {
        int nLetras = palabras.length();
        char guionesPalabras[] = new char[nLetras];
        for (int i = 0; i < nLetras; i++) {
            guionesPalabras[i] = '_';
        }
        return guionesPalabras;
    }

    public static boolean hayGuiones(char[] array) {
        for (char letra : array) {
            if (letra == '_') {
                return true;
            }
        }
        return false;
    }
}
