class Ailment {
    String name;
   boolean isCureable;

   Specialty associatedSpecialty;
   int startingHealthIndex;

    public Ailment(String name, Specialty associatedSpecialty,  int startingHealthIndex, boolean isCureable) {
        this.isCureable = isCureable;
        this.startingHealthIndex = startingHealthIndex;
        this.associatedSpecialty = associatedSpecialty;
    }

    public boolean isCureable() {
        return isCureable;
    }

    public String getName() {
        return name;
    }

    public int getStartingHealthIndex() {
        return startingHealthIndex;
    }
}
