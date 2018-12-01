package net.savethechildren.bangladesh.suchanamis.module;

/**
 * Created by stccon on 8/27/2017.
 */

public class TrainingServiceClass {

    String trainingName;
    String trainingDate;
    String trainingType;
    String trainingReceiver;
    String user;
    String other;
    String measure;
    String typePosition;
    String iga_no;

    public TrainingServiceClass(String trainingName, String trainingDate, String trainingType, String trainingReceiver,String  user,String other,String measure, String typePosition, String iga_no) {

        this.trainingName = trainingName;
        this.trainingDate = trainingDate;
        this.trainingType = trainingType;
        this.trainingReceiver = trainingReceiver;
        this.user = user;
        this.other = other;
        this.measure = measure;
        this.typePosition = typePosition;
        this.iga_no = iga_no;

    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(String trainingDate) {
        this.trainingDate = trainingDate;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    public String getTrainingReceiver() {
        return trainingReceiver;
    }

    public void setTrainingReceiver(String trainingReceiver) {
        this.trainingReceiver = trainingReceiver;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getTypePosition() {
        return typePosition;
    }

    public void setTypePosition(String typePosition) {
        this.typePosition = typePosition;
    }

    public String getIga_no() {
        return iga_no;
    }

    public void setIga_no(String iga_no) {
        this.iga_no = iga_no;
    }

    @Override
    public String toString() {
        return "TrainingServiceClass{" +
                "trainingName='" + trainingName + '\'' +
                ", trainingDate='" + trainingDate + '\'' +
                ", trainingType='" + trainingType + '\'' +
                ", trainingReceiver='" + trainingReceiver + '\'' +
                ", user='" + user + '\'' +
                ", other='" + other + '\'' +
                ", measure=" + measure +
                ", typePosition=" + typePosition +
                '}';
    }
}
