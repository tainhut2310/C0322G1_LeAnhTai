package ss16_io_text_file.exercise.write_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCSV {
    public static void main(String[] args) {
        List<Country> listCountry = new ArrayList<>();
        List<String[]> list = ReadFileCSV.readFileCsv("src\\ss16_io_text_file\\excrecise\\write_file_csv\\file.csv");
        for (String[] item : list) {
           Country country = new Country(Integer.parseInt(item[0]), item[1], item[2]);
           listCountry.add(country);
        }
        System.out.println("Danh sách các quốc gia:");
        for (Country item : listCountry) {
            System.out.println(item);
        }
    }
    public static List<String[]> readFileCsv(String filePath) {
        File file = new File(filePath);
        List<String[]> list = new ArrayList<>();
        String line;
        try ( BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
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
