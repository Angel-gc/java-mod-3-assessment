public enum SpecialtiesEnum {
    DERMATOLOGY("dermatology", "acne", 3, true ),
    CARDIOLOGY("cardiology", "heart disease", 5, true),
    NEUROLOGY("neurology", "tumor", 6 , true),
    ONCOL0GY("radiology", "cancer",7 , false),
    PEDIATRICS("pediatrics", "cold",2, true);

    String specialty;
    int numberOfTreatmentsReq;
    boolean curePossible;

    String disease;

    SpecialtiesEnum(String specialty, String disease, int numberOfTreatmentsReq, boolean curePossible) {
        this.specialty = specialty;
        this.disease = disease;
        this.numberOfTreatmentsReq = numberOfTreatmentsReq;
        this.curePossible = curePossible;
    }
    public String getLabel(){
        return specialty;
    }
    public String getSpecialty(){
        return specialty;
    }

    public int getNumberOfTreatmentsReq() {
        return numberOfTreatmentsReq;
    }

    public boolean isCurePossible() {
        return curePossible;
    }
}