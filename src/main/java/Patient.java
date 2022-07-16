class Patient {
    private String name;
    private String need;

    private int healthIndex;

    private Ailment disease;

    public Patient(String name, String need) {
        this.name = name;
        this.need = need;
    }

    public Patient (int healthIndex, Ailment disease){
        this.disease = disease;
        this.healthIndex = 0;
        switch (disease.getStartingHealthIndex()){
            case 20:
                disease.setStartingHealthIndex(20);
                break;
            case 70:
                disease.setStartingHealthIndex(70);
                break;
            case 90:
                disease.setStartingHealthIndex(90);
                break;
            case 50:
                disease.setStartingHealthIndex(50);
                break;
            case 40:
                disease.setStartingHealthIndex(40);
                break;
        }
    }
    public void receiveTreatment(int treatment){
        this.healthIndex += treatment;
    }
    public boolean healed(){
       return this.healthIndex >= 100;
    }
    public boolean died(){
        return this.healthIndex <= 0;
    }

    public String getName() {
        return name;
    }
    public int getHealthIndex() {
        return healthIndex;
    }

    public void setHealthIndex(int healthIndex) {
        this.healthIndex = healthIndex;
    }


    public Ailment getDisease() {
        return disease;
    }

    public void setDisease(Ailment disease) {
        this.disease = disease;
    }

    public String getNeed() {
        return need;
    }

    @Override
    public String toString() {
        return "Patient [name=" + name + ", need=" + need + "]";
    }

}