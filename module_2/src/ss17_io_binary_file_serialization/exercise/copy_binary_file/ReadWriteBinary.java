package ss17_io_binary_file_serialization.exercise.copy_binary_file;

import java.io.*;
import java.util.Scanner;

public class ReadWriteBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a source file: ");
        String sourceFile = scanner.nextLine();
        File file = new File(sourceFile);
        File file1 = new File("src\\ss17_io_binary_file_serialization\\exercise\\copy_binary_file\\target_file.txt");
        if (!file.exists()) {
            System.out.println("File nguồn không tồn tại!");
        } else if (file1.exists()) {
            System.out.println("File đích đã tồn tại!");
        } else {
            try (FileInputStream is = new FileInputStream(file);
                 FileOutputStream os = new FileOutputStream(file1);
                 BufferedInputStream ois = new BufferedInputStream(is);
                 BufferedOutputStream oos = new BufferedOutputStream(os)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = ois.read(buffer)) > 0) {
                    oos.write(buffer, 0, length);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
