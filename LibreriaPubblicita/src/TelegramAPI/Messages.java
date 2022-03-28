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

    public Messages() {
        lista = new ArrayList<Message>();
    }

    public void addMessage(Message m) {
        lista.add(m);
    }

    public boolean fromJSON(String s) {
        JSONObject obj = new JSONObject(s);
        JSONArray arr = obj.getJSONArray("result");
        for (int i = 0; i < arr.length(); i++) {
            Long update_id = arr.getJSONObject(i).getLong("update_id");
            Long message_id = arr.getJSONObject(i).getJSONObject("message").getLong("message_id");
            JSONObject tempFrom = arr.getJSONObject(i).getJSONObject("message").getJSONObject("from");
            From from;
            try {
                from = new From(tempFrom.getLong("id"),
                        tempFrom.getBoolean("is_bot"),
                        tempFrom.getString("first_name"),
                        tempFrom.getString("last_name"),
                        tempFrom.getString("username"),
                        tempFrom.getString("language_code"));
            } catch (Exception e) {
                from = new From(tempFrom.getLong("id"),
                        tempFrom.getBoolean("is_bot"),
                        tempFrom.getString("first_name"),
                        tempFrom.getString("last_name"),
                        tempFrom.getString("first_name") + "_" + tempFrom.getString("last_name"),
                        tempFrom.getString("language_code"));
            }
            JSONObject tempChat = arr.getJSONObject(i).getJSONObject("message").getJSONObject("chat");
            Chat chat;
            try {
                chat = new Chat(tempChat.getInt("id"),
                        tempChat.getString("first_name"),
                        tempChat.getString("last_name"),
                        tempChat.getString("username"),
                        tempChat.getString("type"));
            } catch (Exception e) {
                chat = new Chat(tempChat.getInt("id"),
                        tempChat.getString("first_name"),
                        tempChat.getString("last_name"),
                        tempChat.getString("first_name") + "_" + tempChat.getString("last_name"),
                        tempChat.getString("type"));
            }
            Long date = arr.getJSONObject(i).getJSONObject("message").getLong("date");
            String text = "";
            try {
                text = arr.getJSONObject(i).getJSONObject("message").getString("text");
            } catch (Exception e) {
                return false;
            }
            this.addMessage(new Message(update_id, message_id, from, chat, date, text));
        }
        return true;
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
