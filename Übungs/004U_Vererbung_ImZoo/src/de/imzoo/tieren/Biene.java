package de.imzoo.tieren;

public class Biene extends Insekt{

    // ******************** zusätzliche Attribute ******************** //
    private double honigMengeInGramm;

    // ******************** Konstruktoren ******************** //
    public Biene(String name, double grosseInCm){
        super(name, grosseInCm);
        this.honigMengeInGramm = 0;
    }

    // ******************** zusätzliche Methoden ******************** //


    @Override
    public void sichBewegen() {
        System.out.println(name + " fliegt summend von Blüte zu Blüte.");
    }

    public void honigProduzieren() {
        honigMengeInGramm += 5;
        System.out.println(name + " produziert Honig. Aktuelle Menge: " + honigMengeInGramm + " g.");
    }

    @Override
    public String statusAnzeigen(){
        String info = "";
        info = info + super.statusAnzeigen();
        info = info + "Dieses Insekt produziert " + honigMengeInGramm + "g Honig.\n";
        return info;
    }
    // ******************** getter/setter ******************** //

    public double getHonigMengeInGramm() {
        return honigMengeInGramm;
    }

}
