package ss01_introduction_to_java.Excrecise;

import java.util.Scanner;

public class ReadNumbersIntoWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a numbers:");
        int number = scanner.nextInt();
        int numberA, numberB, numberC;
        numberA = number % 10;
        numberB = (number / 10) % 10;
        numberC = (number / 100) % 10;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        if (number >= 0) {
            switch (number) {
                case 1:
                    s1 = "One";
                    break;
                case 2:
                    s1 = "Two";
                    break;
                case 3:
                    s1 = "Three";
                    break;
                case 4:
                    s1 = "Four";
                    break;
                case 5:
                    s1 = "Five";
                    break;
                case 6:
                    s1 = "Six";
                    break;
                case 7:
                    s1 = "Seven";
                    break;
                case 8:
                    s1 = "Eight";
                    break;
                case 9:
                    s1 = "Nine";
                    break;
            }
            System.out.println(s1);
        }
        if (number >= 10 && number < 20) {
            switch (numberA) {
                case 0:
                    s1 = "Ten";
                    break;
                case 1:
                    s1 = "Eleven";
                    break;
                case 2:
                    s1 = "Twelve";
                    break;
                case 3:
                    s1 = "Thirteen";
                    break;
                case 4:
                    s1 = "Fourteen";
                    break;
                case 5:
                    s1 = "Fifteen";
                    break;
                case 6:
                    s1 = "Sixteen";
                    break;
                case 7:
                    s1 = "Seventeen";
                    break;
                case 8:
                    s1 = "Eighteen";
                    break;
                case 9:
                    s1 = "Nineteen";
                    break;
            }
            System.out.println(s1);
        }
        if (number >= 20 && number < 100) {
            switch (numberB) {
                case 2:
                    s1 = "Twenty";
                    break;
                case 3:
                    s1 = "Thirty";
                    break;
                case 4:
                    s1 = "Forty";
                    break;
                case 5:
                    s1 = "Fifty";
                    break;
                case 6:
                    s1 = "Sixty";
                    break;
                case 7:
                    s1 = "Seventy";
                    break;
                case 8:
                    s1 = "Eighty";
                    break;
                case 9:
                    s1 = "Ninety";
                    break;
            }
            switch (numberA) {
                case 1:
                    s2 = "one";
                    break;
                case 2:
                    s2 = "two";
                    break;
                case 3:
                    s2 = "three";
                    break;
                case 4:
                    s2 = "our";
                    break;
                case 5:
                    s2 = "five";
                    break;
                case 6:
                    s2 = "six";
                    break;
                case 7:
                    s2 = "seven";
                    break;
                case 8:
                    s2 = "eight";
                    break;
                case 9:
                    s2 = "nine";
                    break;
            }
            System.out.println(s1 + " " + s2);
        }
        if (number < 1000 && number >= 100) {
            switch (numberC) {
                case 1:
                    s1 = "One hundred";
                    break;
                case 2:
                    s1 = "Two hundred";
                    break;
                case 3:
                    s1 = "Three hundred";
                    break;
                case 4:
                    s1 = "Four hundred";
                    break;
                case 5:
                    s1 = "Five hundred";
                    break;
                case 6:
                    s1 = "Six hundred";
                    break;
                case 7:
                    s1 = "Seven hundred";
                    break;
                case 8:
                    s1 = "Eight hundred";
                    break;
                case 9:
                    s1 = "Nine hundred";
                    break;
            }
            switch (numberB) {
                case 0:
                    s3 = "";
                case 1:
                    switch (numberA) {
                        case 0:
                            s2 = "ten ";
                            break;
                        case 1:
                            s2 = "eleven ";
                            break;
                        case 2:
                            s2 = "twelve ";
                            break;
                        case 3:
                            s2 = "thirteen ";
                            break;
                        case 4:
                            s2 = "fourteen ";
                            break;
                        case 5:
                            s2 = "fifteen ";
                            break;
                        case 6:
                            s2 = "sixteen ";
                            break;
                        case 7:
                            s2 = "seventeen ";
                            break;
                        case 8:
                            s2 = "eighteen ";
                            break;
                        case 9:
                            s2 = "nineteen ";
                            break;
                    }
                    break;
                case 2:
                    s3 = "twenty ";
                    break;
                case 3:
                    s3 = "thirty ";
                    break;
                case 4:
                    s3 = "forty ";
                    break;
                case 5:
                    s3 = "fifty ";
                    break;
                case 6:
                    s3 = "sixty ";
                    break;
                case 7:
                    s3 = "seventy ";
                    break;
                case 8:
                    s3 = "eighty ";
                    break;
                case 9:
                    s3 = "ninety ";
                    break;
            }
            switch (numberA) {
                case 1:
                    s4 = "one";
                    break;
                case 2:
                    s4 = "two";
                    break;
                case 3:
                    s4 = "three";
                    break;
                case 4:
                    s4 = "four";
                    break;
                case 5:
                    s4 = "five";
                    break;
                case 6:
                    s4 = "six";
                    break;
                case 7:
                    s4 = "seven";
                    break;
                case 8:
                    s4 = "eight";
                    break;
                case 9:
                    s4 = "nine";
                    break;
            }
            if (numberB == 1) {
                System.out.println(s1 + " and " + s2);
            }
            else if(numberB == 0 && numberA == 0) {
                System.out.println(s1);
            } else {
                System.out.println(s1 + " and " + s3 + " " + s4);
            }
        }
    }
}
