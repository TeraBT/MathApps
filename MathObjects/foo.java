package MathObjects;

import java.util.ArrayList;
import java.util.List;

public class foo {
    public static void change(List<Integer> list) {
        list.set(0, 7);
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        foo.change(list);
        System.out.println(list.get(0));

    }
}
