package pack;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] array = {1,5,0,7,2,3,0,4};

        Arrays.stream(array).forEach(p -> System.out.print(p+ " "));
        System.out.println();

        double avarege = Arrays.stream(array).average().getAsDouble();
        System.out.println("Avarage: " + avarege);

        int min = Arrays.stream(array).min().getAsInt();
        IntStream.range(0,array.length).forEach(i -> {
            if (array[i]==min)
                System.out.println("min element: " + array[i] + " index: " + i);
        } );

        long countNull = Arrays.stream(array).filter(p -> p == 0).count();
        System.out.println("Null element: " + countNull);

        long moreThanNull = Arrays.stream(array).filter(p -> p > 0).count();
        System.out.println("More than null element: " + moreThanNull);

        IntStream.range(0, array.length).map(i -> array[i] *=5).forEach(p -> System.out.print(p+ " "));
    }
}
