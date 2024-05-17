package makbe.library.admin;

import makbe.library.service.AuthService;

import javax.swing.*;

import static makbe.library.constants.Fonts.displayFont;

public class PasswordPanel extends JPanel {
	private final JPasswordField oldPasswordField = new JPasswordField();
	private final JPasswordField newPasswordField = new JPasswordField();
	private final JPasswordField confirmPasswordField = new JPasswordField();

	String user;

	PasswordPanel(String username) {
		setLayout(null);
		this.user = username;

		JLabel label = new JLabel("ENTER OLD PASSWORD:");
		label.setBounds(150, 100, 500, 40);
		label.setFont(displayFont);
		add(label);

		oldPasswordField.setBounds(250, 150, 400, 40);
		oldPasswordField.setFont(displayFont);
		add(oldPasswordField);

		label = new JLabel("ENTER NEW PASSWORD:");
		label.setBounds(150, 210, 500, 40);
		label.setFont(displayFont);
		add(label);

		newPasswordField.setBounds(250, 260, 400, 40);
		newPasswordField.setFont(displayFont);
		add(newPasswordField);

		label = new JLabel("CONFIRM NEW PASSWORD:");
		label.setBounds(150, 320, 500, 40);
		label.setFont(displayFont);
		add(label);

		confirmPasswordField.setBounds(250, 370, 400, 40);
		confirmPasswordField.setFont(displayFont);
		add(confirmPasswordField);

		JButton changeButton = new JButton("Change");
		changeButton.setBounds(360, 430, 150, 40);
		changeButton.setFont(displayFont);
		changeButton.addActionListener(e -> handleUpdate());
		add(changeButton);
	}

	private void handleUpdate() {
		String oldPassword = String.valueOf(oldPasswordField.getPassword());
		String newPassword = String.valueOf(newPasswordField.getPassword());
		String confirmPassword = String.valueOf(confirmPasswordField.getPassword());

		AuthService authService = new AuthService();

		if (oldPassword.isBlank() || newPassword.isBlank() || confirmPassword.isBlank()) {
			JOptionPane.showMessageDialog(this, "Password can't be blank", null, JOptionPane.WARNING_MESSAGE);
			return;
		}

		if (!newPassword.equals(confirmPassword)) {
			JOptionPane.showMessageDialog(this, "Passwords don't match", null, JOptionPane.WARNING_MESSAGE);
		} else {
			if (!authService.authenticateAdmin(user, oldPassword)) {
				JOptionPane.showMessageDialog(this, "Incorrect password", null, JOptionPane.WARNING_MESSAGE);
			} else {
				if (authService.updateAdminPassword(user, newPassword)) {
					JOptionPane.showMessageDialog(this, "Password Updated Successfully", null, JOptionPane.INFORMATION_MESSAGE);
					erasePasswordFields();
				} else {
					JOptionPane.showMessageDialog(this, "An error occurred!", null, JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	private void erasePasswordFields() {
		oldPasswordField.setText("");
		newPasswordField.setText("");
		confirmPasswordField.setText("");
	}

}
