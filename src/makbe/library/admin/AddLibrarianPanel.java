package makbe.library.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddLibrarianPanel extends JPanel implements ActionListener {

    JLabel label;

    JTextField nameField = new JTextField();
    JTextField staffIdField = new JTextField();
    JTextField usernameField = new JTextField();
    JTextField emailField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmField = new JPasswordField();
    JLabel noMatch = new JLabel("* Passwords don't match! *");

    JTextArea detailsArea = new JTextArea("Details:");
    JButton previewButton = new JButton("Preview");
    JButton acceptButton = new JButton("Accept");

    AddLibrarianPanel() {
        //setBackground(Color.GRAY);
        setLayout(null);

        label = new JLabel("NAME:");
        label.setBounds(50, 50, 150, 40);
        label.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        label.setVerticalAlignment(JLabel.CENTER);
        add(label);

        nameField.setBounds(230, 50, 300, 40);
        nameField.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        add(nameField);

        label = new JLabel("Staff ID:");
        label.setBounds(50, 110, 150, 40);
        label.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        label.setVerticalAlignment(JLabel.CENTER);
        add(label);

        staffIdField.setBounds(230, 110, 300, 40);
        staffIdField.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        add(staffIdField);

        label = new JLabel("USERNAME:");
        label.setBounds(50, 170, 150, 40);
        label.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        label.setVerticalAlignment(JLabel.CENTER);
        add(label);

        usernameField.setBounds(230, 170, 300, 40);
        usernameField.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        add(usernameField);

        label = new JLabel("EMAIL:");
        label.setBounds(50, 230, 150, 40);
        label.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        label.setVerticalAlignment(JLabel.CENTER);
        add(label);

        emailField.setBounds(230, 230, 300, 40);
        emailField.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        add(emailField);

        label = new JLabel("PASSWORD:");
        label.setBounds(50, 290, 150, 40);
        label.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        label.setVerticalAlignment(JLabel.CENTER);
        add(label);

        passwordField.setBounds(230, 290, 300, 40);
        passwordField.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        add(passwordField);

        label = new JLabel("CONFIRM PASSWORD:");
        label.setBounds(50, 350, 200, 40);
        label.setFont(new Font("Iosevka Term", Font.PLAIN, 18));
        label.setVerticalAlignment(JLabel.CENTER);
        add(label);

        confirmField.setBounds(230, 350, 300, 40);
        confirmField.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        add(confirmField);

        noMatch.setForeground(Color.RED);
        noMatch.setHorizontalAlignment(JLabel.CENTER);
        noMatch.setFont(new Font("Iosevka Term", Font.PLAIN, 18));
        add(noMatch);

        detailsArea.setBounds(620, 50, 350, 340);
        detailsArea.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        detailsArea.setEditable(false);
        detailsArea.setFocusable(false);
        add(detailsArea);

        previewButton.setBounds(690, 410, 100, 40);
        previewButton.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        previewButton.addActionListener(this);
        add(previewButton);

        acceptButton.setBounds(800, 410, 100, 40);
        acceptButton.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        acceptButton.setEnabled(false);
        acceptButton.addActionListener(this);
        add(acceptButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == previewButton) {
            if (validatePassword()) {
                detailsArea.append(
                        "\n\nName: " + nameField.getText() +
                        "\nStaff ID: " + staffIdField.getText() +
                        "\nUsername: " + usernameField.getText() +
                        "\nEmail: " + emailField.getText()
                );
                acceptButton.setEnabled(true);
            } else {
                noMatch.setBounds(50, 400, 420, 40);
            }

        } else if (e.getSource() == acceptButton) {
            nameField.setText("");
            staffIdField.setText("");
            usernameField.setText("");
            emailField.setText("");
            passwordField.setText("");
            confirmField.setText("");
            acceptButton.setEnabled(false);
        }
    }

    public boolean validatePassword() {
        String password = passwordField.getText();
        String confirm = confirmField.getText();

        return password.equals(confirm);

    }

}
