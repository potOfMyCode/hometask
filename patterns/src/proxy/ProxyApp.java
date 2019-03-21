package proxy;

public class ProxyApp {
    public static void main(String[] args) {
        Image image = new ProxyImage("C:/data/img.png");
        image.display();

    }
}
interface Image{
    void display();
}
class RealImage implements Image{
    private String file;
    RealImage(String file){
        this.file = file;
        load();
    }
    void load(){
        System.out.println("load image");
    }
    public void display() {
        System.out.println("show image");
    }
}
class ProxyImage implements Image{
    private RealImage realImage;
    private String file;
    ProxyImage(String file){
        this.file = file;
    }
    public void display() {
        if (realImage==null)
            realImage = new RealImage(file);
        realImage.display();
    }
}


