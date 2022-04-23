
package connection;

public class Appointment {
    private String appointmentId;
    private String tc;
    private String name;
    private String lastName;  
    private String clinicalId; 
    private String clinicalName; 
    private String doctorId; 
    private String appointmentDate;        
    private String appointmentTime;
    private String patientId;
    private String result; 

    public Appointment(String appointmentId, String tc, String name, String lastName, String clinicalId, String clinicalName, String doctorId, String appointmentDate, String appointmentTime, String patientId, String result) {
        this.appointmentId = appointmentId;
        this.tc = tc;
        this.name = name;
        this.lastName = lastName;
        this.clinicalId = clinicalId;
        this.clinicalName = clinicalName;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.patientId = patientId;
        this.result = result;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getClinicalId() {
        return clinicalId;
    }

    public void setClinicalId(String clinicalId) {
        this.clinicalId = clinicalId;
    }

    public String getClinicalName() {
        return clinicalName;
    }

    public void setClinicalName(String clinicalName) {
        this.clinicalName = clinicalName;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    
}
