package de.mygarten.faehigkeit;

/**
 * <pre>
 *     Functional interface with abstract method graben
 *     also tried using default method
 * </pre>
 */
@FunctionalInterface
public interface Graber {
    /**
     * Method to grab
     * @param flaecheGroesse wie groß die umzugrabende Fläche ist
     * @return gibt was Forderungen der Graber zurück
     */
    String graben(int flaecheGroesse);

    default void pauseMachen(){
        System.out.println("Der Gräber macht eine Pause");
    }
}
