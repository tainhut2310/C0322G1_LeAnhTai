package quan_ly_benh_vien.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    
    public static void writeFile(String pathFile, String data) {
        File file = new File(pathFile);
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(data);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String[]> readFile(String pathFile) {
        File file = new File(pathFile);
        List<String[]> list = new ArrayList<>();
        String line = null;
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null && !line.equals("")) {
                String[] arr = line.split(",");
                list.add(arr);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
