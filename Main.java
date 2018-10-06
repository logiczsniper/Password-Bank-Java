import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


/**
 * This is a small project to improve on my Java skills!
 * The idea is that when the program runs, a small window appears. You can:
 * 1) Save a new password and username pair to the bank.
 * 2) Enter a username and get the password matching that.
 * 3) Delete an existing username and it's password.
 * 4) Clear all credentials.
 *
 * @author Logan Czernel
 * @since 02-10-2018
 */


public class Main {

    /**
     * Runs the program.
     */

    public static void main(String[] args) {

        // Set up application, set icon
        JFrame appScreen = new JFrame("Password Bank");
        appScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Image icon = Toolkit.getDefaultToolkit().getImage("password-bank-icon.png");
        appScreen.setIconImage(icon);

        // Get a password from a username
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setBounds(20, 20, 80, 30);
        appScreen.add(usernameLabel);

        final JTextField userInput = new JTextField();
        userInput.setBounds(100, 20, 200, 30);
        appScreen.add(userInput);

        JButton getPasswordButton = new JButton("Get Password");
        getPasswordButton.setBounds(100, 60, 200, 30);
        getPasswordButton.addActionListener(e -> {
            try {
                playSoundAttempt();
                PasswordBank newBank = new PasswordBank();
                String bankResponse;
                bankResponse = newBank.getPair(userInput.getText());
                JOptionPane.showMessageDialog(appScreen, bankResponse);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        appScreen.add(getPasswordButton);

        // Add a username and password pair
        usernameLabel = new JLabel("Username: ");
        usernameLabel.setBounds(20, 140, 80, 30);
        appScreen.add(usernameLabel);

        final JTextField userInputTwo = new JTextField();
        userInputTwo.setBounds(100, 140, 200, 30);
        appScreen.add(userInputTwo);

        usernameLabel = new JLabel("Password: ");
        usernameLabel.setBounds(20, 180, 80, 30);
        appScreen.add(usernameLabel);

        JPasswordField newPassword = new JPasswordField();
        newPassword.setBounds(100, 180, 200, 30);
        appScreen.add(newPassword);

        JButton addPairButton = new JButton("Add Credentials");
        addPairButton.setBounds(100, 220, 200, 30);
        addPairButton.addActionListener(e -> {
            try {
                playSoundAttempt();
                PasswordBank newBank = new PasswordBank();
                String bankResponse;
                bankResponse = newBank.addPair(userInputTwo.getText(), new String(newPassword.getPassword()));
                JOptionPane.showMessageDialog(appScreen, bankResponse);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        appScreen.add(addPairButton);

        // Delete username and password pair
        usernameLabel = new JLabel("Username: ");
        usernameLabel.setBounds(20, 300, 80, 30);
        appScreen.add(usernameLabel);

        final JTextField userInputThree = new JTextField();
        userInputThree.setBounds(100, 300, 200, 30);
        appScreen.add(userInputThree);

        JButton deletePairButton = new JButton("Delete Credentials");
        deletePairButton.setBounds(100, 340, 200, 30);
        deletePairButton.addActionListener(e -> {
            try {
                playSoundAttempt();
                PasswordBank newBank = new PasswordBank();
                String bankResponse;
                bankResponse = newBank.deletePair(userInputThree.getText());
                JOptionPane.showMessageDialog(appScreen, bankResponse);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        appScreen.add(deletePairButton);

        // Clear all credentials
        JButton deleteAllButton = new JButton("Clear All Credentials");
        deleteAllButton.setBounds(100, 420, 200, 30);
        deleteAllButton.addActionListener(e -> {
            try {
                playSoundAttempt();
                PasswordBank newBank = new PasswordBank();
                String bankResponse;
                bankResponse = newBank.clearBank();
                JOptionPane.showMessageDialog(appScreen, bankResponse);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        appScreen.add(deleteAllButton);

        // Finish setting up application
        appScreen.setSize(400, 600);
        appScreen.setLayout(null);
        appScreen.setVisible(true);
    }

    /**
     * Attempts to play the button sound and handles all exceptions.
     */
    private static void playSoundAttempt() {
        try {
            String soundName = "button-sound.wav";
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ignored) {
        }
    }
}
