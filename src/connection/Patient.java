
package connection;

public class Patient {
    private String patientId;
    private String tc;
    private String name;
    private String lastName;
    private String residenceAddress;
    private String dateOfBirth;
    private String birthplace;
    private String gender;
    private String email;
    private String phoneNumber;
    private String bloodType;

    public Patient(String patientId, String tc, String name, String lastName, String residenceAddress, String dateOfBirth, String birthplace, String gender, String email, String phoneNumber, String bloodType) {
        this.patientId = patientId;
        this.tc = tc;
        this.name = name;
        this.lastName = lastName;
        this.residenceAddress = residenceAddress;
        this.dateOfBirth = dateOfBirth;
        this.birthplace = birthplace;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bloodType = bloodType;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
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

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}
