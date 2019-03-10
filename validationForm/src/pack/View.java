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

    public void noteCheck(Notebook notebook){
        printMessage(concatencate(
                notebook.getRecordsList().toString()
//                "Your information:", "\n",
//                firstname, "\n",
//                lastname, "\n",
//                login, "\n",
//                password
        ));
    }

    public void registerUser(){
        System.out.println("Do you want to register another user?\n" +
                "if no then print \"no\"" + ", in another case print something and then create new user.");

    }

    public void repeatLogin(){
        System.out.println("Sorry, such login have been used another user. Please try again!");
    }
}
