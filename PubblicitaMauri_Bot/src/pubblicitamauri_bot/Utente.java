/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubblicitamauri_bot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author mauri_andrea
 */
public class Utente {

    Double latitudine;
    Double longitudine;
    String citta;
    int chatId;

    Utente(int a, String c) {
        citta = c;
        latitudine = 0D;
        longitudine = 0D;
        chatId = a;
    }

    Utente(String c) {
        citta = c;
        latitudine = 0D;
        longitudine = 0D;
        chatId = 0;
    }

    Utente(String c, int b) {
        String[] vett = c.split(";");
        citta = "";
        latitudine = Double.parseDouble(vett[1]);
        longitudine = Double.parseDouble(vett[2]);
        chatId = Integer.parseInt(vett[0]);
    }

    public void impostaCoordinate() throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
        URL url = new URL("https://nominatim.openstreetmap.org/search?q=" + citta + "&format=xml&addressdetails=1");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        var document = builder.parse(url.openStream());
        Element root = document.getDocumentElement(), element = null;
        NodeList nList = document.getElementsByTagName("place");
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            element = (Element) node;
            latitudine = Double.parseDouble(element.getAttribute("lat"));
            longitudine = Double.parseDouble(element.getAttribute("lon"));
        }
    }

    public void aggiornaFile() throws FileNotFoundException, IOException {
        Utenti u = Utenti.getUtenti();
        int pos = u.cerca(this);
        if (pos != -1) {
            svuotaFile();
            u.lista.remove(pos);
            u.addUtente(this);
            FileWriter fw = new FileWriter("file.txt", true);
            for (int i = 0; i < u.lista.size(); i++) {
                fw.append(u.lista.get(i).toCSV());
            }
            fw.flush();
            fw.close();
        } else {
            FileWriter writer = new FileWriter("file.txt", true);
            writer.append(this.toCSV());
            writer.flush();
            writer.close();
        }
    }

    public void svuotaFile() throws IOException {
        FileWriter writer = new FileWriter("file.txt");
        writer.write("");
        writer.flush();
        writer.close();
    }

    public String toCSV() {
        return chatId + ";" + latitudine + ";" + longitudine + "\n";
    }

}
