package queue;

import java.util.LinkedList;
import java.util.List;

public class QueueList {

    private static int head = 0;
    private static int tail = 0;

    public static void main(String[] args) {
        List queue = new LinkedList();

        enQueue(queue,8);
        enQueue(queue,9);
        enQueue(queue,2);
        enQueue(queue,5);
        enQueue(queue,11);

        show(queue);

        System.out.println();
        deQueue(queue);
        deQueue(queue);

        show(queue);

    }
    public static void enQueue(List q, int x){
        if (over()){
            throw new StackOverflowError();
        }
        q.add(x);
        if (tail == q.size())
            tail = 0;
        else tail++;
    }

    public static int deQueue(List q){
        int x = (int)q.get(head);
        q.remove(head);
        if (head == q.size())
            head = 0;
        return x;
    }

    public static boolean isEmpty(){
        return tail == head;
    }

    public static boolean over(){
        return tail == head - 1;
    }

    public static void show(List q){
        System.out.println("head: "+ head + " tail: "+ tail);
        System.out.println(q);
    }

}
