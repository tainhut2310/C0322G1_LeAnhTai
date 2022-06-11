package quan_ly_nop_ho_so.model;

import java.time.LocalDate;

public abstract class Candidate {
    private int candidateID;
    private String fullName;
    private LocalDate birthDay;
    private String phone;
    private String email;
    private String candidateType;
    private String candidateCount;
    private Certificated certificatedID ;

    public Candidate() {
    }

    public Candidate(int candidateID,
                     String fullName,
                     LocalDate birthDay,
                     String phone,
                     String email,
                     String candidateType,
                     String candidateCount,
                     Certificated certificatedID) {
        this.candidateID = candidateID;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
        this.candidateCount = candidateCount;
        this.certificatedID = certificatedID;
    }

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(String candidateType) {
        this.candidateType = candidateType;
    }

    public String getCandidateCount() {
        return candidateCount;
    }

    public void setCandidateCount(String candidateCount) {
        this.candidateCount = candidateCount;
    }

    public Certificated getCertificatedID() {
        return certificatedID;
    }

    public void setCertificatedID(Certificated certificatedID) {
        this.certificatedID = certificatedID;
    }

    public abstract String getInfo();

    @Override
    public String toString() {
        return "Certificate{" +
                "candidateID=" + candidateID +
                ", fullName='" + fullName + '\'' +
                ", birthDay=" + birthDay +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", candidateType='" + candidateType + '\'' +
                ", candidateCount='" + candidateCount + '\'' +
                ", certificatedID=" + certificatedID +
                '}';
    }
}
