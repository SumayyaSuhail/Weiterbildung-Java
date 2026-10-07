package de.geheimagent;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket verbindung = new Socket("localhost", 5858);
        BufferedReader dekoLeser = new BufferedReader(new InputStreamReader(verbindung.getInputStream()));

        System.out.println("Der Server sagt: ");
        for (int i = 0; i < 3; i++) {
            System.out.println(dekoLeser.readLine()); // vom Server);
        }
        System.out.println("Gib CodeNummer ein: ");
        Scanner konsolenLeser = new Scanner(System.in);
        String codeNummer = konsolenLeser.nextLine();

        PrintWriter dekoSchreiber = new PrintWriter(new OutputStreamWriter(verbindung.getOutputStream()));
        dekoSchreiber.println(codeNummer);
        dekoSchreiber.flush();

        System.out.println("Server Wünscht: " + dekoLeser.readLine());
    }
}
