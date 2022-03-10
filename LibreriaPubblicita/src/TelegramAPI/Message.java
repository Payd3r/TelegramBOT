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

    int message_id = 1;
    From from = new From();
    Chat chat = new Chat();
    Long date = 0L;
    String text = "";

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

    @Override
    public String toString() {
        return this.message_id + "\n" + from.toString() + "\n" + chat.toString() + "\n" + this.date + "\n" + this.text + "\n-----------------------------------\n";
    }
}
