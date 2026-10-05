package de.sportfoerderung.dateispeicher;

import de.sportfoerderung.modal.SportContainer;
import de.sportfoerderung.modal.Sportler;

import java.io.*;
import java.util.List;

/**
 * <pre>
 *     Demonstriert das Lesen und Schreiben aus und in Dateien.
 *
 *     Reader und Writer Objekte werden erstellt für Texte (char/unicode)
 *     InputStream und OutputStream Objekte werden erstellt für "den ganzen Rest" (byte)
 *
 *     IOExceptions werden nicht deklariert (kein throws IOException), sondern behandelt
 *     DatenStröme beanspruchen Resourcen, Resourcen nüssen freigegeben werden: -> close!
 *     Hier: try-with-Resources zum automatischen close Aufruf.
 * </pre>
 */
public class DateiZugriff {

    /**
     * <pre>
     *     Ein Text soll in eine Datei geschrieben werden. Der geeignete Datentyp heißt <b>BufferedWriter</b>.
     *     Datenströme werden <b>dekoriert</b>: BufferedWriter Konstruktoren erwarten ein Writer Objekt (ElternKlasse)
     *     "Dekorieren ist wie Vererben auf Objekte"
     *     try-with-resources ruft close auf (Autocloseable)
     *     close ruft flush auf (Flushable)
     *     flush ruft createNewFile auf
     *
     *     new FileWriter(ziel); erstellt ein Objekt das den Inhalt der Datei löscht und neue Inhalte schreibt
     *     new FileWriter(ziel, true); erstellt ein Objekt, das neue Inhalte an Ende der bestehenden Inhalte anhängt
     * </pre>
     *
     * @param ziel Die Datei, in dei geschrieben werden soll
     * @param text der geschrieben werden soll
     */
    public void schreibenInDatei(File ziel, String text) {
        try (
                Writer schreiber = new FileWriter(ziel, true);
                BufferedWriter schreiberMitDeko = new BufferedWriter(schreiber);
        ) {

            schreiberMitDeko.write(text);
            //schreiberMitDeko.append(text);
            schreiberMitDeko.newLine();
            //newLine(); Methode aus BuffereWriter

        } catch (IOException ausnahme) {
            ausnahme.printStackTrace();
        }
    }

    /**
     * Gelesen wird mit dem BufferedReader
     *
     * @param quelle ausgelesene Datei
     * @return der Text, der in der Datei steht
     */
    public String textLesenAusDatei(File quelle) {
        String rueckgabe = "========== Aus Datei ==========\n";
        try (
                Reader leser = new FileReader(quelle);
                BufferedReader leserMitDeko = new BufferedReader(leser)
        ) {
            while (true) {
                String geleseneZeile = leserMitDeko.readLine();
                if (geleseneZeile == null) {
                    break;
                }
                rueckgabe = rueckgabe + geleseneZeile + "\n";
            }

        } catch (IOException ausnahme) {
            ausnahme.printStackTrace();
        }

        return rueckgabe;
    }

    /**
     * Alle Arten von Daten (incl Bilder) mit InputStream und OutputStream gelesen bzw geschrieben werden.
     * Die Daten liegen als bytes vor.
     * Hier wird eine Bilddatei byteweise gelesen und die Bytes in eine weitere Datei (Kopie) geschrieben.
     *
     * @param quelle die Datei die gelesen wird
     * @param ziel   die Datei, die die Kopie der Bytes enthält
     */
    public void undekoriertKopieren(File quelle, File ziel) {
        try (
                InputStream leser = new FileInputStream(quelle);
                OutputStream schreiber = new FileOutputStream(ziel)
        ) {

            while (true) {
                int gelesen = leser.read();
                if (gelesen == -1) {
                    break;
                }
                schreiber.write(gelesen);
            }

        } catch (IOException ausnahme) {
            ausnahme.printStackTrace();
        }
    }

