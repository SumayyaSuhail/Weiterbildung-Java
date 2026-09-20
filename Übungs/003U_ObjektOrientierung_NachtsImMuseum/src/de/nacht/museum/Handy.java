package de.nacht.museum;

/**
 * <pre>
 *     Objektbeschreibung
 *     Das Handy von marken Pixel.
 *     Das Handy hat akku leer / ist voll.
 *     Das Handy kann benutzt werden.
 * </pre>
 */
public class Handy {

    // region ******************** Attribute/Eigenschaften/Felder ******************** //
    private String handyMarke;
    private boolean handyAkku;

    // endregion

    // region ******************** Methoden/Fähigkeiten/Jobs ******************** //
    public void handyaufladen(){
        if(handyAkku){
            System.out.println(handyMarke + " Akku ist voll und braucht ladung nicht mehr!");
            handyNutzen();
        } else {
            System.out.println(handyMarke + " hat kein Akku.");
            System.out.println(handyMarke + " wird aufgeladen.");
            handyAkku = true;
        }
    }

    public void handyNutzen(){
        if(handyAkku){
            System.out.println(handyMarke + " kann verwendet werden.");
            selfieMachen();
        } else {
            System.out.println(handyMarke + " sollte aufgeladen werden.");
            handyAkku = false;
            handyaufladen();
        }
    }

    public void selfieMachen(){
        System.out.println("Selfie ist genommen");
        handyAkku = false;
    }

    //endregion

    // region ******************** getter/setter ******************** //
    public void setHandyMarke(String marke) {
        handyMarke = marke;
    }

    public String getHandyMarke() {
        return handyMarke;
    }
}
