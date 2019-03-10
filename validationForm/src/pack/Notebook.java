package pack;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
    private ArrayList<Record> listOfPerson = new ArrayList<>();

    public void addRecord(Record rec) {
        listOfPerson.add(rec);
    }
    public List<Record> getRecordsList() {
        return listOfPerson;
    }

    public boolean isContainSuchLogin(String login){
        for(Record rec: listOfPerson){
            if(rec.getLogin().equalsIgnoreCase(login)){
                return true;
            }
        }
        return false;
    }
}
