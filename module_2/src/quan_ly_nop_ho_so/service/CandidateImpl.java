package quan_ly_nop_ho_so.service;

import quan_ly_nop_ho_so.model.Candidate;
import quan_ly_nop_ho_so.model.Certificated;
import quan_ly_nop_ho_so.model.Experience;
import quan_ly_nop_ho_so.util.ReadAndWriteFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CandidateImpl implements ICandidate {
    public static List<Candidate> candidateList = new LinkedList<>();
    public static List<Certificated> certificatedList = new ArrayList<>();

    @Override
    public void display() {

    }

    @Override
    public void addNew() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void sort() {

    }

    public void addNewExperience() {
        List<String[]> list = ReadAndWriteFile.readFile("src\\quan_ly_nop_ho_so\\data\\candidate.csv");
        List<String[]> certificatedList = ReadAndWriteFile.readFile("src\\quan_ly_nop_ho_so\\data\\certificated.csv");
        candidateList.clear();
        for (String[] item : list) {
            Certificated certificated = null;
            for (String[] element : certificatedList) {
                if (item[5].equals(element[0])) {
                    certificated = new Certificated(element[0], element[1], element[2], LocalDate.parse(element[3]));
                    break;
                }
            }
            if (item.length == 10) {
                Experience experience = new Experience(Integer.parseInt(item[0]),
                        item[1],
                        LocalDate.parse(item[2]),
                        item[3],
                        item[4],
                        item[5],
                        item[6],
                        certificated,
                        Integer.parseInt(item[8]),
                        item[9]);
            }
        }
    }
}
