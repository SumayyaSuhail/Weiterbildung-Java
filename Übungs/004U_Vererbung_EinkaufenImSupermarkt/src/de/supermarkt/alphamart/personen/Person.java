package de.supermarkt.alphamart.personen;

/**
 * Parent class for Person - Kunde, Mitarbeiter and Kassierer
 */
public class Person {
    protected String name;

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
