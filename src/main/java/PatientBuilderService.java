class PatientBuilderService {
    private UserInputService userInputService;
    private UserOutputService userOutputService;

    public PatientBuilderService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }
    public Ailment createAilment(){
        userOutputService.printMessage("[1.Cold]  [2.Skin Rash]  [3.Broken Bone]  [4.Something Else]");
        int ailmentOption = userInputService.getUserIntInput("Whats the patients disease?");
        switch (ailmentOption) {
            case 1:
                return new Ailment("Cold", new Specialty("Pediatrics", 5), 70, true);
            case 2:
                return new Ailment("Skin Rash", new Specialty("Dermatology", 4), 65, true);
            case 3:
                return new Ailment("Broken Bone", new Specialty("Orthopedic", 2), 60, true);
            case 4:
            default:
                return new Ailment("unknown", new Specialty("Primary", 3), 10, false);
        }
    }

    public Patient createPatient() {
        String name = userInputService.getUserInput("What's the patient's name?");
        String specialty = userInputService.getUserInput("What's the patient's specialty?");
        String disease = userInputService.getUserInput("Whats the patients disease?");
        Patient patient = new Patient(name, specialty, createAilment());
        return patient;
    }
}