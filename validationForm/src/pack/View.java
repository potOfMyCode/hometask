package pack;

import com.sun.net.httpserver.Authenticator;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    public static final ResourceBundle boundle = ResourceBundle.getBundle(
            "messages", //new Locale("ua", "UA"));
                                    new Locale("en"));


    public void printMessage(String message){
        System.out.println(message);
    }

    public String concatencate(String... str){
        StringBuilder concat = new StringBuilder();
        for(String s : str) {
            concat = concat.append(s);
        }
        return new String(concat);
    }

    public void printStringInput(String message, String regex){
        printMessage(concatencate(
                boundle.getString("input.start.text"),
                boundle.getString(message),
                " in format: ",
                regex));
    }

    public void printWrongInput(String message){
        printMessage(concatencate(
                boundle.getString("input.incorrect.data"),
                boundle.getString("input.start.text"),
                boundle.getString(message)
        ));
    }

    public void noteCheck(String firstname, String lastname, String login, String password){
        printMessage(concatencate(
                "Your information:", "\n",
                firstname, "\n",
                lastname, "\n",
                login, "\n",
                password
        ));
    }
}
