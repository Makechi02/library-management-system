package makbe.library.admin;

import makbe.library.connections.Connections;
import makbe.library.model.Librarian;

import javax.swing.*;

import java.awt.*;

import static makbe.library.constants.Fonts.displayFont;

public class ViewLibrarianPanel extends JPanel {
	private final JTextField searchField = new JTextField();
	private final JTextField nameField = new JTextField();
	private final JTextField staffIdField = new JTextField();
	private final JTextField emailField = new JTextField();
	private final JTextField dateField = new JTextField();
	private final JTextField genderField = new JTextField();

	ViewLibrarianPanel() {
		setLayout(null);

		JLabel label = new JLabel("Search by staff ID:");
		label.setBounds(50, 20, 400, 40);
		label.setFont(displayFont);
		add(label);

		searchField.setFont(displayFont);
		searchField.setBounds(450, 20, 350, 40);
		add(searchField);

		JButton searchButton = new JButton("Search");
		searchButton.setBounds(830, 20, 150, 40);
		searchButton.setFont(displayFont);
		searchButton.addActionListener(e -> handleSearch());
		add(searchButton);

		label = new JLabel("NAME:");
		label.setBounds(50, 100, 150, 40);
		label.setFont(displayFont);
		label.setVerticalAlignment(JLabel.CENTER);
		add(label);

		nameField.setBounds(230, 100, 300, 40);
		nameField.setFont(displayFont);
		nameField.setEnabled(false);
		add(nameField);

		label = new JLabel("Staff ID:");
		label.setBounds(50, 160, 150, 40);
		label.setFont(displayFont);
		label.setVerticalAlignment(JLabel.CENTER);
		add(label);

		staffIdField.setBounds(230, 160, 300, 40);
		staffIdField.setFont(displayFont);
		staffIdField.setEnabled(false);
		add(staffIdField);

		label = new JLabel("EMAIL:");
		label.setBounds(50, 220, 150, 40);
		label.setFont(displayFont);
		label.setVerticalAlignment(JLabel.CENTER);
		add(label);

		emailField.setBounds(230, 220, 300, 40);
		emailField.setFont(displayFont);
		emailField.setEnabled(false);
		add(emailField);

		label = new JLabel("GENDER:");
		label.setBounds(50, 280, 150, 40);
		label.setFont(displayFont);
		label.setVerticalAlignment(JLabel.CENTER);
		add(label);

		genderField.setBounds(230, 280, 300, 40);
		genderField.setFont(displayFont);
		genderField.setEnabled(false);
		add(genderField);

		label = new JLabel("DATE ADDED:");
		label.setBounds(50, 340, 150, 40);
		label.setFont(displayFont);
		label.setVerticalAlignment(JLabel.CENTER);
		add(label);

		dateField.setBounds(230, 340, 300, 40);
		dateField.setFont(displayFont);
		dateField.setEnabled(false);
		add(dateField);

		JPanel imagePanel = new JPanel();
		imagePanel.setBackground(Color.BLACK);
		imagePanel.setBounds(620, 100, 350, 290);
		add(imagePanel);
	}

	private void handleSearch() {
		Connections connections = Connections.getInstance();
		String id = searchField.getText();

		if (!id.isBlank()) {
			Librarian librarian = connections.getLibrarianById(id);

			if (librarian == null) {
				JOptionPane.showMessageDialog(this, "No record found", null, JOptionPane.INFORMATION_MESSAGE);
			} else {
				nameField.setText(librarian.getName());
				staffIdField.setText(librarian.getId());
				emailField.setText(librarian.getEmail());
				dateField.setText(String.valueOf(librarian.getAddedDate()));
				genderField.setText(librarian.getGender().name());

				searchField.setText("");
			}
		}
	}

}
