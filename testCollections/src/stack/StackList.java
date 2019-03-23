package stack;

import java.util.LinkedList;
import java.util.List;

public class StackList {

    private static int top;

    public static void main(String[] args) {
        List stack = new LinkedList();

        push(stack, 5);
        push(stack, 9);
        push(stack, 7);
        push(stack, 3);
        push(stack, 1);

        show(stack);

        pop(stack);
        pop(stack);

        show(stack);

        push(stack, 11);
        push(stack , 12);
        show(stack);
    }

    public static boolean isEmpty(){
        return top == 0;
    }

    public static void push(List s, int x){
        top++;
        if(s.size()>= top) {
            s.set(top - 1, x);
        }else{
            s.add(x);
        }

    }

    public static int pop(List s) {
        if (isEmpty()) {
            throw new RuntimeException();
        } else {
            top--;
            return (int)s.get(top);
        }
    }

    public static void show(List s){
        System.out.println("top is: " + top);
        System.out.println(s);
        System.out.println();
    }
}
