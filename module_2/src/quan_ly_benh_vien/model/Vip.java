package quan_ly_benh_vien.model;

public class Vip extends MedicalRecord {
    private String vipType;
    private String vipDuration;

    public Vip() {
    }

    public Vip(int numericalOrder,
               String medicalRecordCode,
               String patientCode,
               String namePatient,
               String dayIn,
               String dayOut,
               String reasonForAdmission,
               String vipType,
               String vipDuration) {
        super(numericalOrder, medicalRecordCode, patientCode, namePatient, dayIn, dayOut, reasonForAdmission);
        this.vipType = vipType;
        this.vipDuration = vipDuration;
    }

    public String getVipType() {
        return vipType;
    }

    public void setVipType(String vipType) {
        this.vipType = vipType;
    }

    public String getVipDuration() {
        return vipDuration;
    }

    public void setVipDuration(String vipDuration) {
        this.vipDuration = vipDuration;
    }

    @Override
    public String getInfo() {
        return  String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",
                super.getNumericalOrder(),
                super.getMedicalRecordCode(),
                super.getPatientCode(),
                super.getNamePatient(),
                super.getDayIn(),
                super.getDayOut(),
                super.getReasonForAdmission(),
                this.getVipType(),
                this.getVipDuration()) + "\n";
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + vipType +
                "," + vipDuration;
    }
}
