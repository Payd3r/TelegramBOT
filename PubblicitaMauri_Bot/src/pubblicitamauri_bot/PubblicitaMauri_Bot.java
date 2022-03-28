/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubblicitamauri_bot;

import TelegramAPI.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.json.*;
import org.xml.sax.SAXException;

/**
 *
 * @author mauri_andrea
 */
public class PubblicitaMauri_Bot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, MalformedURLException, ParserConfigurationException, SAXException {
        KeyAPI API = new KeyAPI("5261244183:AAFF33J7LdUOPxORefpVEhMjCLrDQz82erA");
        Messages m = API.update(new Messages());
        Utenti u = Utenti.getUtenti();
        ThreadRefresh tr = new ThreadRefresh(m, API);
        tr.start();
        inizializzaPubblicita(API, u);
    }

    public static void inizializzaPubblicita(KeyAPI API, Utenti u) throws IOException, MalformedURLException, ParserConfigurationException, SAXException {
        int scelta = 0;
        Scanner s = new Scanner(System.in);
        Pubblicita p = new Pubblicita();
        do {
            menu();
            scelta = s.nextInt();
            switch (scelta) {
                case 0:
                    System.out.println("\nNuova pubblicita");
                    s.nextLine();
                    System.out.print("Inserisci nome pubblicita:");
                    String nome = s.nextLine();
                    System.out.print("Inserisci descrizione pubblicita:");
                    String descrizione = s.nextLine();
                    System.out.print("Inserisci citta:");
                    String citta = s.nextLine();
                    Utente cerca = new Utente(citta);
                    cerca.impostaCoordinate();
                    System.out.print("Inserisci raggio:");
                    double raggio = s.nextInt();
                    p = new Pubblicita(nome, descrizione, citta, cerca.latitudine, cerca.longitudine, raggio);
                    System.out.println("\nPubblicita inserita!");
                    break;
                case 1:
                    //invio pubblicita                    
                    for (int i = 0; i < u.lista.size(); i++) {
                        double distanza = getDistance(p.lat, p.lon, u.lista.get(i).latitudine, u.lista.get(i).longitudine);
                        if (distanza < p.raggio) {
                            API.invia(u.lista.get(i).chatId, p.toCSV());
                            System.out.println("\nPubblicita inviata a " + u.lista.get(i).chatId);
                        }
                    }
                    break;
                case 2:
                    if (p.nome != "") {
                        System.out.println("nome: " + p.nome);
                        System.out.println("descrizione: " + p.descrizione);
                        System.out.println("latitudine: " + p.lat);
                        System.out.println("longitudine: " + p.lon);
                        System.out.println("raggio: " + p.raggio);
                    } else {
                        System.out.println("Nessuna pubblicita creata!");
                    }
                    break;
                case 3:
                    System.out.println("Esci");
                    break;
            }
        } while (scelta != 3);
    }

    public static void menu() {
        System.out.println("-----> menu <-----");
        System.out.println("0) Inserisci pubblicita");
        System.out.println("1) Invia pubblicita");
        System.out.println("2) Visualizza pubblicita");
        System.out.println("3) Esci");
    }

    private static Double getDistance(Double lat1, Double lon1, Double lat2, Double lon2) throws ParserConfigurationException, SAXException, IOException {
        Double R = 6371.0088;
        Double latDistance = Math.toRadians((lat1 - lat2));
        Double lonDistance = Math.toRadians((lon1 - lon2));

        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        Double a = haversin(latDistance) + Math.cos(lat1) * Math.cos(lat2) * haversin(lonDistance);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return Math.abs(R * c);
    }

    private static double haversin(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }
}
