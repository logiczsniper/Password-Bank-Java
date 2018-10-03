import javax.swing.*;


/**
 * This is a small project to improve on my Java skills!
 * The idea is that when the program runs, a small window appears. You can:
 * 1) Save a new password and username pair to the bank
 * 2) Enter a username and get the password matching that.
 * 3) Enter a password and get the username matching that.
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
        JTextField t1, t2;
        t1 = new JTextField("Welcome to Logan's Password Bank!");
        t1.setBounds(50, 100, 200, 30);
        t2 = new JTextField("Yo.");
        t2.setBounds(50, 150, 200, 30);
        appScreen.add(t1);
        appScreen.add(t2);
        appScreen.setSize(400, 400);
        appScreen.setLayout(null);
        appScreen.setVisible(true);

        PasswordBank newBank = new PasswordBank();
        System.out.println(newBank.bank);
    }
}
