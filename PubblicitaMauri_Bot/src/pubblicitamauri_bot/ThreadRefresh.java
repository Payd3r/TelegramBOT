/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pubblicitamauri_bot;

import TelegramAPI.KeyAPI;
import TelegramAPI.Message;
import TelegramAPI.Messages;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Payd3r
 */
public class ThreadRefresh extends Thread {

    Messages nuovo, vecchio;
    KeyAPI API;

    public ThreadRefresh(Messages m, KeyAPI API) throws IOException {
        this.nuovo = m;
        this.API = API;
        vecchio = API.update(new Messages());
    }

    public String correggi(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                s = s.substring(0, i) + "+" + s.substring(i + 1);
            }
        }
        return s;
    }

    public boolean isCitta(Message temp) {
        if (temp.text.charAt(0) == '/') {
            if ("citta".equals(temp.text.substring(1, 6))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void run() {
        while (true) {
            try {
                nuovo = API.update(nuovo);
                if (nuovo.lista.size() != vecchio.lista.size()) {
                    Message temp = nuovo.lista.get(nuovo.lista.size() - 1);
                    vecchio = API.update(vecchio);
                    if (isCitta(temp)) {
                        cercaCitta cerca = new cercaCitta(temp.chat.id, correggi(nuovo.lista.get(nuovo.lista.size() - 1).getCitta()));
                        cerca.impostaCoordinate();
                        System.out.println("Chat: " + cerca.chatId + "\nUser: " + temp.chat.username + "\nLat: " + cerca.latitudine + "\nLon: " + cerca.longitudine);
                        API.inviaMappa(cerca.chatId, cerca.latitudine, cerca.longitudine);
                        cerca.aggiornaFile();
                    }

                }
                Thread.sleep(300);
            } catch (IOException ex) {
                Logger.getLogger(ThreadRefresh.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadRefresh.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(ThreadRefresh.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(ThreadRefresh.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
