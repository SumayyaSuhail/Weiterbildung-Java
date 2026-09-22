package de.learn.collectionsundgenerics.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Demonstriert der Nutzung des Sets
 */
public class SchokoladenSet {
    public static void main(String[] args) {
        Set<Schokolade> schokoladen = new HashSet<>();
        boolean wurdeZugefuegt = schokoladen.add(new Schokolade("Merci", 12));
        System.out.println("Merci wurde zugefügt: " + wurdeZugefuegt);
        wurdeZugefuegt = schokoladen.add(new Schokolade("Lindt", 7));
        System.out.println("Lindt wurde zugefügt: " + wurdeZugefuegt);
        wurdeZugefuegt = schokoladen.add(new Schokolade("Toffifee", 8));
        System.out.println("Toffifee wurde zugefügt: " + wurdeZugefuegt);
        wurdeZugefuegt = schokoladen.add(new Schokolade("Lindt", 9));
        System.out.println("Lindt wurde zugefügt: " + wurdeZugefuegt);
    }
}
