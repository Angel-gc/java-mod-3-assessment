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
        this.healthIndex = healthIndex;
        this.disease = disease;
    }
    public void receiveTreatment(int treatment){
        this.healthIndex += treatment;
    }
    public void healed(){
        this.healthIndex = 100;
    }
    public void died(){
        this.healthIndex = 0;
    }


    public String getName() {
        return name;
    }

    public String getNeed() {
        return need;
    }

    @Override
    public String toString() {
        return "Patient [name=" + name + ", need=" + need + "]";
    }

}