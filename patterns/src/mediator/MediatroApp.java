package mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatroApp {
    public static void main(String[] args) {
        TextChat chat = new TextChat();
        User admin = new AdminUser(chat, "admin");
        User user1 = new SimpleUser(chat, "Dima");
        User user2 = new SimpleUser(chat, "Vasya");
        User user3 = new SimpleUser(chat, "Sasha");

        user1.setEnable(false);

        chat.setAdmin(admin);
        chat.addUsers(user1);
        chat.addUsers(user2);
        chat.addUsers(user3);

        user1.sendMessage("I'm Dima");
        System.out.println();
        user2.sendMessage("I'm Vasya");
        System.out.println();
        admin.sendMessage("I'm admin!");

    }
}
interface Chat{
    void sendMessage(String message, User user);
}
abstract class User{
    private Chat chat;
    private String name;
    private boolean enable = true;
    User(Chat chat, String name){
        this.chat = chat;
        this.name = name;
    }
    abstract void getMessage(String message, User user);

    void setEnable(boolean enable) {
        this.enable = enable;
    }

    boolean isEnable() {
        return enable;
    }

    void sendMessage(String message) {
        chat.sendMessage(message, this);
    }
    String getName() {
        return name;
    }
}
class AdminUser extends User{
    private Chat chat;
    AdminUser(Chat chat, String name){
        super(chat, name);
    }
    public void getMessage(String message, User user) {
        System.out.println("Admin " +getName() + " get message from "+user.getName()+": " + message);
    }
}
class SimpleUser extends User{
    private Chat chat;
    SimpleUser(Chat chat, String name){
        super(chat, name);
    }
    public void getMessage(String message, User user) {
        System.out.println("User " +getName() + " get message from "+user.getName()+": " + message);
    }
}
class TextChat implements Chat{
    private User admin;
    private List<User> users = new ArrayList<>();
    void setAdmin(User admin) {
        this.admin = admin;
    }
    void addUsers(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User user) {
        if(  user != admin && admin.isEnable())
            admin.getMessage(message, user);
        for(User u: users){
            if((user == admin || u.isEnable()) && u!=user  )
                u.getMessage(message, user);
        }
    }
}
