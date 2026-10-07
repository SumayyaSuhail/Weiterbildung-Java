package de.geheimagent;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket lauscher = new ServerSocket(5858);
        System.out.println("Server gestartet, wartet auf Verbindung auf Port 5858....");
        Socket verbindung = lauscher.accept();
        System.out.println("Client hat sich verbunden: " + verbindung.getInetAddress() + ": " + verbindung.getPort());

        BufferedWriter dekoSchreiber = new BufferedWriter(new OutputStreamWriter(verbindung.getOutputStream()));

        String[] auftrag = {"Ihr Ziel ist das CIA-Hauptquartier.",
                "Dort befindet sich ein Computer mit vertraulichen Daten, der Ihre Unschuld beweisen kann.",
                "Beschaffen Sie diesen Computer und bringen Sie ihn zum Treffpunkt"};
        for(String text:auftrag) {
            dekoSchreiber.write(text);
            dekoSchreiber.newLine();
        }
        dekoSchreiber.flush();

        BufferedReader dekoLeser = new BufferedReader(new InputStreamReader(verbindung.getInputStream()));
        String codeNummer = dekoLeser.readLine();
        System.out.println("CodeNummer von Client: " + codeNummer);

        if(codeNummer.equals("008")) {
            dekoSchreiber.write("Viel Erfolg!");

        } else {
            dekoSchreiber.write("Tschusss!!");
        }
        dekoSchreiber.newLine();
        dekoSchreiber.flush();
    }
}
