package ss04_class_object_to_java.excrecise.build_class_stopwatch;

import java.time.LocalTime;

public class OOPStopWatch {

    public static void main(String[] args) {
        int array[] = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }

        LocalTime start = LocalTime.now();
        array = selectionSort(array);
        LocalTime end = LocalTime.now();

        StopWatch stopWatch = new StopWatch(start, end);
        System.out.println("Time: " + stopWatch.getElapsedTime());
        for (int value : array) {
            System.out.print(value + " ");
        }
    }

    public static int[] selectionSort(int... a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length; j++) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        return a;
    }
}
