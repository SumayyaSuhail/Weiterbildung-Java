package de.kreuzung.meinampel.farben;

/**
 * https://en.wikipedia.org/wiki/ANSI_escape_code
 * https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
 * @author Alfa
 *
 */
public class FarbTest {

    public static void main(String[] args) {
        System.out.println("\u001B[32m" + "Hallo " +
                "\u001B[35mFarbwelt");
        System.out.println("\033[0;33mGELB");
        System.out.println("\033[0mReset");
        System.out.println("\033[1;36mFarbtest: ");
        System.out.println("König: " + "\u2654");
    }
}
