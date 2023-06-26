package org.example;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {

    private String[] arr;


    public StringListImpl() {
        this.arr = new String[]{};
    }

    @Override
    public String add(String item) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (arr.length >= index || index < 0) {
            arr = Arrays.copyOf(arr, arr.length + 1);
            for (int i = arr.length - 1; i >= index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index - 1] = item;
            return item;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String set(int index, String item) {
        if (arr.length >= index && index > 0) {
            arr[index - 1] = item;
            return item;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String remove(String item) {
        int length = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(item)) {
                if (i != arr.length - 1) {
                    for (int j = i; j < arr.length - 1; j++) {
                        arr[j] = arr[j + 1];
                    }
                }
                arr = Arrays.copyOf(arr, arr.length - 1);
                break;
            }
        }
        if (length > arr.length) {
            return item;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String remove(int index) {
        if (arr.length - 1 >= index && index > 0) {
            if (index != arr.length - 1) {
                for (int j = index; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
            }
            String deleteElement = arr[index];
            arr = Arrays.copyOf(arr, arr.length - 1);
            return deleteElement;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean contains(String item) {
        boolean result = false;
        for (String s : arr) {
            if (s.equals(item)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public int indexOf(String item) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(String item) {
        int index = -1;
        for (int i = arr.length - 1; i == 0; i--) {
            if (arr[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public String get(int index) {
        if (index <= arr.length - 1 && index > 0) {
            return arr[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList != null) {
            return Arrays.equals(arr, otherList.toArray());
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public boolean isEmpty() {
        return arr.length != 0;
    }

    @Override
    public void clear() {
        arr = Arrays.copyOf(arr, 0);
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(arr, arr.length);
    }
}
