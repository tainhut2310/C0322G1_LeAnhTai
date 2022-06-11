package quan_ly_nop_ho_so.model;

import java.time.LocalDate;

public class Experience extends Candidate {
    private int inYear;
    private String proSkill;

    public Experience() {
    }

    public Experience(int candidateID,
                      String fullName,
                      LocalDate birthDay,
                      String phone,
                      String email,
                      String candidateType,
                      String candidateCount,
                      Certificated certificatedID,
                      int inYear,
                      String proSkill) {
        super(candidateID, fullName, birthDay, phone, email, candidateType, candidateCount, certificatedID);
        this.inYear = inYear;
        this.proSkill = proSkill;
    }


    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                getCandidateID(),
                getFullName(),
                getBirthDay(),
                getPhone(),
                getEmail(),
                getCandidateType(),
                getCandidateCount(),
                getCertificatedID(),
                proSkill,
                inYear);
    }

    public int getInYear() {
        return inYear;
    }

    public void setInYear(int inYear) {
        this.inYear = inYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return "Experience{" + super.toString() +
                "inYear=" + inYear +
                ", proSkill='" + proSkill + '\'' +
                '}';
    }
}
