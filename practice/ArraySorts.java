package practice;

import java.util.Arrays;

public class ArraySorts {
    public static void main(String[] args) {
        int[] arr1 = {1, -5, 2, 4, 3};
        int[] arr2 = {2, 1, 1, 3, 2, 5, 4};
        int[] arr3 = {6, 1, 7};

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));

    }
}
