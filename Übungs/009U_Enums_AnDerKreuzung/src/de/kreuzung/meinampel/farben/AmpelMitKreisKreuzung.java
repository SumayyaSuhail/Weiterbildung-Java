package de.kreuzung.meinampel.farben;
import java.io.IOException;

public class AmpelMitKreisKreuzung {

    public static void main(String[] args) throws IOException {
        AmpelMitKreis versuch = new AmpelMitKreis();
        System.out.println();
        for(int i =0; i < 30; i++) {
            System.out.println(versuch);
            versuch.schalten();
//			System.out.print("\033[H\033[2J");
        }
    }

}
