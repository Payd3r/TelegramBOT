/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author mauri_andrea
 */
public class KeyAPI {

    String KEY;

    public KeyAPI(String KEY) {
        this.KEY = KEY;
    }

    public Messages update(Messages m) throws MalformedURLException, IOException {
        m = new Messages();
        String s = "";
        URL url = new URL("https://api.telegram.org/bot" + KEY + "/getupdates");
        InputStream is = url.openConnection().getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line = null;
        while ((line = reader.readLine()) != null) {
            s += line + "\n";
        }
        reader.close();
        m.fromJSON(s);
        return m;
    }

    public Messages updateOffset(Messages m, Long offset) throws MalformedURLException, IOException {
        m = new Messages();
        String s = "";
        URL url = new URL("https://api.telegram.org/bot" + KEY + "/getupdates?offset=" + offset);
        InputStream is = url.openConnection().getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line = null;
        while ((line = reader.readLine()) != null) {
            s += line + "\n";
        }
        reader.close();
        m.fromJSON(s);
        return m;
    }

    public void invia(int chat, String mess) throws MalformedURLException, IOException {
        URL url = new URL("https://api.telegram.org/bot" + KEY + "/sendMessage?chat_id=" + chat + "&text=" + mess);
        url.openStream();
    }

    public void inviaMappa(int id, Double latitudine, Double longitudine) throws MalformedURLException, IOException {
        URL Url = new URL("https://api.telegram.org/bot" + KEY + "/sendLocation?chat_id=" + id + "&latitude=" + latitudine + "&longitude=" + longitudine);
        Url.openStream();
    }
}
