package de.sportfoerderung.einstieg;

import java.io.File;
import java.io.IOException;

/**
 * <pre>
 *     Demonstriert den Zugriff auf das Dateisystem als dauerhaften Speicher.
 *
 *     Textdatei: txt, JSON, xml, CSV, java         ---- char/Buchstaben/Unicode
 *     Bilddateien: jpg, gif, png                   ---- byte
 *     anderen Dateien: exe, class, jar, zip, doc   ---- byte
 *     Object Dateien: gespeicherte (Java)Objekte   ---- byte
 *
 *     Zwei Arten von Zugriffen auf Dateien: DatenStröme
 *          char: Reader und Writer
 *          byte: InputStream und OutputStream
 *
 *     DatenStröme und alles was dazu gehört: java.io
 *     (Klasse Path mit Factory Methoden: java.nio (new io))
 * </pre>
 */
public class ErstKontakt {

    public static void main(String[] args) throws IOException {
        File ersteDatei = new File("test-text");
        System.out.println("Das Objekt 'ersteDatei': " + (ersteDatei != null ? "existiert" : "existiert nicht"));
        System.out.println("Die Datei 'test-text': " + (ersteDatei.exists() ? "existiert im Dateisystem"
                : "existiert nicht im Dateisystem"));
        ersteDatei.createNewFile();
        System.out.println(ersteDatei.getAbsolutePath());
        String userDir = System.getProperty("user.home");
        System.out.println("Das Benutzerverzeichnis ist: " + userDir);

        System.out.println("\n---------- Datein werden organisiert: Verzeichnisse ----------\n");

        File organisierteDatei = new File("beispiele/text1");
        System.out.println("Die Datei text1 in Verzeichnis beispiele "
                    + (organisierteDatei.exists() ? "existiert im Dateisystem" : "existiert nicht im Dateisystem"));

        File verzeichnis = new File("beispiele");
        verzeichnis.mkdir();
        //organisierteDatei.createNewFile();//Legt eine Datei an, wenn das Verzeichnis existiert und Schreibrechte gegeben wurden

        boolean wirdAngelegt = organisierteDatei.createNewFile();
        System.out.println("Wird die Datei neu angelegt? (Damit Inhalte gelöscht?) " + wirdAngelegt);

        boolean geloescht = verzeichnis.delete();
        System.out.println("Wird das Verzeichnis gelöscht? " + geloescht);

        File inneresVerzeichnis = new File("beispiele/beispiele1");
        geloescht = inneresVerzeichnis.delete();
        System.out.println("Wird gelöscht wenn das leer ist? " + geloescht);

        System.out.println("\n---------- existierende absolute Pfade ----------\n");
        File xampp = new File("C:\\xampp");
        System.out.println("Ist xampp ein Verzeichnis? " + xampp.isDirectory());
        System.out.println("Ist xampp eine Datei? " + xampp.isFile());
        System.out.println("Ist xampp absolut: " + xampp.isAbsolute());

        File[] inhalteVonXampp = xampp.listFiles();
        System.out.println(inhalteVonXampp[8]);
    }
}
