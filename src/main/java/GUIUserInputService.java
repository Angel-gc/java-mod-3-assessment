import javax.swing.*;

class GUIUserInputService implements UserInputService {

    @Override
    public String getUserInput(String prompt) {
        String response = JOptionPane.showInputDialog(null, prompt);
        if (response.isBlank()) {
            return getUserInput(prompt);
        }
        return response;
    }

    @Override
    public void close() throws Exception {

    }
}