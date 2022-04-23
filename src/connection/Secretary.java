
package connection;

public class Secretary {
    private String secretaryId;
    private String tc;
    private String name;
    private String lastName;
    private String gender;
    private String residenceAddress;
    private String dateOfBirth;
    private String birthplace;
    private String email;
    private String phoneNumber;

    public Secretary(String secretaryId, String tc, String name, String lastName, String gender, String residenceAddress, String dateOfBirth, String birthplace, String email, String phoneNumber) {
        this.secretaryId = secretaryId;
        this.tc = tc;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.residenceAddress = residenceAddress;
        this.dateOfBirth = dateOfBirth;
        this.birthplace = birthplace;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getSecretaryId() {
        return secretaryId;
    }

    public void setSecretaryId(String secretaryId) {
        this.secretaryId = secretaryId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
}
