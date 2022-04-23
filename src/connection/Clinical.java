
package connection;

public class Clinical {
    private String clinicalId;
    private String clinicalName;

    public Clinical(String clinicalId, String clinicalName) {
        this.clinicalId = clinicalId;
        this.clinicalName = clinicalName;
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
}
