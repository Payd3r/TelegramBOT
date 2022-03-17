/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramAPI;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author mauri_andrea
 */
public class Message {

    public int message_id = 1;
    public From from = new From();
    public Chat chat = new Chat();
    public Long date = 0L;
    public String text = "";

    Message() {
        message_id = 0;
        from = new From();
        chat = new Chat();
        date = 0L;
        text = "";
    }

    Message(int a, From b, Chat c, Long d, String e) {
        message_id = a;
        from = b;
        chat = c;
        date = d;
        text = e;
    }

    public String getCitta() {
        return text.substring(7, text.length());
    }

    @Override
    public String toString() {
        return this.message_id + "\n" + from.toString() + "\n" + chat.toString() + "\n" + this.date + "\n" + this.text + "\n-----------------------------------\n";
    }
}
