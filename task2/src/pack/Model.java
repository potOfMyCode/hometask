package pack;

public class Model {
    public static final int X = generateRand();

    static int generateRand(){
        double d = (Math.random()+0.01) * 100;
        int rand = (int)d;
        return rand;
    }
}
