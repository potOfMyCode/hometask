package queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {

    private static int head = 0;
    private static int tail = 0;

    public static void main(String[] args) {
        int[] queue = new int[12];

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

    public static void enQueue(int[] q, int x){
        if (over()){
            throw new StackOverflowError();
        }
        q[tail] = x;
        if (tail == q.length)
                tail = 0;
        else tail++;
    }

    public static int deQueue(int[] q){
        int x = q[head];
        if (head == q.length)
            head = 0;
        else head++;
        return x;
    }

    public static boolean isEmpty(){
        return tail == head;
    }

    public static boolean over(){
        return tail == head - 1;
    }

    public static void show(int[] q){
        System.out.println("head: "+ head + " tail: "+ tail);
        for(int i: q){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
