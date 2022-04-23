
package connection;

public class Laboratory {
    private int id;
    private String laboratoryResult;
    private String patientTc;
    private int doctorId;
    private String resultDate;

    public Laboratory(int id, String laboratoryResult, String patientTc, int doctorId, String resultDate) {
        this.id = id;
        this.laboratoryResult = laboratoryResult;
        this.patientTc = patientTc;
        this.doctorId = doctorId;
        this.resultDate = resultDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLaboratoryResult() {
        return laboratoryResult;
    }

    public void setLaboratoryResult(String laboratoryResult) {
        this.laboratoryResult = laboratoryResult;
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

    public String getResultDate() {
        return resultDate;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }

    
}
