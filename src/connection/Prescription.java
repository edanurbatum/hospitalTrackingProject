
package connection;

public class Prescription {
    private int prescriptionId;
    private String prescription;
    private String patientTc;
    private int doctorId;
    private String prescriptionDate;

    public Prescription(int prescriptionId, String prescription, String patientTc, int doctorId, String prescriptionDate) {
        this.prescriptionId = prescriptionId;
        this.prescription = prescription;
        this.patientTc = patientTc;
        this.doctorId = doctorId;
        this.prescriptionDate = prescriptionDate;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getPatientTc() {
        return patientTc;
    }

    public void setPatientTc(String patientTc) {
        this.patientTc = patientTc;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(String prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }
}
