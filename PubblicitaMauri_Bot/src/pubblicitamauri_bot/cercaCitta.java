/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubblicitamauri_bot;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
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

    Long latitudine;
    Long longitudine;
    String citta;

    cercaCitta(String c) {
        citta = c;
        latitudine = 0L;
        longitudine = 0L;
    }

    public void trova() throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
        String s = "";
        URL url = new URL("https://nominatim.openstreetmap.org/search?q=" + citta + "&format=xml&addressdetails=1");
        InputStream is = url.openConnection().getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line = null;
        while ((line = reader.readLine()) != null) {
            s += line + "\n";
        }
        reader.close();
        parsa(s);
    }

    public void parsa(String s) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(s);
        doc.getDocumentElement().normalize();

        NodeList list = doc.getElementsByTagName("place");
        for (int temp = 0; temp < list.getLength(); temp++) {
            Node node = list.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                latitudine = Long.valueOf(element.getAttribute("lat"));
                longitudine = Long.valueOf(element.getAttribute("lon"));
            }
        }
    }

    public void aggiornaFile() {

    }

}
