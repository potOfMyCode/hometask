package list;

import java.util.Iterator;

public class Dispatcher {

    private static int head = 0;
    private static int tail = 0;

    static LinkedList queue = new LinkedList();

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("smurfik");
        list.add("marss");
        list.add("snikers");
        list.add("pool");
        list.add("rose");
        list.add("lie");
        list.add("ring");

        System.out.println(list);

        Iterator<String> iterator =list.iterator();
        String element = iterator.next();



        boolean flag = true;

        while(iterator.hasNext()){
            if( element.length() % 2 !=0){

                if(flag){
                    element = element.substring(1, element.length() - 1);
                    String temp1 = "";
                    String temp2 = "";
                    String temp3 = "";
                    temp1 = element.substring(0,1);
                    temp2 = element.substring(1,element.length() - 1);
                    temp3 = element.substring(element.length() - 1 ,element.length() );
                    String result = temp3 + temp2 + temp1;
                    element = result;
                    System.out.print(element + " ");
                    flag = false;
                }else {
                    System.out.print(element.substring(1, element.length() - 1) + " ");
                }
            }
            element = iterator.next();
        }


        System.out.println();
        System.out.println("==============================================!");
        System.out.println();



        enQueue(queue,8);
        enQueue(queue,9);
        enQueue(queue,2);
        enQueue(queue,5);
        enQueue(queue,11);

        show(queue);


        deQueue(queue);
        deQueue(queue);

        show(queue);
    }

    public static void enQueue(LinkedList q, int x){
        if (over()){
            throw new StackOverflowError();
        }
        q.add(x);
        if (tail == q.size())
            tail = 0;
        else tail++;
    }

    public static void deQueue(LinkedList q){
        q.rem(q.first);
        tail--;
    }

    public static boolean isEmpty(){
        return tail == head;
    }

    public static boolean over(){
        return tail == head - 1;
    }

    public static void show(LinkedList q){
        System.out.println("head: "+ head + " <-> tail: "+ tail);
        System.out.println("headReal: " + q.first + " <-> tailReal: " + q.last);
        System.out.println(q);
    }
}
