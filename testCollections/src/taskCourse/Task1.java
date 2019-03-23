package taskCourse;

import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        int[] array = new int[]{4,5,-6,4,5,3,4,2,4,5,7};
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(Integer i : array){
            Integer count = hashMap.get(i);
            hashMap.put(i, count == null ? 1 : ++count);
        }
        hashMap.forEach((key, value)-> System.out.println(key + " - " + value));
    }
}
