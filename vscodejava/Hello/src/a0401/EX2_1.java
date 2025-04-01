package a0401;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EX2_1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","b","c","d","e","f");
        List<String> list1 = new ArrayList<>();
            list1.add("a");
            list1.add("b");
            list1.add("c");
            list1.add("d");

            list.stream().forEach(System.out::print);
    }
}
