package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IntListImpl intList = new IntListImpl();


        int[] arr1 = new int[10];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (int) (Math.random() * 10);
        }
        /*long start1 = System.currentTimeMillis();
        intList.sortSelection(arr1);
        System.out.println(System.currentTimeMillis() - start1);*/

        System.out.println(intList.contains(arr1, 5));

        /*intList.add(3);
        intList.add(4);
        intList.add(1);*/

    }

}