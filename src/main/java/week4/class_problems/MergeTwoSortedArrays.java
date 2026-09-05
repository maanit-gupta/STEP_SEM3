package week4.class_problems;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return new int[]{};
        }
        if (arr1 == null) {
            return arr2.clone();
        }
        if (arr2 == null) {
            return arr1.clone();
        }

        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        System.out.println(Arrays.toString(mergeSortedArrays(arr1, arr2)));

        int[] arr3 = {};
        int[] arr4 = {1, 2, 3};
        System.out.println(Arrays.toString(mergeSortedArrays(arr3, arr4)));
    }
}
