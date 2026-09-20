package de.ogergames.kaempfen;

import de.ogergames.figuren.Charakter;
import de.ogergames.figuren.Held;

import java.util.Scanner;

/**
 * Abstraktion:
 * Klasse Turnier
 * Attribute: Erste Charakter und Name, Zweite Charakter und Name, Dritte Charakter und Name
 * Methoden: duellieren, erklaertSieger
 */
public class Turnier {
    // ******************** Attribute/Eigenschaften/Felder ******************** //

    // ******************** Konstruktoren ******************** //

    // ******************** Methoden/Fähigkeiten ******************** //

    /**
     * The 2 character battle continues until one character is defeated
     * Displays Status after each attack
     * When one character is defeated, displays that the other character won.
     */

    public void duellieren(Charakter ersteCharakter, String ersteName, Charakter zweiteCharakter, String  zweiteName){
        while (ersteCharakter.isNochDabei() && zweiteCharakter.isNochDabei()){
            ersteCharakter.verwunden(zweiteCharakter);
            zweiteCharakter.verwunden(ersteCharakter);
            System.out.println(ersteName + ":\n" + ersteCharakter.erstellenStatusInformation());
            System.out.println(zweiteName + ":\n" + zweiteCharakter.erstellenStatusInformation());
        }

        if (!ersteCharakter.isNochDabei()){
            System.out.println(zweiteName + " hat gewonnen!");
        } else if (!zweiteCharakter.isNochDabei()){
            System.out.println(ersteName + " hat gewonnen!");
        }
    }

    /**
     * Two characters are selected randomly, in which one of them is Held.
     * Check if instance of Held, if yes - choose ausruhen or angreifen.
     * normal character attacks automatically
     * end the fight as soon as fighter is eliminated.
     */
    public void interaktivDuellieren(Charakter ersterKaempfer, Charakter zweiterKaempfer){
        while (ersterKaempfer.isNochDabei() && zweiterKaempfer.isNochDabei()){
            if (ersterKaempfer instanceof Held){
                System.out.println("Erster: Du bist Held, möchtest du ausruhen-0 oder angreifen-1?\n");
                int wahl = new Scanner(System.in).nextInt();
                if(wahl == 0){
                    ((Held) ersterKaempfer).ausruhen();
                } else if (wahl == 1) {
                    ersterKaempfer.verwunden(zweiterKaempfer);
                    erklaertSieger(ersterKaempfer, zweiterKaempfer);
                }
                if (zweiterKaempfer.isNochDabei()){
                    zweiterKaempfer.verwunden(ersterKaempfer);
                    erklaertSieger(ersterKaempfer, zweiterKaempfer);
                }
            } else if (zweiterKaempfer instanceof Held) {
                ersterKaempfer.verwunden(zweiterKaempfer);
                erklaertSieger(ersterKaempfer, zweiterKaempfer);
                if(zweiterKaempfer.isNochDabei()) {
                    System.out.println("Zweiter: Du bist Held, möchtest du ausruhen-0 oder angreifen-1?\n");
                    int wahl = new Scanner(System.in).nextInt();
                    if (wahl == 0) {
                        ((Held) zweiterKaempfer).ausruhen();
                    } else if (wahl == 1) {
                        zweiterKaempfer.verwunden(ersterKaempfer);
                        erklaertSieger(ersterKaempfer, zweiterKaempfer);
                    }
                }
            }
            System.out.println("ErsterKämpfer:\n" + ersterKaempfer.erstellenStatusInformation());
            System.out.println("ZweiterKämpfer:\n" + zweiterKaempfer.erstellenStatusInformation());
        }
    }

    /**
     * The winner is declared when <i>isNochDabei</i> is false for one of the two characters
     * Display heldenname if the winner is Held
     * Display monster won if the winner is not Held
     */
    public void erklaertSieger (Charakter ersterKaempfer, Charakter zweiterKaempfer){

        if(!ersterKaempfer.isNochDabei()){
            if(ersterKaempfer instanceof Held){
                System.out.println("\n***** Die Monster haben gesiegt! *****\n");
            } else {
                System.out.println("\n***** Der Sieger ist " + ((Held) zweiterKaempfer).getHeldenname() + " *****\n");
            }
        } else if (!zweiterKaempfer.isNochDabei()){
            if(zweiterKaempfer instanceof Held){
                System.out.println("\n***** Die Monster haben gesiegt! *****\n");
            } else {
                System.out.println("\n***** Der Sieger ist " + ((Held) ersterKaempfer).getHeldenname() + " *****\n");
            }
        }
    }

    /**
     * The 3 character battle continues until one character is left
     * 1 → 2, 2 → 3, 3 → 1
     */
    public void triellieren(Charakter ersteCharakter, String ersteName,
                            Charakter zweiteCharakter, String zweiteName,
                            Charakter dritteCharakter, String dritteName){
        while((ersteCharakter.isNochDabei() && zweiteCharakter.isNochDabei())
        || (ersteCharakter.isNochDabei() && dritteCharakter.isNochDabei())
        || (zweiteCharakter.isNochDabei() && dritteCharakter.isNochDabei())
        || (ersteCharakter.isNochDabei() && zweiteCharakter.isNochDabei() && dritteCharakter.isNochDabei())) {
            if (ersteCharakter.isNochDabei() && zweiteCharakter.isNochDabei() && dritteCharakter.isNochDabei()) {
                ersteCharakter.verwunden(zweiteCharakter);
                zweiteCharakter.verwunden(dritteCharakter);
                dritteCharakter.verwunden(ersteCharakter);
            } else if (ersteCharakter.isNochDabei() && zweiteCharakter.isNochDabei()) {
                ersteCharakter.verwunden(zweiteCharakter);
                zweiteCharakter.verwunden(ersteCharakter);
            } else if (ersteCharakter.isNochDabei() && dritteCharakter.isNochDabei()) {
                ersteCharakter.verwunden(dritteCharakter);
                dritteCharakter.verwunden(ersteCharakter);
            } else if (zweiteCharakter.isNochDabei() && dritteCharakter.isNochDabei()) {
                zweiteCharakter.verwunden(dritteCharakter);
                dritteCharakter.verwunden(zweiteCharakter);
            }
            System.out.println(ersteName + ":\n" + ersteCharakter.erstellenStatusInformation());
            System.out.println(zweiteName + ":\n" + zweiteCharakter.erstellenStatusInformation());
            System.out.println(dritteName + ":\n" + dritteCharakter.erstellenStatusInformation());
        }
    }

    /** The winner is declared when <i>isNochDabei</i> is false for one of the three characters */
    public void erklaertSiegerTriell (Charakter ersteCharakter, String ersteName,
                                      Charakter zweiteCharakter, String zweiteName,
                                      Charakter dritteCharakter, String dritteName){
        if(!zweiteCharakter.isNochDabei() && !dritteCharakter.isNochDabei()){
            System.out.println(ersteName + " hat gewonnen!");
        } else if (!ersteCharakter.isNochDabei() && !dritteCharakter.isNochDabei()){
            System.out.println(zweiteName + " hat gewonnen!");
        } else if (!ersteCharakter.isNochDabei() && !zweiteCharakter.isNochDabei()){
            System.out.println(dritteName + " hat gewonnen!");
        } else {
            System.out.println("Unentschieden!");
        }
    }
    // ******************** getter/setter ******************** //

}
