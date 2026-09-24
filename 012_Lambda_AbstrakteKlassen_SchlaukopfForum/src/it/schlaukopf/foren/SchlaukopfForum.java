package it.schlaukopf.foren;

import it.schlaukopf.organisation.Schlaukopf;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     das SchlaukopfForum nimmt schlaue Köpfe auf.
 *     Schlaue Köpfe  melden sich mit einem Nickname (eindeutig) an.
 *     Das Schlaukopf Forum läßt alle schlaue Köpfe  zu Wort kommen.
 *     Das Schlaukopf Forum organisiert eine Denkpause für alle schlauen Köpfe.
 *
 *     Methoden: aufnehmen, diskutierenLassen, denkenLassen
 * </pre>
 */
public class SchlaukopfForum {
    /**
     * Interfaces können keine Objekt-Attribute haben, also kann der <i>Nickname</i> nicht im
     * Interface untergebracht werden.
     * Lösung: Eine Map mit Key: Nickname, Value: Schlaukopf
     */
    private Map<String, Schlaukopf> dieSchlauenKoepfe = new HashMap<>();

    public void aufnehmen(Schlaukopf einSchlauerKopf, String nick) {
        System.out.println(nick + ", ein schlauer Kopf betritt das Forum.");
        dieSchlauenKoepfe.put(nick, einSchlauerKopf);
    }

    /**
     * Ruft die reden Methode auf, die im Interface abstrakt beschreiben ist:
     * Jeder Objekttyp hat seine ganz eigene reden-Methode.
     */
    public void alleDiskutieren() {
        System.out.println("\nHören wir zu, was alle die schlauen Köpfe zu sagen haben:\n");
        for (String nick : dieSchlauenKoepfe.keySet()) {
            System.out.println(nick + " sagt: " + dieSchlauenKoepfe.get(nick).reden() + ".\n");
        }
        System.out.println();
    }

    /**
     * ruft die denken Methode auf: Das ist eine default Methode aus dem Interface:
     * Manche Objekttypen überschreiben sie, manche nicht.
     * Durch Lambda erstellte Objekttypen können die Methode nicht überschreiben.
     * Durch Lambda erstelle, Objekte denken: ICH HABE RECHT.
     */
    public void denken() {
        System.out.println("\nÜber das Gehörte muss nachgedacht werden:\n");
        dieSchlauenKoepfe.forEach((nick, genie) -> {
            System.out.println("____________________" + nick + "____________________");
            System.out.println("Ich kann denken, denn ich bin vom Typ: " + genie.getClass().getName());
            genie.denken();
            System.out.println("_____________________________________________________");
        });
    }

    @Override
    public String toString() {
        return "SchlaukopfForum{" +
                "dieSchlauenKoepfe=" + dieSchlauenKoepfe.keySet() +
                '}';
    }
}
