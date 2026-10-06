package de.bond.agent;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * <pre>
 *     Erstellt ein Verbindung zu einem Server im Netzwerk: Adresse und Port.
 *
 *     Hier wird die Info vom Server gelesen
 * </pre>
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket verbindung = new Socket("localhost", 5858);
        BufferedReader dekoLeser = new BufferedReader(new InputStreamReader(verbindung.getInputStream()));

        System.out.println("Der Server sagt: " + dekoLeser.readLine()); // vom Server
        System.out.println("Welchen Service soll der Server durchführen?");
        Scanner konsolenLeser = new Scanner(System.in);
        String wunschService = konsolenLeser.nextLine();

        PrintWriter dekoSchreiber =
                new PrintWriter(new OutputStreamWriter(verbindung.getOutputStream()));

        dekoSchreiber.println(wunschService); //Schickt an den Server
        dekoSchreiber.flush();
    }
}
