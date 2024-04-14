package makbe.library.main;

import makbe.library.constants.Fonts;
import makbe.library.constants.WindowActions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static makbe.library.constants.Fonts.*;

public class Login extends JFrame implements ActionListener {

	private final JButton adminButton = new JButton("Administrator");
	private final JButton librarianButton = new JButton("Librarian");
	private final JButton studentButton = new JButton("Student");
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	int width = screen.width / 2;
	int height = screen.height / 2;

	Login() {
		super("Library Management System");
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		JPanel buttonsPanel = new JPanel();

		JLabel label = new JLabel("LIBRARY MANAGEMENT SYSTEM");
		label.setBounds(0, 50, width, 35);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setFont(headingFont);
		add(label);

		label = new JLabel("A Java Based University Library System");
		label.setBounds(0, 70, width, 50);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setFont(subHeadingFont);
		add(label);

		label = new JLabel("Log in as:");
		label.setBounds(0, 160, width, 30);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setFont(new Font(defaultFont.getFontName(), Font.PLAIN, 18));
		add(label);

		buttonsPanel.setBounds(0, 200, width, 50);

		adminButton.setFont(Fonts.displayFont);
		adminButton.addActionListener(this);
		buttonsPanel.add(adminButton);

		librarianButton.setFont(Fonts.displayFont);
		librarianButton.addActionListener(this);
		buttonsPanel.add(librarianButton);

		studentButton.setFont(Fonts.displayFont);
		studentButton.addActionListener(this);
		buttonsPanel.add(studentButton);

		add(buttonsPanel);

		WindowActions.changeLookAndFeel(this);
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
