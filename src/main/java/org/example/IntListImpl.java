package org.example;

import java.util.Arrays;

public class IntListImpl implements IntList {
    private Integer[] arr2;

    public IntListImpl() {
        this.arr2 = new Integer[]{};
    }

    public void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    @Override
    public Integer add(Integer item) {
        validateItem(item);
        arr2 = Arrays.copyOf(arr2, arr2.length + 1);
        arr2[arr2.length - 1] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        if (index == arr2.length - 1) {
            add(item);
            return item;
        }
        System.arraycopy(arr2, index, arr2, index + 1, arr2.length - index);
        arr2[index] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        arr2[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = arr2[index];
        if (index != arr2.length - 1) {
            System.arraycopy(arr2, index + 1, arr2, index, arr2.length-index);
        }
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) != -1;
    }

    public boolean contains(int[] arr, int element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = arr2.length - 1; i >= 0; i--) {
            if (arr2[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return arr2[index];
    }

    @Override
    public boolean equals(IntList otherList) {
        return Arrays.equals(arr2, otherList.toArray());
    }

    @Override
    public int size() {
        return arr2.length;
    }

    @Override
    public boolean isEmpty() {
        return arr2.length == 0;
    }

    @Override
    public void clear() {
        arr2 = Arrays.copyOf(arr2, 0);
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(arr2, arr2.length);
    }

    public void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    public void validateIndex(int index) {
        if (index < 0 || index > arr2.length - 1) {
            throw new InvalidIndexException();
        }
    }

}
