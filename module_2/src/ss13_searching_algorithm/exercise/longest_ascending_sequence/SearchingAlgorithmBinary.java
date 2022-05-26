package ss13_searching_algorithm.excrecise.longest_ascending_sequence;

import java.util.*;

public class SearchingAlgorithmBinary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String string = input.nextLine();

        LinkedList<Character> maxChar = new LinkedList<>();

        // Tìm chuỗi tăng dần có độ dài lớn nhất
        for (int i = 0; i < string.length(); i++) { //Vòng lặp bên ngoài
            //Khai báo một linked listChar trung gian các kí tự của chuỗi tăng dần
            LinkedList<Character> listChar = new LinkedList<>();
            //thêm kí tự thứ i vào trong listChar
            listChar.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) { //vòng lặp bên trong
                //Kiểm tra kí tự tiếp theo có lớn hơn kí tự cuối cùng trong listChar hay không
                if (string.charAt(j) > listChar.getLast()) {
                    //Nếu có thì thêm vào trong listChar
                    listChar.add(string.charAt(j));
                }
            }
            //So sánh kích cỡ của listChar trung gian và listChar chứa chuỗi tăng dần có kích thước lớn nhất
            if (listChar.size() > maxChar.size()) {
                //Nếu kích cỡ của listChar trung gian lớn hơn kích cỡ của listChar có độ dài lớn nhất thì gán lại maxChar
                maxChar.clear();
                maxChar.addAll(listChar);
            }
            listChar.clear();
        }

        // Hiển thị chuỗi tăng dần dài nhất
        for (Character ch : maxChar) { // 1 vòng lặp
            System.out.print(ch); // 1 câu lệnh
        }
        System.out.println();
    }
}