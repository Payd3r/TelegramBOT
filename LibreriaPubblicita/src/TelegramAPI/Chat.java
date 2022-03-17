/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramAPI;

/**
 *
 * @author mauri_andrea
 */
public class Chat {

    public int id;
    String first_name;
    String last_name;
    public String username;
    String type;

    public Chat() {
    }

    public Chat(int id, String first_name, String last_name, String username, String type) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.type = type;
    }

    @Override
    public String toString() {
        return id + "\n" + first_name + "\n" + last_name + "\n" + username + "\n" + type;
    }

}
