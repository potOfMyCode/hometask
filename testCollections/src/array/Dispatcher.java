package array;


public class Dispatcher {
    public static void main(String[] args) {

        MyArrayList<String> list = new MyArrayList<>();
        list.add("smurfik");
        list.add("marss");
        list.add("snikers");
        list.add("pool");
        list.add("rose");
        list.add("lie");
        list.add("ring");
        list.add("add");

//        for(int i =0; i<list.size(); i++){
//            System.out.println((String[])list.getA()[i]);
//        }

        System.out.print(list + " ");
        System.out.println();

        for (int i =0 ; i<list.size(); i++){
            if(list.get(i).length() % 2 !=0){
                System.out.print(list.get(i).substring(1,list.get(i).length()-1)+ " ");
            }
        }
        System.out.println();
    }

    public static void show(String[] m){
        for(String s: m){
            System.out.print(s+ " ");
        }
    }
}
