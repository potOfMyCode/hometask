package pack;

public class Model {
    private String text = "";

    void setText(String text){
        this.text += text;
    }

    String getText(){
        return text;
    }
}
