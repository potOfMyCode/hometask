package view;

import model.Salads;
import model.entity.Vegetable;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class View {

    // Resource Bundle Installation's
    static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    new Locale("en", "EN"));  // English
    //new Locale("eu_ua", "UA")); //Ukrainian

    static {
        System.out.println(bundle.getLocale().getLanguage());
    }

    public void printMessage(String... message){
        for(String s : message){
            System.out.print(s+ " ");
        }
        System.out.println();
    }

    public void printMapOfSalads(Map<Salads, List<Vegetable>> myHashMap){
        for(Map.Entry<Salads, List<Vegetable>> entry: myHashMap.entrySet())
            System.out.println(entry.getKey() + ": \n" + entry.getValue());
        System.out.println("---------------------------------------------------------------");
    }
}

