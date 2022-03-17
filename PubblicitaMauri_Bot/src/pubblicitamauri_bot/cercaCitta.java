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
public class cercaCitta {

    Double latitudine;
    Double longitudine;
    String citta;
    int chatId;

    cercaCitta(int a, String c) {
        citta = c;
        latitudine = 0D;
        longitudine = 0D;
        chatId = a;
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

    public int esiste(ArrayList<String> lista) {
        for (int i = 0; i < lista.size(); i++) {
            if (Integer.parseInt(lista.get(i).substring(0, 9)) == chatId) {
                return i;
            }
        }
        return -1;
    }

    public void aggiornaFile() throws FileNotFoundException, IOException {
        ArrayList<String> listaChatId = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        String line = "";
        while ((line = br.readLine()) != null) {
            listaChatId.add(line);
        }
        int pos = esiste(listaChatId);
        if (pos != -1) {
            svuotaFile();
            listaChatId.remove(pos);
            listaChatId.add(this.toCSV());
            FileWriter fw = new FileWriter("file.txt", true);
            for (int i = 0; i < pos; i++) {
                fw.append(listaChatId.get(i));
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
