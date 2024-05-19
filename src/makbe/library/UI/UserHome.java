package makbe.library.UI;

import makbe.library.constants.WindowActions;

import javax.swing.*;
import java.awt.*;

import static makbe.library.constants.Fonts.buttonFont;
import static makbe.library.constants.Fonts.defaultFont;

public class UserHome extends JFrame {
	private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private final int width = screen.width - 100;

	public UserHome(JDialog dialog, String title, JPanel optionsPanel) {
		super(title);
		setSize(width, (screen.height - 100));
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		Color accent = Color.BLACK;

		add(getTopBar(dialog, accent));

		optionsPanel.setBounds(10, 55, width - 40, 530);
		add(optionsPanel);

		add(getBottomBar(accent));

		WindowActions.changeLookAndFeel(this);
		setVisible(true);
	}

	private JPanel getTopBar(Dialog dialog, Color accent) {
		JPanel topBar = new JPanel();

		topBar.setBackground(accent);
		topBar.setBounds(0, 0, width, 50);
		topBar.setLayout(null);

		JLabel label = new JLabel("MAKBE UNIVERSITY");
		label.setBounds(20, 0, 250, 50);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font(defaultFont.getFontName(), Font.BOLD, 22));
		label.setForeground(Color.WHITE);
		topBar.add(label);

		JButton signOut = new JButton("Sign Out");
		signOut.setBounds(1020, 10, 100, 30);
		signOut.setFont(buttonFont);
		signOut.addActionListener(e -> {
			setVisible(false);
			dialog.setVisible(true);
		});
		topBar.add(signOut);

		return topBar;
	}

	private JPanel getBottomBar(Color accent) {
		JPanel bottomBar = new JPanel();
		bottomBar.setBackground(accent);
		bottomBar.setBounds(0, 600, width, 40);
		bottomBar.setLayout(new GridLayout(1, 3));

		JLabel developer = new JLabel(" Developed by Makechi™");
		developer.setForeground(Color.WHITE);
		developer.setFont(new Font(defaultFont.getFontName(), Font.PLAIN, 13));
		bottomBar.add(developer);

		JLabel version = new JLabel("Library Management System | Version 1.0");
		version.setForeground(Color.WHITE);
		version.setHorizontalAlignment(JLabel.CENTER);
		version.setFont(new Font(defaultFont.getFontName(), Font.PLAIN, 13));
		bottomBar.add(version);

		JRadioButton connected = new JRadioButton("Database Connected.");
		connected.setBackground(accent);
		connected.setForeground(Color.WHITE);
		connected.setHorizontalAlignment(JRadioButton.RIGHT);
		connected.setFont(new Font(defaultFont.getFontName(), Font.PLAIN, 13));
		boolean connect = false;
		connected.setSelected(connect);
		bottomBar.add(connected);

		return bottomBar;
	}

	public static void main(String[] args) {
		new UserHome(new JDialog(), "user panel", new JPanel());
	}

}
