package de.ogergames.figuren.helden;

import de.ogergames.figuren.Charakter;

/**
 * <pre>
 *     Ein Kluger Krieger IST EIN Krieger,
 *
 *     Ein Kluger Krieger verletzt sich nicht selbst.
 *     Held held1 = new Held("Gast");
 *     held1.verwunden(held1);
 *     Der Kluger Krieger kontrolliert selber, dass er nur einen anderen verwundet.
 *
 *     Hier muss kein expliziter (selbst geschrieben) Konstruktor erstellt werden, denn in der Elternklasse existiert ein
 *     parameterloser Konstruktor: super(); funktioniert.
 * </pre>
 */
public class KlugerKrieger extends Krieger{

    /**
     * DER KLUGER KRIEGER VERLETZT SICH NICHT SELBST!
     * Das soll auch in einer erbenden Klasse nicht geändert werden!
     * Lösung: final
     * Die Methode wird final deklariert, damit sie in erbenden Klassen nicht überschrieben werden kann.
     * (nichtIch == this) vergleicht die Inhalte der beiden Variablen: die, die Methode in Auftrag gibt und
     * die Variable, die als Parameter übergeben wird. == hier: vergleicht keine Objekte, sondern Adressen.
     * @param nichtIch der andere Charakter, der vom aktuell handeln, dem Charakter verwundet wird.
     */
    @Override
    public final void verwunden(Charakter nichtIch){
        if(nichtIch == this) {
            System.out.println("Ich bin doch nicht blöd!");
        } else {
            super.verwunden(nichtIch);
        }
    }
}
