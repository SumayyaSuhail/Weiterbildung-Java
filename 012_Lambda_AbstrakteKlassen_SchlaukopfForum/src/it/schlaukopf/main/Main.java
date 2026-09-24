package it.schlaukopf.main;

import it.schlaukopf.foren.SchlaukopfForum;
import it.schlaukopf.leute.AstroPhysiker;
import it.schlaukopf.leute.Physiker;
import it.schlaukopf.organisation.Schlaukopf;

import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * <pre>
 *     Enthält die main-Methode.
 *
 *     In der main-Methode werden Objekte angelegt von verschiedenen
 *     Objekttypen, mit unterschiedliche reden-Methode. Sie implementieren
 *     alle direkt oder indirekt das Schlaukopf Interface.
 *
 *     Die Objekte werden alle ins Forum aufgenommen,
 *     diskutieren da (reden Methoden)
 *     denken da (denken Methode)
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("\n\tWillkommen im Forum für schlaue Leute!\n");

        SchlaukopfForum forum = new SchlaukopfForum();

        // ***** Objekt der konkreten Klasse AstroPhysiker ***** //
        // Astrophysiker extends Physiker, Physiker implements Schlaukopf
        AstroPhysiker lesch = new AstroPhysiker();
        forum.aufnehmen(lesch, "Nächtlicher Sternenerklärer");

        // ***** Objekt einer anonymen Klasse, die die Klasse Physiker erweitert ***** //
        // Anonyme Klasse extends Physiker, Physiker implements Schlaukopf
        Physiker einstein = new Physiker() {
            @Override
            public void forschen() {
                System.out.println("Ich verzichte auf jedes Labor: Ich hab doch einen Kopf!" +
                        " Und dann strecke ich der Klassischen Physik die Zunge heraus!");
            }

            @Override
            public String reden() {
                return "E = mc²";
            }

            @Override
            public void denken() {
                System.out.println("Alles ist relativ!");
            }
        };

        forum.aufnehmen(einstein, "Einstein");

        // ***** Fragezeichen: lokale innere Klasse, die das Schlaukopf Interface implementiert ***** //
        class Fragezeichen implements Schlaukopf {
            @Override
            public String reden() {
                return "Wir lösen den Fall auf jeden Fall!";
            }

            @Override
            public void denken() {
                System.out.println("Treffen in der Zentrale: der Fall ist gelöst!");
            }

            public void visitenKartenVerteilen() {
                System.out.println("Die drei ??? - wir übernehmen jeden Fall.");
            }
        }

        Fragezeichen justus = new Fragezeichen();
        justus.visitenKartenVerteilen();
        forum.aufnehmen(justus, "Der erste Detektiv");

        // ***** Anonyme innere Klasse, die das Schlaaukopf Interface implementiert ***** //
        Schlaukopf sherlock = new Schlaukopf() {
            @Override
            public String reden() {
                return "Wenn alle unmöglichen Lösungen ausgeschlosssen sind, muss die verbleibende Lösung " +
                        "die richtige sein!";
            }

            @Override
            public void denken() {
                System.out.println("Die Lösung ist offensichtlich.");
            }
        };
        forum.aufnehmen(sherlock, "Holmes, Sherlock Holmes");

        // ***** Lambda Ausdruck zur Erstellung eines Objekt, implementiert reden() ***** //
        //Weder class Schlüsselwort wird verwendet noch new Schlüsselwort, aber beides passiert:
        //Es wiird eine Klasse angelegt und ein Objekt dieser Klasse erstellt,
        //Adresse dieses Objektes wird in der Referenz gespeichert.
        Schlaukopf influencer = () -> "100 Likes sind mehr als ein Nobelpreis, #Weisheit";
        forum.aufnehmen(influencer, "Guru of Likes");

        // ***** Lambda Ausdruck mit mehreren Anweisungen ***** //
        Schlaukopf schlauBisSchlumpf = () -> {// hier startet der Inhalt der reden-Methode
            String erkenntnis = "Schlumpfen ist eine blaue Wissenschaft";
            return "Ich habe gründlich mindestens 10 Sekunden lang nachgedacht: " + erkenntnis + "!";
        };
        forum.aufnehmen(schlauBisSchlumpf, "Schlaubi, der schlauste Schlumpf von allen!");

        // ***** Lambda Ausdruck in Methoden Aufruf: anonymes Objekt als Lambda ***** //
        forum.aufnehmen(() -> "Java ist genial!", "PHP-Programmierer");

        // ***** verkürzter Lambda Ausdruck: MethodenReferenz ***** //
        forum.aufnehmen(Main::wissenErfragen, "Ein schlauer Kopf!");

        System.out.println();
        forum.alleDiskutieren();
        forum.denken();
    }

    /**
     * Hilfsmethode für den Lambda-Ausdruck
     * @return das Wissen des Users
     */
    public static String wissenErfragen() {
        Scanner leser = new Scanner(System.in);
        System.out.println("Was ist dir wichtig, was möchtest du dem Forum mitteilern?");
        String wissen = leser.nextLine() + "!";
        return wissen;
    }

    public static void demonstrierenMathodenRefrenz() {
        ActionListener meinHandler = event -> System.out.println(event);
        meinHandler = System.out::println;
    }
}