    /**
     * Dekoriert den Input/Output mit BufferedInputStream/BufferedOutputStream
     *
     * @param quelle da kommen die Daten her
     * @param ziel   da werden die Daten hingeschrieben
     */
    public void dekoriertKopieren(File quelle, File ziel) {
        try (
                BufferedInputStream dekoLeser = new BufferedInputStream(new FileInputStream(quelle));
                BufferedOutputStream dekoSchreiber = new BufferedOutputStream(new FileOutputStream(ziel))
        ) {

            byte[] puffer = new byte[1024];
            while (true) {
                int gelesen = dekoLeser.read(puffer);
                if (gelesen == -1) {
                    break;
                }
                dekoSchreiber.write(puffer);
            }

        } catch (IOException ausnahme) {
            ausnahme.printStackTrace();
        }
    }

    /**
     * Ein Java Objekt in einem Zustand soll gespeichert werden.
     * Dazu soll das gesamte Objekt erhalten bleiben, und nicht in die einzelnen Attribute
     * zerlegt werden
     *
     * @param ziel                 die Datei, die den Sportler enthält
     * @param einWichtigerSportler der Sportler der abgespeichert werden soll
     */
    public void speichernInDatei(File ziel, Sportler einWichtigerSportler) {
        try (
                OutputStream schreiber = new FileOutputStream(ziel);
                ObjectOutputStream dekoSchreiber = new ObjectOutputStream(schreiber)
        ) {

            dekoSchreiber.writeObject(einWichtigerSportler);

        } catch (IOException ausnahme) {
            ausnahme.printStackTrace();
        }
    }

    /**
     * Zwei Möglichkeiten 2 Exceptions zu fangen:
     * 1: catch (IOException | ClassNotFoundException ausnahme) {
     * ausnahme.printStackTrace();
     * }
     * 2: catch (IOException ausnahme) {
     * ausnahme.printStackTrace();
     * } catch (ClassNotFoundException ausnahme) {
     * ausnahme.printStackTrace();
     * }
     *
     * @param quelle Da liegt ein gespeicherter Sportler
     * @return der Sportler
     */
    public Sportler lesenSportlerAusDatei(File quelle) {
        try (
                ObjectInputStream dekoLeser = new ObjectInputStream(new FileInputStream(quelle))
        ) {

            Object gelesenObjekt = dekoLeser.readObject();
            System.out.println("---------- Testausgabe: " + gelesenObjekt.getClass().getName());
            return (Sportler) gelesenObjekt;
        } catch (IOException | ClassNotFoundException ausnahme) {
            ausnahme.printStackTrace();
        }
        return null;
    }

    /**
     * Schreibt mehrere Sportler Objekte, die in eine Liste zusammen gefasst werden
     */
    public void schreibenVielerSportler(File ziel, List<Sportler> vieleSportler) {
        try (
                ObjectOutputStream dekoSchreiber = new ObjectOutputStream(new FileOutputStream(ziel))
        ) {

            dekoSchreiber.writeObject(vieleSportler);

        } catch (IOException ausnahme) {
            ausnahme.printStackTrace();
        }
    }

    /**
     * Funktioniert, casting in typisierte Liste sollte vermieden werden
     */
    public List<Sportler> lesenVielerSportler(File quelle) {
        try (
                ObjectInputStream dekoLeser = new ObjectInputStream(new FileInputStream(quelle))
        ) {

            Object gelesenesObjekt = dekoLeser.readObject();
            return (List<Sportler>) gelesenesObjekt;
        } catch (IOException | ClassNotFoundException ausnahme) {
            ausnahme.printStackTrace();
        }

        return null;
    }

    public void schreibenContainer(File ziel, SportContainer einEinzigerContainer) {
        try (
                ObjectOutputStream dekoSchreiber = new ObjectOutputStream(new FileOutputStream(ziel))
        ) {

            dekoSchreiber.writeObject(einEinzigerContainer);

        } catch (IOException ausnahme) {
            ausnahme.printStackTrace();
        }
    }

    public SportContainer lesenEinesContainers(File quelle) {
        try (
                ObjectInputStream dekoLeser = new ObjectInputStream(new FileInputStream(quelle))
        ) {

            Object gelesenesObjekt = dekoLeser.readObject();
            return (SportContainer) gelesenesObjekt;
        } catch (IOException | ClassNotFoundException ausnahme) {
            ausnahme.printStackTrace();
        }

        return null;
    }
}
