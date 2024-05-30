package makbe.library.admin;

import makbe.library.constants.Gender;
import makbe.library.model.Librarian;

import javax.swing.*;
import java.awt.*;

import static makbe.library.constants.Fonts.defaultFont;
import static makbe.library.constants.Fonts.displayFont;

public class AddLibrarianPanel extends JPanel {
	private final JTextField nameField = new JTextField();
	private final JTextField staffIdField = new JTextField();
	private final JTextField emailField = new JTextField();
	private final JPasswordField passwordField = new JPasswordField();
	private final JPasswordField confirmField = new JPasswordField();
	private final JComboBox<Gender> genderBox = new JComboBox<>(Gender.values());
	private final JTextArea detailsArea = new JTextArea("Details:");

	AddLibrarianPanel() {
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

		label = new JLabel("GENDER:");
		label.setBounds(50, 230, 200, 40);
		label.setFont(new Font(defaultFont.getFontName(), Font.PLAIN, 18));
		label.setVerticalAlignment(JLabel.CENTER);
		add(label);

		genderBox.setBounds(260, 230, 300, 40);
		genderBox.setFont(displayFont);
		add(genderBox);

		label = new JLabel("PASSWORD:");
		label.setBounds(50, 290, 150, 40);
		label.setFont(displayFont);
		label.setVerticalAlignment(JLabel.CENTER);
		add(label);

		passwordField.setBounds(260, 290, 300, 40);
		passwordField.setFont(displayFont);
		add(passwordField);

		label = new JLabel("CONFIRM PASSWORD:");
		label.setBounds(50, 350, 200, 40);
		label.setFont(new Font(defaultFont.getFontName(), Font.PLAIN, 18));
		label.setVerticalAlignment(JLabel.CENTER);
		add(label);

		confirmField.setBounds(260, 350, 300, 40);
		confirmField.setFont(displayFont);
		add(confirmField);

		detailsArea.setBounds(620, 50, 350, 290);
		detailsArea.setFont(displayFont);
		detailsArea.setEditable(false);
		detailsArea.setFocusable(false);
		add(detailsArea);

		JButton previewButton = new JButton("Preview");
		previewButton.setBounds(690, 410, 100, 40);
		previewButton.setFont(buttonFont);
		previewButton.addActionListener(e -> handlePreview());
		add(previewButton);

		JButton acceptButton = new JButton("Accept");
		acceptButton.setBounds(800, 410, 100, 40);
		acceptButton.setFont(buttonFont);
		acceptButton.addActionListener(e -> handleSaveLibrarian());
		add(acceptButton);

		setVisible(true);
	}

	private void handlePreview() {
		if (!validateFields()) {
			JOptionPane.showMessageDialog(this, "Please fill out all fields!", null, JOptionPane.WARNING_MESSAGE);
			return;
		}

		if (validatePassword()) {
			String gender = Objects.requireNonNull(genderBox.getSelectedItem()).toString();

			detailsArea.setText("");
			detailsArea.setText(
					"Details:" + "\n\nName: " + nameField.getText() +
							"\nStaff ID: " + staffIdField.getText() +
							"\nEmail: " + emailField.getText() +
							"\n Gender: " + gender.toLowerCase()
			);
		} else {
			JOptionPane.showMessageDialog(this, "Passwords don't match!", null, JOptionPane.WARNING_MESSAGE);
		}
	}

	private void handleSaveLibrarian() {
		String name = nameField.getText();
		String id = staffIdField.getText();
		String email = emailField.getText();
		String password = String.valueOf(passwordField.getPassword());

		if (validateFields()) {
			if (validatePassword()) {
				Connections connections = Connections.getInstance();
				int rows = connections.saveLibrarian(new Librarian(id, name, email, password));
				if (rows >= 1) {
					JOptionPane.showMessageDialog(this, "Librarian added successfully", null, JOptionPane.INFORMATION_MESSAGE);
					clearFields();
				} else {
					JOptionPane.showMessageDialog(this, "An error occurred", null, JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "Passwords don't match!", null, JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Please fill out all fields!", null, JOptionPane.WARNING_MESSAGE);
		}
	}

	private boolean validateFields() {
		String name = nameField.getText();
		String id = staffIdField.getText();
		String email = emailField.getText();
		String password = String.valueOf(passwordField.getPassword());
		String confirm = String.valueOf(confirmField.getPassword());

		return !name.isBlank() && !id.isBlank() && !email.isBlank() && !password.isEmpty() && !confirm.isEmpty();
	}

	private void clearFields() {
		nameField.setText("");
		staffIdField.setText("");
		emailField.setText("");
		passwordField.setText("");
		confirmField.setText("");
		detailsArea.setText("");
	}

	public boolean validatePassword() {
		String password = String.valueOf(passwordField.getPassword());
		String confirm = String.valueOf(confirmField.getPassword());
		return password.equals(confirm);
	}

}
