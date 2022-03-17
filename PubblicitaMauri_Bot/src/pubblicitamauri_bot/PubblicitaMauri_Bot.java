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
        ThreadRefresh tr = new ThreadRefresh(m, API);
        tr.start();
    }
}
