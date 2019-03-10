package pack;

import static pack.TextConstant.*;
import static pack.RegexContainer.*;

import java.util.Scanner;

public class Notebook {
    private String firstName;
    private String lastName;
    private String login;
    private String password;

    private Scanner scanner;
    private View view;

    Notebook(Scanner scanner, View view){
        this.scanner = scanner;
        this.view = view;
    }

    void inputNote(){
        Model model = new Model(view , scanner);

        String strName = (String.valueOf(View.boundle.getLocale()).equals("ua"))
                ? REGEX_FIRSTNAME_UA : REGEX_FIRSTNAME;
        String strLastname = (String.valueOf(View.boundle.getLocale()).equals("ua"))
                ? REGEX_LASTNAME_UA : REGEX_LASTNAME;

        this.firstName = model.validation(FIRSTNAME , strName);
        this.lastName = model.validation(LASTNAME , strLastname);
        this.login = model.validation(LOGIN , REGEX_LOGIN);
        this.password = model.validation(PASSWORD, REGEX_PASSWORD);

        view.noteCheck(firstName,lastName,login,password);
    }


}
