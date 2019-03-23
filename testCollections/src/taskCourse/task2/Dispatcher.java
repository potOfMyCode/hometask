package taskCourse.task2;


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



        for (int i =0 ; i<list.size(); i++){
                System.out.print(list.get(i)+ " ");
        }
        System.out.println();
        list.remove("pool");
        for (int i =0 ; i<list.size(); i++){
            System.out.print(list.get(i)+ " ");
        }
    }
}
