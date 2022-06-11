package quan_ly_benh_vien.model;

public abstract class MedicalRecord {
    private int numericalOrder;
    private String medicalRecordCode;
    private String patientCode;
    private String namePatient;
    private String dayIn;
    private String dayOut;
    private String reasonForAdmission;

    public MedicalRecord() {
    }

    public MedicalRecord(int numericalOrder, String medicalRecordCode, String patientCode, String namePatient, String dayIn, String dayOut, String reasonForAdmission) {
        this.numericalOrder = numericalOrder;
        this.medicalRecordCode = medicalRecordCode;
        this.patientCode = patientCode;
        this.namePatient = namePatient;
        this.dayIn = dayIn;
        this.dayOut = dayOut;
        this.reasonForAdmission = reasonForAdmission;
    }

    public int getNumericalOrder() {
        return numericalOrder;
    }

    public void setNumericalOrder(int numericalOrder) {
        this.numericalOrder = numericalOrder;
    }

    public String getMedicalRecordCode() {
        return medicalRecordCode;
    }

    public void setMedicalRecordCode(String medicalRecordCode) {
        this.medicalRecordCode = medicalRecordCode;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public String getDayIn() {
        return dayIn;
    }

    public void setDayIn(String dayIn) {
        this.dayIn = dayIn;
    }

    public String getDayOut() {
        return dayOut;
    }

    public void setDayOut(String dayOut) {
        this.dayOut = dayOut;
    }

    public String getReasonForAdmission() {
        return reasonForAdmission;
    }

    public void setReasonForAdmission(String reasonForAdmission) {
        this.reasonForAdmission = reasonForAdmission;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public abstract String getInfo();

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                numericalOrder,
                medicalRecordCode,
                patientCode,
                numericalOrder,
                dayIn,
                dayOut,
                reasonForAdmission);
    }
}
