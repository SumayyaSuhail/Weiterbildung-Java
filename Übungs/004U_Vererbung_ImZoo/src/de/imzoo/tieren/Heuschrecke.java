package de.imzoo.tieren;

public class Heuschrecke extends Insekt{

    // ******************** zusätzliche Attribute ******************** //
    private double sprungweiteInCm;

    // ******************** Konstruktoren ******************** //

    public Heuschrecke(String name, double grosseInCm, double sprungweiteInCm){
        super(name, grosseInCm);
        this.sprungweiteInCm = sprungweiteInCm;
    }

    // ******************** zusätzliche Methoden ******************** //

    @Override
    public void sichBewegen() {
        System.out.println(name + " springt " + sprungweiteInCm + " cm weit.");
    }

    @Override
    public String statusAnzeigen(){
        String info = "";
        info = info + "Diese Heuschrecke heißt " + name + ".\n";
        info = info + "Diese Heuschrecke ist " + grosseInCm + " cm groß.\n";
        info = info + "Diese Heuschrecke hat eine Lebenserwartung von " + lebenserwartungInTagen + " Tagen.\n";
        info = info + "Diese Heuschrecke springt " + sprungweiteInCm + "cm weit.\n";
        return info;
    }

    // ******************** getter/setter ******************** //

    public double getSprungweiteInCm() {
        return sprungweiteInCm;
    }

}
