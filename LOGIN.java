import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LOGIN {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Login Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(4, 2));

        // Create labels and text fields
        JLabel userLabel = new JLabel("Username:");
        JTextField userText = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordText = new JPasswordField();
        JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");
        JButton loginButton = new JButton("Login");
        JLabel successLabel = new JLabel("");

        // Add show/hide password functionality
        showPasswordCheckBox.addActionListener(e -> {
            if (showPasswordCheckBox.isSelected()) {
                passwordText.setEchoChar((char) 0);
            } else {
                passwordText.setEchoChar('*');
            }
        });

        // Add action listener to the button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                // Validate input
                if (validateCredentials(username, password)) {
                    JFrame newFrame = new JFrame("Welcome");
                    newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    newFrame.setSize(300, 100);
                    newFrame.setLayout(new FlowLayout());

                    // Create label for the new frame
                    JLabel welcomeLabel = new JLabel("Welcome MEMORY MATARE - REG NUMBER: H230003M");
                    newFrame.add(welcomeLabel);

                    // Make the new frame visible
                    newFrame.setVisible(true);

                    // Dispose the old frame
                    frame.dispose();
                } else {
                    successLabel.setText("Invalid username or password, try again.");
                }
            }
        });

        // Add components to the frame
        frame.add(userLabel);
        frame.add(userText);
        frame.add(passwordLabel);
        frame.add(passwordText);
        frame.add(showPasswordCheckBox);
        frame.add(loginButton);
        frame.add(successLabel);

        // Make the frame visible
        frame.setVisible(true);
    }

    // Simple validation method for demonstration purposes
    private static boolean validateCredentials(String username, String password) {
        String storedUsername = "admin";
        String storedPassword = "password"; // In a real scenario, you'd not store passwords in plain text
        return username.equals(storedUsername) && password.equals(storedPassword);
    }
}
