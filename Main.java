import javax.swing.*;


/**
 * This is a small project to improve on my Java skills!
 * The idea is that when the program runs, a small window appears. You can:
 * 1) Save a new password and username pair to the bank
 * 2) Enter a username and get the password matching that.
 * 3) Delete an existing username and it's password
 *
 * @author Logan Czernel
 * @since 02-10-2018
 */


public class Main {

    /**
     * Runs the program.
     */

    public static void main(String[] args) {
        JFrame appScreen = new JFrame("Password Bank");

        // Get a password from a username
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setBounds(20, 20, 80, 30);
        appScreen.add(usernameLabel);

        JButton getPasswordButton = new JButton("Get Password");
        getPasswordButton.setBounds(100, 60, 200, 30);

        final JTextField userInput = new JTextField();
        userInput.setBounds(100,20, 200,30);
        appScreen.add(userInput);

        getPasswordButton.addActionListener(e -> {
            try {
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
        userInputTwo.setBounds(100,140, 200,30);
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

        JButton deletePairButton = new JButton("Delete Credentials");
        deletePairButton.setBounds(100, 340, 200, 30);

        final JTextField userInputThree = new JTextField();
        userInputThree.setBounds(100,300, 200,30);
        appScreen.add(userInputThree);

        deletePairButton.addActionListener(e -> {
            try {
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
                PasswordBank newBank = new PasswordBank();
                String bankResponse;
                bankResponse = newBank.clearBank();
                JOptionPane.showMessageDialog(appScreen, bankResponse);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        appScreen.add(deleteAllButton);


        appScreen.setSize(400, 600);
        appScreen.setLayout(null);
        appScreen.setVisible(true);
    }
}
