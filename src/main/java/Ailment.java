public enum Ailment {

    COLD(70, false, SpecialtiesEnum.PEDIATRICS),
    ACNE(50, true, SpecialtiesEnum.DERMATOLOGY),
    HEADACHE(90, true, SpecialtiesEnum.NEUROLOGY),
    CANCER(20, false, SpecialtiesEnum.ONCOLOGY),
    ARTHRITIS(40, false, SpecialtiesEnum.ORTHOPEDICS);

    private int startingHealthIndex;
    private boolean cure;
    private SpecialtiesEnum specialtyMatch;

    private Ailment(int startingHealthIndex, boolean cure, SpecialtiesEnum specialtyMatch) {
        this.startingHealthIndex = startingHealthIndex;
        this.cure = cure;
        this.specialtyMatch = specialtyMatch;
    }

    public int getStartingHealthIndex() {
        return startingHealthIndex;
    }

    public void setStartingHealthIndex(int startingHealthIndex) {
        this.startingHealthIndex = startingHealthIndex;
    }
    public SpecialtiesEnum getSpecialtyMatch() {
        return specialtyMatch;
    }
    public boolean isCure() {
        return cure;
    }
}
