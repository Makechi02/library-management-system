package makbe.library.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddLibrarianPanel extends JPanel implements ActionListener {

import static makbe.library.constants.Fonts.defaultFont;
import static makbe.library.constants.Fonts.displayFont;

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

		JLabel label = new JLabel("NAME:");
		label.setBounds(50, 50, 150, 40);
		label.setFont(displayFont);
		label.setVerticalAlignment(JLabel.CENTER);
		add(label);

		nameField.setBounds(260, 50, 300, 40);
		nameField.setFont(displayFont);
		add(nameField);

		label = new JLabel("STAFF ID:");
		label.setBounds(50, 110, 150, 40);
		label.setFont(displayFont);
		label.setVerticalAlignment(JLabel.CENTER);
		add(label);

		staffIdField.setBounds(260, 110, 300, 40);
		staffIdField.setFont(displayFont);
		add(staffIdField);

		label = new JLabel("EMAIL:");
		label.setBounds(50, 170, 150, 40);
		label.setFont(displayFont);
		label.setVerticalAlignment(JLabel.CENTER);
		add(label);

		emailField.setBounds(260, 170, 300, 40);
		emailField.setFont(displayFont);
		add(emailField);

		label = new JLabel("PASSWORD:");
		label.setBounds(50, 230, 150, 40);
		label.setFont(displayFont);
		label.setVerticalAlignment(JLabel.CENTER);
		add(label);

		passwordField.setBounds(260, 230, 300, 40);
		passwordField.setFont(displayFont);
		add(passwordField);

		label = new JLabel("CONFIRM PASSWORD:");
		label.setBounds(50, 290, 200, 40);
		label.setFont(new Font(defaultFont.getFontName(), Font.PLAIN, 18));
		label.setVerticalAlignment(JLabel.CENTER);
		add(label);

		confirmField.setBounds(260, 290, 300, 40);
		confirmField.setFont(displayFont);
		add(confirmField);

		detailsArea.setBounds(620, 50, 350, 290);
		detailsArea.setFont(displayFont);
		detailsArea.setEditable(false);
		detailsArea.setFocusable(false);
		add(detailsArea);

		JButton previewButton = new JButton("Preview");
		previewButton.setBounds(690, 410, 100, 40);
		previewButton.setFont(displayFont);
		previewButton.addActionListener(e -> handlePreview());
		add(previewButton);

		JButton acceptButton = new JButton("Accept");
		acceptButton.setBounds(800, 410, 100, 40);
		acceptButton.setFont(displayFont);
		acceptButton.addActionListener(e -> handleSaveLibrarian());
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
