package ss16_io_text_file.excrecise.coppy_file_text;

import java.io.*;

public class ReadAndWriteFile {
    public static void main(String[] args) {
        File file = new File("src\\ss16_io_text_file\\excrecise\\coppy_file_text\\sourcefile.txt");
        File file1 = new File("src\\ss16_io_text_file\\excrecise\\coppy_file_text\\targetfile.txt");
        if (!file.exists()) {
            System.out.println("File nguồn không tồn tại!");
        } else if (file1.exists()) {
            System.out.println("File đích đã tồn tại!");
        } else {
            try (FileReader fileReader = new FileReader(file);
                 BufferedReader br = new BufferedReader(fileReader);
                 FileWriter fileWriter = new FileWriter(file1);
                 BufferedWriter bw = new BufferedWriter(fileWriter)) {
                String line;
                int count = 0;
                while ((line = br.readLine()) != null) {
                    bw.write(line);
                    bw.newLine();
                    count += line.length();
                }
                bw.write("Số ký tự trong tệp: " + count);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
