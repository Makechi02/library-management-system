package makbe.library.main;

import makbe.library.service.AuthService;
import makbe.library.student.StudentHome;

import javax.swing.*;
import java.awt.*;

import static makbe.library.constants.Fonts.defaultFont;

public class StudentLogin extends JDialog {
	private final JTextField regNoField = new JTextField();
	private final JPasswordField passwordField = new JPasswordField();

	StudentLogin(Login owner) {
		super(owner, "Student Login", true);
		setResizable(false);
		setSize(owner.width, owner.height);
		setLocationRelativeTo(owner);
		setLayout(null);

		JPanel buttonsPanel = new JPanel();
		Font font = new Font(defaultFont.getFontName(), Font.PLAIN, 16);

		JLabel label = new JLabel("REG. NO.:");
		label.setBounds(100, 50, 100, 40);
		label.setFont(font);
		add(label);

		regNoField.setBounds(250, 50, 300, 40);
		regNoField.setFont(font);
		add(regNoField);

		label = new JLabel("PASSWORD:");
		label.setBounds(100, 120, 100, 40);
		label.setFont(font);
		add(label);

		passwordField.setBounds(250, 120, 300, 40);
		passwordField.setFont(font);
		add(passwordField);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setFont(font);
		cancelButton.addActionListener(e -> {
			setVisible(false);
			owner.setVisible(true);
		});
		buttonsPanel.add(cancelButton);

		JButton loginButton = new JButton("Login");
		loginButton.setFont(font);
		loginButton.addActionListener(e -> {
			if (loginValidate()) {
				erasePassword();
				setVisible(false);
				new StudentHome(this, regNoField.getText());
			} else {
				erasePassword();
			}
		});
		buttonsPanel.add(loginButton);

		buttonsPanel.setBounds(0, 200, owner.width, 50);
		add(buttonsPanel);

		setVisible(true);
	}

	private boolean loginValidate() {
		String regNo = regNoField.getText();
		String password = String.valueOf(passwordField.getPassword());

		if (regNo.isBlank() || password.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please Fill Out All Fields!", null, JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			AuthService authService = new AuthService();
			return authService.authenticateStudent(regNo, password);
		}
	}

	private void erasePassword() {
		passwordField.setText("");
	}

}
