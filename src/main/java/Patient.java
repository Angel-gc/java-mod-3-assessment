class Patient {
    private String name;
    private String need;
    private int healthIndex;
    private Ailment disease;

    public Patient(String name, String need, Ailment disease) {
        this.name = name;
        this.need = need;
        this.healthIndex = disease.getStartingHealthIndex();
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


    public String getNeed() {
        return need;
    }

    @Override
    public String toString() {
        return "Patient [name=" + name + ", need=" + need + "]";
    }

}