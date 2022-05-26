package ss16_io_text_file.practice.find_maximum_value_and_write_out_the_file;

import java.util.List;

public class FindMaxValue {
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("src\\ss16_io_text_file\\practice\\find_maximum_value_and_write_out_the_file\\number.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writerFile("src\\ss16_io_text_file\\practice\\find_maximum_value_and_write_out_the_file\\number.txt", maxValue);
    }

    public static int findMax(List<Integer> number) {
        int max = number.get(0);
        for (int i = 1; i < number.size(); i++) {
            if (max < number.get(i)) {
                max = number.get(i);
            }
        }
        return max;
    }
}
