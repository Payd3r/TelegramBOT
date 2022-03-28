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

    public Long update_id = 0L;
    public Long message_id = 0L;
    public From from = new From();
    public Chat chat = new Chat();
    public Long date = 0L;
    public String text = "";

    Message() {
        update_id = 0L;
        message_id = 0L;
        from = new From();
        chat = new Chat();
        date = 0L;
        text = "";
    }

    Message(Long update, Long a, From b, Chat c, Long d, String e) {
        update_id = update;
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
        return this.update_id + "\n" + this.message_id + "\n" + from.toString() + "\n" + chat.toString() + "\n" + this.date + "\n" + this.text + "\n-----------------------------------\n";
    }
}
