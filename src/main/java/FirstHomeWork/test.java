package FirstHomeWork;


import javafx.application.Platform;

import java.util.ArrayList;
import java.util.Arrays;

public class test {

    private static final int numberForSearch = 3;
    private static final int arraySize = 8;
    private static int end;
    private static int start = 0;
    private static int result;

    public static void main(String[] args) {
//        int[] array = new int[arraySize];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = i;
//        }
        int[] array = {1, 3, 4, 4, 7, 8, 9, 9};

        end = array.length;

        while (start <= end) {

            int centre = ((start + end) / 2);

            System.out.println("Start " + start);
            System.out.println("End " + end);

            System.out.println("Centre " + centre + "\n");

            if (numberForSearch > array[centre]) {
                start = centre + 1;
//                index =
            } else if (numberForSearch < array[centre]) end = centre - 1;
            else if (numberForSearch == array[centre]) {
                System.out.println("Индекс в массиве: " + centre);
                result = numberForSearch;
                break;
            }
        }
        if (start > end & result != numberForSearch) {
            System.out.println("Result : this number don`t empty");
        } else System.out.println("Result: " + result);
    }
}

