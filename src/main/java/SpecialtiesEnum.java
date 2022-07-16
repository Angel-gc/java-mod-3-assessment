public enum SpecialtiesEnum {
    DERMATOLOGY(5, 10),
    ONCOLOGY(4, 20),
    PEDIATRICS(2, 15),
    ORTHOPEDICS(3, 20),
    NEUROLOGY(1, 50);

    private int numberOfTreatments;
    private int healingPower;

    private SpecialtiesEnum(int numberOfTreatments, int healingPower) {
        this.numberOfTreatments = numberOfTreatments;
        this.healingPower = healingPower;
    }

    public int getNumberOfTreatments() {
        return numberOfTreatments;
    }
    public int getHealingPower() {
        return healingPower;
    }

    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }

    public void setNumberOfTreatments(int numberOfTreatments) {
        this.numberOfTreatments = numberOfTreatments;
    }
}

