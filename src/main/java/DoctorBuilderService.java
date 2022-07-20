class DoctorBuilderService {
    private UserInputService userInputService;

    public DoctorBuilderService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    public Doctor createDoctor() {
        String name = userInputService.getUserInput("What's the doc's name?");
        String specialtyName = userInputService.getUserInput("What's the doc's specialty?");
        Doctor doctor = new Doctor(name, new Specialty(specialtyName, 5));
        return doctor;
    }
}