/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pubblicitamauri_bot;

/**
 *
 * @author Payd3r
 */
public class Pubblicita {

    String nome;
    String descrizione;
    String citta;
    double lat, lon, raggio;

    public Pubblicita() {
        nome = "";
        descrizione = "";
        lat = 0D;
        lon = 0D;
        raggio = 0D;
    }

    public Pubblicita(String nome, String descrizione, String citta, double lat, double lon, double raggio) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.citta = citta;
        this.lat = lat;
        this.lon = lon;
        this.raggio = raggio;
    }

    public String toCSV() {
        return "Pubblicita%0ATitolo:%20" + nome + "%0ADescrizione:%20" + descrizione + "%0ACitta:%20" + citta;
    }
}
