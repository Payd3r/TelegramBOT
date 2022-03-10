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
public class From {

    Long id;
    boolean is_bot;
    String first_name;
    String last_name;
    String username;
    String language_code;

    public From() {
    }

    public From(Long id, boolean is_bot, String first_name, String last_name, String username, String language_code) {
        this.id = id;
        this.is_bot = is_bot;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.language_code = language_code;
    }

    @Override
    public String toString() {
        return id + "\n" + is_bot + "\n" + first_name + "\n" + last_name + "\n" + username + "\n" + language_code;
    }
}
