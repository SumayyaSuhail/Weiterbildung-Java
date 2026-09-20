package test;

import de.ogergames.figuren.helden.KlugerKrieger;
import de.ogergames.figuren.helden.KlugerKriegerMitHeuschnupfen;

/**
 * Demonstriert die Probleme der Kluger Krieger mit Heuschnupfen.
 */
public class KlugerKriegerMitHeuschnupfenTest {
    public static void main(String[] args) {
        KlugerKrieger einstein = new KlugerKriegerMitHeuschnupfen();
        System.out.println(einstein.erstellenStatusInformation());
        einstein.verwunden(einstein);
        System.out.println(einstein.erstellenStatusInformation());
    }
}
