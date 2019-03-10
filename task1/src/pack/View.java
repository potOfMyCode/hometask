package pack;

public class View {
    void hello_request(){
        System.out.println("Please enter the world : \"Hello\"");
    }

    void world_request(){
        System.out.println("Please enter the world: \"World!\"");
    }

    void error(){
        System.out.println("Incorrect! Please try again.");
    }

    void success(String text){
        System.out.println("Congratulations! Your sentence is: " + text);
    }
}
