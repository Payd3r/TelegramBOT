/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramAPI;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author mauri_andrea
 */
public class Messages {

    public ArrayList<Message> lista;
    int utenti;

    public Messages() {
        lista = new ArrayList<Message>();
    }

    public void addMessage(Message m) {
        lista.add(m);
    }

    public void fromJSON(String s) {
        JSONObject obj = new JSONObject(s);
        JSONArray arr = obj.getJSONArray("result");
        for (int i = 0; i < arr.length(); i++) {
            int message_id = arr.getJSONObject(i).getJSONObject("message").getInt("message_id");
            JSONObject tempFrom = arr.getJSONObject(i).getJSONObject("message").getJSONObject("from");
            From from = new From(tempFrom.getLong("id"),
                    tempFrom.getBoolean("is_bot"),
                    tempFrom.getString("first_name"),
                    tempFrom.getString("last_name"),
                    tempFrom.getString("username"),
                    tempFrom.getString("language_code"));
            JSONObject tempChat = arr.getJSONObject(i).getJSONObject("message").getJSONObject("chat");
            Chat chat = new Chat(tempChat.getLong("id"),
                    tempChat.getString("first_name"),
                    tempChat.getString("last_name"),
                    tempChat.getString("username"),
                    tempChat.getString("type"));
            Long date = arr.getJSONObject(i).getJSONObject("message").getLong("date");
            String text = arr.getJSONObject(i).getJSONObject("message").getString("text");
            this.addMessage(new Message(message_id, from, chat, date, text));
        }
    }

    public String controlla() {
        if (cercaCitta(lista.get(lista.size() - 1))) {
            return correggi(lista.get(lista.size() - 1).text.substring(7, lista.get(lista.size() - 1).text.length()));
        }
        return "";
    }

    public String correggi(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                s = s.substring(0, i) + "+" + s.substring(i + 1);
            }
        }
        return s;
    }

    public boolean cercaCitta(Message temp) {
        if (temp.text.charAt(0) == '/') {
            if ("citta".equals(temp.text.substring(1, 6))) {
                return true;
            }
        }
        return false;
    }

    @Override

    public String toString() {
        String s = "\n------------------------\nElenco dei messaggi:\n";
        for (int i = 0; i < lista.size(); i++) {
            s += lista.get(i).toString();
        }
        return s;
    }
}
