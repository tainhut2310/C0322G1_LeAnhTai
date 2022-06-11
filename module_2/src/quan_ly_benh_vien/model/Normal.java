package quan_ly_benh_vien.model;

public class Normal extends MedicalRecord {
    private double hospitalizationExpenses;

    public Normal() {
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                super.getNumericalOrder(),
                super.getMedicalRecordCode(),
                super.getPatientCode(),
                super.getNamePatient(),
                super.getDayIn(),
                super.getDayOut(),
                super.getReasonForAdmission(),
                this.getHospitalizationExpenses()) + "\n";
    }

    public Normal(int numericalOrder,
                  String medicalRecordCode,
                  String patientCode,
                  String namePatient,
                  String dayIn,
                  String dayOut,
                  String reasonForAdmission,
                  double hospitalizationExpenses) {
        super(numericalOrder, medicalRecordCode, patientCode, namePatient, dayIn, dayOut, reasonForAdmission);
        this.hospitalizationExpenses = hospitalizationExpenses;
    }

    public double getHospitalizationExpenses() {
        return hospitalizationExpenses;
    }

    public void setHospitalizationExpenses(double hospitalizationExpenses) {
        this.hospitalizationExpenses = hospitalizationExpenses;
    }

    @Override
    public String toString() {
        return super.toString() +
               "," + hospitalizationExpenses;
    }
}
