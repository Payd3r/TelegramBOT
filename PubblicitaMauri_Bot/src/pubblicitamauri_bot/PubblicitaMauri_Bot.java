/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubblicitamauri_bot;

import TelegramAPI.*;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.json.*;

/**
 *
 * @author mauri_andrea
 */
public class PubblicitaMauri_Bot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        KeyAPI API = new KeyAPI("5261244183:AAFF33J7LdUOPxORefpVEhMjCLrDQz82erA");
        Messages m = API.inizializza(new Messages());
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("------> Menu <------");
            System.out.println("1) Stampa messaggi");
            System.out.println("2) Invia messaggio");
            System.out.println("3) Esci");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(m.toString());
                    break;
                case 2:
                    System.out.println("\nScrivere la chat a cui inviare:");
                    int chat = scan.nextInt();
                    System.out.println("\nScrivere il messaggio da inviare:");
                    scan = new Scanner(System.in);
                    String messaggio = scan.nextLine();
                    API.invia(chat, messaggio);                    
                    break;
            }
        } while (choice != 3);
    }
}
