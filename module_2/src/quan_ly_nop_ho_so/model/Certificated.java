package quan_ly_nop_ho_so.model;

import java.time.LocalDate;

public class Certificated {
    private String certificatedID;
    private String certificateName;
    private String certificateRank;
    private LocalDate certificatedDate;

    public Certificated() {
    }

    public Certificated(String certificatedID, String certificateName, String certificateRank, LocalDate certificatedDate) {
        this.certificatedID = certificatedID;
        this.certificateName = certificateName;
        this.certificateRank = certificateRank;
        this.certificatedDate = certificatedDate;
    }

    public String getCertificatedID() {
        return certificatedID;
    }

    public void setCertificatedID(String certificatedID) {
        this.certificatedID = certificatedID;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateRank() {
        return certificateRank;
    }

    public void setCertificateRank(String certificateRank) {
        this.certificateRank = certificateRank;
    }

    public LocalDate getCertificatedDate() {
        return certificatedDate;
    }

    public void setCertificatedDate(LocalDate certificatedDate) {
        this.certificatedDate = certificatedDate;
    }

    @Override
    public String toString() {
        return "Certificated{" +
                "certificatedID='" + certificatedID + '\'' +
                ", certificateName='" + certificateName + '\'' +
                ", certificateRank='" + certificateRank + '\'' +
                ", certificatedDate=" + certificatedDate +
                '}';
    }
}