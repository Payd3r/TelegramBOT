/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramAPI;

import org.json.*;

/**
 *
 * @author mauri_andrea
 */
public class test {

    public void hello() {
        String jsonString = "{chiave:'Mario',messaggi:['a','b','c']}"; //assign your JSON String here
        JSONObject obj = new JSONObject(jsonString);
        String v = obj.getString("chiave");
        System.out.println(v);
        JSONArray arr = obj.getJSONArray("messaggi"); // notice that `"posts": [...]`
        for (int i = 0; i < arr.length(); i++) {
            String elementoVett = arr.getString(i);
            System.out.println(elementoVett);
        }
        System.out.println("hello");
    }
}
