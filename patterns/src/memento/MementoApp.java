package memento;

public class MementoApp {
    public static void main(String[] args) {
        Game game = new Game();
        game.set("lvl1", 30000);
        System.out.println(game);

        File file = new File();
        file.setSave(game.save());

        game.set("lvl1", 43000);
        System.out.println(game);

        game.load(file.getSave());
        System.out.println(game);
    }
}
class Game{
    private String level;
    private int ms;
    void set(String level, int ms){
        this.level = level;
        this.ms = ms;
    }
    Save save(){
        return new Save(level, ms);
    }
    void load(Save save){
        this.level = save.getLevel();
        this.ms = save.getMs();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+":\n\t" + "level: "+ level + ", time: " + ms;
    }
}
class Save{
    private final String level;
    private final int ms;
    Save(String level, int ms){
        this.level = level;
        this.ms = ms;
    }
    String getLevel() {
        return level;
    }

    int getMs() {
        return ms;
    }
}
class File{
    private Save save;
    void setSave(Save save) {
        this.save = save;
    }
    Save getSave() {
        return save;
    }
}