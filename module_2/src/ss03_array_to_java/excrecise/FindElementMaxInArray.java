package ss03_array_to_java.excrecise;

public class FindElementMaxInArray {
    public static void main(String[] args) {
        double[][] array = {
                {3.4, 5.6, 7.8},
                {12.3, 22.3, 13.4},
                {44.5, 55.2, 67.4},
                {25.4, 64.3, 32.1}
        };
        System.out.println("Element in array:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        double max = array[0][0];
        int index = 0;
        int index2 = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    index = i;
                    index2 = j;
                }
            }
        }
        System.out.println("The element with max value " + max + " coordinates " + index + "\t" + index2);
    }
}