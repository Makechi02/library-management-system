package makbe.library.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int width = screen.width / 2;
    int height = screen.height / 2;

    private final JButton adminButton = new JButton("Administrator");
    private final JButton librarianButton = new JButton("Librarian");
    private final JButton studentButton = new JButton("Student");

    UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();

    Login() {
        super("Library Management System");
        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        Font font = new Font("Iosevka Term", Font.PLAIN, 20);
        JPanel buttonsPanel = new JPanel();

        JLabel label = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        label.setBounds(0, 50, width, 35);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font("Iosevka Term", Font.PLAIN, 24));
        add(label);

        label = new JLabel("A Java Based University Library System");
        label.setBounds(0, 70, width, 50);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font("Iosevka Term", Font.PLAIN, 15));
        add(label);

        label = new JLabel("Log in as:");
        label.setBounds(0, 160, width, 30);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font("Iosevka Term", Font.PLAIN, 18));
        add(label);

        buttonsPanel.setBounds(0, 200, width, 50);

        adminButton.setFont(font);
        adminButton.addActionListener(this);
        buttonsPanel.add(adminButton);

        librarianButton.setFont(font);
        librarianButton.addActionListener(this);
        buttonsPanel.add(librarianButton);

        studentButton.setFont(font);
        studentButton.addActionListener(this);
        buttonsPanel.add(studentButton);

        add(buttonsPanel);

        try {
            UIManager.setLookAndFeel(looks[3].getClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminButton) {
            this.setVisible(false);
            new AdminLogin(this);
        } else if (e.getSource() == librarianButton) {
            this.setVisible(false);
            new LibrarianLogin(this);
        } else if (e.getSource() == studentButton) {
            this.setVisible(false);
            new StudentLogin(this);
        }
    }
}
