package makbe.library.librarian;

import makbe.library.connections.ConnectionsII;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LibrarianPasswordPanel extends JPanel implements ActionListener {

	private final JPasswordField oldPasswordField = new JPasswordField();
	private final JPasswordField newPasswordField = new JPasswordField();
	private final JPasswordField confirmPasswordField = new JPasswordField();
	ConnectionsII connectionsII = new ConnectionsII();
	String user;

	LibrarianPasswordPanel(String user) {
		setLayout(null);
		this.user = user;

		Font font = new Font("Iosevka Term", Font.PLAIN, 20);

		JLabel label = new JLabel("ENTER OLD PASSWORD:");
		label.setBounds(150, 100, 200, 40);
		label.setFont(font);
		add(label);

		oldPasswordField.setBounds(250, 150, 400, 40);
		oldPasswordField.setFont(font);
		add(oldPasswordField);

		label = new JLabel("ENTER NEW PASSWORD:");
		label.setBounds(150, 210, 200, 40);
		label.setFont(font);
		add(label);

		newPasswordField.setBounds(250, 260, 400, 40);
		newPasswordField.setFont(font);
		add(newPasswordField);

		label = new JLabel("CONFIRM NEW PASSWORD:");
		label.setBounds(150, 320, 250, 40);
		label.setFont(font);
		add(label);

		confirmPasswordField.setBounds(250, 370, 400, 40);
		confirmPasswordField.setFont(font);
		add(confirmPasswordField);

		JButton changeButton = new JButton("Change");
		changeButton.setBounds(360, 430, 150, 40);
		changeButton.setFont(font);
		changeButton.addActionListener(this);
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
