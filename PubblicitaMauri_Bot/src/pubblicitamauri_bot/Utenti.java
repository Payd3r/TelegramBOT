/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pubblicitamauri_bot;

import TelegramAPI.Message;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Payd3r
 */
public class Utenti {

    private static Utenti istanza = null;
    public ArrayList<Utente> lista;

    public static synchronized Utenti getUtenti() throws IOException {
        if (istanza == null) {
            istanza = new Utenti();
        }
        return istanza;
    }

    public Utenti() throws IOException {
        lista = new ArrayList<Utente>();
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        String line = "";
        while ((line = br.readLine()) != null) {
            this.addUtente(new Utente(line, 0));
        }
        br.close();
    }

    public void addUtente(Utente a) {
        lista.add(a);
    }

    public int cerca(Utente u) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).chatId == u.chatId) {
                return i;
            }
        }
        return -1;
    }

}
