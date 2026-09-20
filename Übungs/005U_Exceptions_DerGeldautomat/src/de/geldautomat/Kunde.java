package de.geldautomat;

public class Kunde {
    private String name;
    private Konto konto;

    public Kunde(String name, Konto konto){
        this.name = name;
        this.konto = konto;
    }

    public String getName() {
        return name;
    }

    public Konto getKonto() {
        return konto;
    }
}
