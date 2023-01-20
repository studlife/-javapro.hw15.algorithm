package ua.hillel.javapro.algorithm;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        int[] array = new int[] {2, 12, 19, 8, 46, 3, 79, 11, 6, 15, 73};
        int[] array2 = array.clone();

        System.out.println(Arrays.toString(array));

        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));

        shakerSort(array2);
        System.out.println(Arrays.toString(array2));

    }






    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length-1);
    }

    public static void quickSort(int[] array, int positionLeft, int positionRight) {

        if(array.length == 0 || array == null) return;
        if(positionLeft >= positionRight) return;

        int left = positionLeft;
        int right = positionRight;

        int pivot = array[left + (right - left) / 2];

        while(left <= right) {
            while (array[left] < pivot) left++;
            while (array[right] > pivot) right--;

            if(left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
                left++;
                right--;
            }
        }

        quickSort(array, positionLeft, right);
        quickSort(array, left, positionRight);

    }




    public static void shakerSort(int[] array) {

        int start = 0;
        int finish = array.length-1;


        while (start < finish) {

            for (int j = start; j < finish; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
            finish--;

            for (int j = finish; j > start; j--) {
                if (array[j] < array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
            start++;
        }



    }


}