package de.nacht.museum;

import java.util.Random;

/**
 * <pre>
 *     Objektbeschreibung
 *     Eine griechische Statue die Aphrodite heißt.
 *     Aphrodite ist 2300 Jahre alt
 *
 *     Aphrodite macht ein Selfie.
 * </pre>
 */
public class GriechischeStatue {

    // region ******************** Attribute/Eigenschaften/Felder ******************** //
    private String[] statues = {"Aphrodite", "Thalia", "Hebe"};
    private Handy statueHandy;

    // endregion

    // region ******************** Methoden/Fähigkeiten/Jobs ******************** //

    public void fotoMachen(){
        Random random = new Random();
        int index = random.nextInt(statues.length);
        System.out.println(statues[index] + " macht Selfie mit " + statueHandy.getHandyMarke() + ".");
        statueHandy.handyNutzen();
    }

    //endregion

    // region ******************** getter/setter ******************** //
    public void setStatueHandy(Handy handy) {
        statueHandy = handy;
    }
}
