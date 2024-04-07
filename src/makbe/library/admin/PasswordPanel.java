package makbe.library.admin;

import makbe.library.connections.ConnectionsII;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import static makbe.library.constants.Fonts.displayFont;

	private final JPasswordField oldPasswordField = new JPasswordField();
	private final JPasswordField newPasswordField = new JPasswordField();
	private final JPasswordField confirmPasswordField = new JPasswordField();

	String user;
	ConnectionsII connectionsII = new ConnectionsII();

	passwordPanel(String username) {
		setLayout(null);
		this.user = username;

		Font font = new Font("Iosevka Term", Font.PLAIN, 20);

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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!Objects.equals(newPasswordField.getText(), confirmPasswordField.getText()))
			JOptionPane.showMessageDialog(this, "Passwords Don't Match!", null, JOptionPane.ERROR_MESSAGE);
		else {
			if (connectionsII.updatePassword(user, oldPasswordField.getText(), confirmPasswordField.getText())) {
				JOptionPane.showMessageDialog(this, "Password Updated Successfully", null, JOptionPane.INFORMATION_MESSAGE);
				erasePassword();
			} else {
				JOptionPane.showMessageDialog(this, "Incorrect Credentials!", null, JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void erasePassword() {
		oldPasswordField.setText("");
		newPasswordField.setText("");
		confirmPasswordField.setText("");
	}

}
