package stack;

public class Stack {

    private static int top;

    public static void main(String[] args) {
        int[] stack = new int[12];

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
        show(stack);

        push(stack, 5);
        push(stack, 2);
        show(stack);
        calculate(stack ,2);
        show(stack);

        push(stack, 1);
        show(stack);
        calculate(stack ,2);
        show(stack);

        push(stack, 2);
        show(stack);
        calculate(stack ,4);
        show(stack);

        push(stack, 3);
        push(stack, -1);
        show(stack);
        calculate(stack ,3);
        show(stack);

        calculate(stack ,2);
        show(stack);
    }

    public static boolean isEmpty(){
        return top == 0;
    }

    public static void push(int[] s, int x){
        top++;
        s[top] = x;
    }

    public static int pop(int[] s) {
        if (isEmpty()) {
            throw new RuntimeException();
        } else {
            top--;
            return s[top + 1];
        }
    }

    public static void show(int[] s){
        System.out.println("top is: " + top);
        for(int i: s){
            System.out.print(i+ " ");
        }
        System.out.println();
        System.out.println();
    }

    public static int calculate(int[] s, int op){
        int result = 0;
        if (op == 1){
            result = s[top-1] + s[top];
            pop(s);
            pop(s);
            push(s , result);
        }
        if (op == 2){
            result = s[top-1] - s[top];
            pop(s);
            pop(s);
            push(s , result);
        }
        if (op == 3){
            result = s[top-1] * s[top];
            pop(s);
            pop(s);
            push(s , result);
        }
        if (op == 4){
            result = s[top-1] / s[top];
            pop(s);
            pop(s);
            push(s , result);
        }
        return result;
    }
}
