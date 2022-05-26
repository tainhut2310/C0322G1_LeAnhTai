package ss16_io_text_file.practice.find_maximum_value_and_write_out_the_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String filePath) {
        List<Integer> numberList = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                numberList.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File không tồn tại hoặc nội dung có lỗi!");
        }
        return numberList;
    }

    public void writerFile(String filePath, int max) {
        File file = new File(filePath);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(max);
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            System.out.println("File không tồn tại hoặc nội dung có lỗi");
        }
    }
}
