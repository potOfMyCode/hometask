package pack;

import static pack.TextConstant.*;
import static pack.RegexContainer.*;

import exception.IllegalLogin;
import pack.Notebook;
import sun.plugin2.applet.context.NoopExecutionContext;

import java.util.Scanner;
import pack.Notebook;

public class Record {
    private String firstName;
    private String lastName;
    private String login;
    private String password;

    private Scanner scanner;
    private View view;

    Record(Scanner scanner, View view){
        this.scanner = scanner;
        this.view = view;
    }

    void inputNote(Notebook notebook){
        Model model = new Model(view , scanner);

        String strName = (String.valueOf(View.boundle.getLocale()).equals("ua"))
                ? REGEX_FIRSTNAME_UA : REGEX_FIRSTNAME;
        String strLastname = (String.valueOf(View.boundle.getLocale()).equals("ua"))
                ? REGEX_LASTNAME_UA : REGEX_LASTNAME;


        this.firstName = model.validation(FIRSTNAME , strName);
        this.lastName = model.validation(LASTNAME , strLastname);

        String correcLogin = model.validation(LOGIN , REGEX_LOGIN);
        while(notebook.isContainSuchLogin(correcLogin)){
            view.repeatLogin();
            try {
                throw new IllegalLogin("this login have been used another user");
            }catch(IllegalLogin il){
                il.printStackTrace();
            }
            correcLogin = model.validation(LOGIN , REGEX_LOGIN);
        }
        this.login = correcLogin;

        this.password = model.validation(PASSWORD, REGEX_PASSWORD);

//        view.noteCheck(firstName,lastName,login,password);

    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("-------------------------------------------\n");
        str.append("Name             -> ").append(this.firstName).append("\n");
        str.append("Surname          -> ").append(this.lastName).append("\n");
        str.append("Login            -> ").append(this.login).append("\n");
        str.append("Password         -> ").append(this.password).append("\n");
        return str.toString();
    }

    public String getLogin() {
        return login;
    }
}
