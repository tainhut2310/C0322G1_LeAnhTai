package quan_ly_nop_ho_so.model;

import java.time.LocalDate;

public class Fresher extends Candidate {
    private LocalDate graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                getCandidateID(),
                getFullName(),
                getBirthDay(),
                getPhone(),
                getEmail(),
                getCandidateType(),
                getCandidateCount(),
                getCertificatedID(),
                graduationDate,
                graduationRank,
                education);
    }

    public Fresher(int candidateID,
                   String fullName,
                   LocalDate birthDay,
                   String phone,
                   String email,
                   String candidateType,
                   String candidateCount,
                   Certificated certificatedID,
                   LocalDate graduationDate,
                   String graduationRank,
                   String education) {
        super(candidateID, fullName, birthDay, phone, email, candidateType, candidateCount, certificatedID);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Fresher{" + super.toString() +
                "graduationDate=" + graduationDate +
                ", graduationRank='" + graduationRank + '\'' +
                ", education='" + education + '\'' +
                '}';
    }
}
