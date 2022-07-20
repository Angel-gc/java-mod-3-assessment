import java.util.Scanner;

class ScannerUserInputService implements UserInputService {
    private Scanner scanner;
    private UserOutputService userOutputService;

    public ScannerUserInputService(UserOutputService userOutputService) {
        this.scanner = new Scanner(System.in);
        this.userOutputService = userOutputService;
    }

    public String getUserInput(String prompt) {
        userOutputService.printMessage(prompt);
        String input = scanner.nextLine();
        if (input.isBlank()) {
            return getUserInput(prompt);
        }
        return input;
    }
    public int getUserIntInput(String prompt) {
        userOutputService.printMessage(prompt);
        String input = scanner.nextLine();
        if (input.isBlank()) {
            return getUserIntInput(prompt);
        }
        try {
            int i = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            return getUserIntInput(prompt);
        }

        return Integer.parseInt(input);
    }

    @Override
    public void close() throws Exception {
        scanner.close();

    }
}