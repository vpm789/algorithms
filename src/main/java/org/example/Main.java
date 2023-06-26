package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringListImpl stringList = new StringListImpl();
        stringList.add("one");
        stringList.add("three");
        stringList.add("four");
        stringList.add(2, "two");
        stringList.set(2, "set_two");
        /*stringList.remove("three");
        stringList.remove(2);
        stringList.clear();*/

    }

}