package set;

import java.util.*;

public class TestSet {
    public static void main(String[] args) {
        Set<String> testhashSet = new HashSet<>();
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();
        testhashSet.add("one");
        testhashSet.add("one");
        testhashSet.add("one");
        System.out.println(testhashSet.size());
        testhashSet.add(null);
        System.out.println(testhashSet.size());
        System.out.println();
        hashSet.add("one");
        hashSet.add("two");
        hashSet.add("three");
        hashSet.add("four");
        hashSet.add("five");
        for (String s : hashSet){
            System.out.print(s + " ");
        }
        System.out.println();

        linkedHashSet.add("one");
        linkedHashSet.add("two");
        linkedHashSet.add("three");
        linkedHashSet.add("four");
        linkedHashSet.add("five");
        for (String s : linkedHashSet){
            System.out.print(s + " ");
        }
        System.out.println();

        treeSet.add("one");
        treeSet.add("two");
        treeSet.add("three");
        treeSet.add("four");
        treeSet.add("five");
        for (String s : treeSet){
            System.out.print(s + " ");
        }
        System.out.println();

        HashMap<String, String> myHashMap = new HashMap<String, String>();

        myHashMap.put("Basil", "07.12.1987");
        myHashMap.put("Kate", "12.10.1971");
        myHashMap.put("Lena", "11.01.1991");
        for(Map.Entry<String, String> entry: myHashMap.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue());
    }
}
