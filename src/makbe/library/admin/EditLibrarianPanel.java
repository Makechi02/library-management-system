package makbe.library.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditLibrarianPanel extends JPanel implements ActionListener {

    private final JTextField searchField = new JTextField();
    private final JButton searchButton = new JButton("Search");

    JTextField nameField = new JTextField();
    JTextField staffIdField = new JTextField();
    JTextField usernameField = new JTextField();
    JTextField emailField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmField = new JPasswordField();
    JTextArea detailsArea = new JTextArea(" Details:");
    JButton previewButton = new JButton("Preview");
    JButton acceptButton = new JButton("Accept");

    EditLibrarianPanel() {
        setLayout(null);

        Font font = new Font("Iosevka Term", Font.PLAIN, 20);

        JLabel label = new JLabel("Search by staff ID  or username:");
        label.setBounds(50, 20, 400, 40);
        label.setFont(font);
        add(label);

        searchField.setFont(font);
        searchField.setBounds(450, 20, 350, 40);
        add(searchField);

        searchButton.setBounds(830, 20, 150, 40);
        searchButton.setFont(font);
        add(searchButton);


        label = new JLabel("NAME:");
        label.setBounds(50, 100, 150, 40);
        label.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        label.setVerticalAlignment(JLabel.CENTER);
        add(label);

        nameField.setBounds(230, 100, 300, 40);
        nameField.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        add(nameField);

        label = new JLabel("Staff ID:");
        label.setBounds(50, 160, 150, 40);
        label.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        label.setVerticalAlignment(JLabel.CENTER);
        add(label);

        staffIdField.setBounds(230, 160, 300, 40);
        staffIdField.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        add(staffIdField);

        label = new JLabel("USERNAME:");
        label.setBounds(50, 220, 150, 40);
        label.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        label.setVerticalAlignment(JLabel.CENTER);
        add(label);

        usernameField.setBounds(230, 220, 300, 40);
        usernameField.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        add(usernameField);

        label = new JLabel("EMAIL:");
        label.setBounds(50, 280, 150, 40);
        label.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        label.setVerticalAlignment(JLabel.CENTER);
        add(label);

        emailField.setBounds(230, 280, 300, 40);
        emailField.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        add(emailField);

        label = new JLabel("PASSWORD:");
        label.setBounds(50, 340, 150, 40);
        label.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        label.setVerticalAlignment(JLabel.CENTER);
        add(label);

        passwordField.setBounds(230, 340, 300, 40);
        passwordField.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        add(passwordField);

        label = new JLabel("CONFIRM PASSWORD:");
        label.setBounds(50, 400, 200, 40);
        label.setFont(new Font("Iosevka Term", Font.PLAIN, 18));
        label.setVerticalAlignment(JLabel.CENTER);
        add(label);

        confirmField.setBounds(230, 400, 300, 40);
        confirmField.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        add(confirmField);

        detailsArea.setBounds(620, 100, 350, 340);
        detailsArea.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        detailsArea.setEditable(false);
        detailsArea.setFocusable(false);
        add(detailsArea);

        previewButton.setBounds(690, 460, 100, 40);
        previewButton.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        previewButton.addActionListener(this);
        add(previewButton);

        acceptButton.setBounds(800, 460, 100, 40);
        acceptButton.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        acceptButton.setEnabled(false);
        acceptButton.addActionListener(this);
        add(acceptButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
