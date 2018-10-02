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
        JFrame f = new JFrame("TextField Example");
        JTextField t1, t2;
        t1 = new JTextField("Welcome to Javatpoint.");
        t1.setBounds(50, 100, 200, 30);
        t2 = new JTextField("AWT Tutorial");
        t2.setBounds(50, 150, 200, 30);
        f.add(t1);
        f.add(t2);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);

        PasswordBank newBank = new PasswordBank();
        System.out.println(newBank.bank.get("Hello"));
    }
}
