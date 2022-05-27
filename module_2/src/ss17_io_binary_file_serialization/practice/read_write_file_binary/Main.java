package ss17_io_binary_file_serialization.practice.read_write_file_binary;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        writeToFile("src\\ss17_io_binary_file_serialization\\practice\\read_write_file_binary\\binary_file.txt", students);
        List<Student> studentDataFromFile = readDataFromFile("src\\ss17_io_binary_file_serialization\\practice\\read_write_file_binary\\binary_file.txt");
        for (Student item : studentDataFromFile) {
            System.out.println(item);
        }
    }

    public static void writeToFile(String path, List<Student> students) {
        File file = new File(path);
        FileOutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            os = new FileOutputStream(file);
            oos = new ObjectOutputStream(os);
            oos.writeObject(students);
            System.out.println("write completed");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return students;
    }
}
