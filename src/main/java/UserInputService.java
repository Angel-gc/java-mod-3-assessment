interface UserInputService extends AutoCloseable {
    String getUserInput(String prompt);

    int getUserIntInput(String s);
}