package de.bond.zentrale;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * <pre>
 *     Ein Server wartet aus Anfragen, nimmt Anfragen entgegen und antwortet mit
 *     einem Service.
 *
 *     Kommunikation geht vom user (Client) aus.
 *
 *     Stellt Services zur Verfügung:
 *     Email Service: POP3, IMAP, Mercury
 *     File Service: FTP
 *     Webseiten
 *     Print Service
 *     Software as a Service: (SaaS)
 *     Platform as a Service: (PaaS) zb RemotePC
 *
 *     Java Server und Java Client kommunizieren über TCP/IP Verbindungen.
 *     In den Verbindungen sind Datenströme (java.io)
 * </pre>
 */
public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("Hier ist der Java Server");

        ServerSocket lauscher = new ServerSocket(5858);

        while (true) {
            Socket verbindung = lauscher.accept();
            System.out.println("Client hat sich verbunden: " + verbindung.getInetAddress() + ": " + verbindung.getPort());

            OutputStream outputStream = verbindung.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter dekoSchreiber = new BufferedWriter(outputStreamWriter);

            String aktuelleUhrzeit = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            dekoSchreiber.write("Hier ist es gerade " + aktuelleUhrzeit);
            dekoSchreiber.newLine();
            dekoSchreiber.flush();

            BufferedReader dekoLeser = new BufferedReader(new InputStreamReader(verbindung.getInputStream()));
            String wunschService = dekoLeser.readLine();
            System.out.println("Client wünscht: " + wunschService);
        }
    }
}
