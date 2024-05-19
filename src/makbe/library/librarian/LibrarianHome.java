package makbe.library.librarian;

import javax.swing.*;
import java.awt.*;

import makbe.library.UI.HomePanel;
import makbe.library.constants.UserType;
import makbe.library.constants.WindowActions;
import static makbe.library.constants.Fonts.*;

public class LibrarianHome extends JFrame {
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int width = screen.width - 100;
    int height = screen.height - 100;

	public LibrarianHome(JDialog dialog, String user) {
        super("Librarian Panel");
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setFont(displayFont);

		JPanel topBar = new JPanel();
		Color accent = Color.BLACK;
		topBar.setBackground(accent);
        topBar.setBounds(0, 0, width, 50);
        topBar.setLayout(null);

		JLabel universityLabel = new JLabel("MAKBE UNIVERSITY");
		universityLabel.setBounds(20, 0, 250, 50);
        universityLabel.setHorizontalAlignment(JLabel.CENTER);
        universityLabel.setFont(displayFont);
        universityLabel.setForeground(Color.WHITE);
        topBar.add(universityLabel);

		JButton signOut = new JButton("Sign Out");
		signOut.setBounds(1020, 10, 100, 30);
        signOut.setFont(buttonFont);
        signOut.addActionListener(e -> {
            setVisible(false);
            dialog.setVisible(true);
        });
        topBar.add(signOut);

        add(topBar);

        JTabbedPane optionsPane = new JTabbedPane(JTabbedPane.LEFT);
        optionsPane.setBounds(10, 55, width - 40, 530);
        optionsPane.setFont(displayFont);
        optionsPane.add("Home", new HomePanel(UserType.LIBRARIAN));
//        optionsPane.add("Manage Student", new ManageStudentPanel());
//        optionsPane.add("Manage Book", new ManageBookPanel());
//        optionsPane.add("Search Book", new SearchBookPanel());
//        optionsPane.add("Manage Borrower", new ManageBorrowerPanel());
//        optionsPane.add("Book Request", new BookRequestPanel());
//        optionsPane.add("Report", new ReportPanel());
//        optionsPane.add("Soft Book", new SoftBookPanel());
//        optionsPane.add("Upload Book", new UploadBookPanel());
//        optionsPane.add("Messenger", new MessengerPanel());
//        optionsPane.add("Notice Board", new LibrarianNoticeBoardPanel());
//        optionsPane.add("Edit Profile", new ProfilePanel());
        optionsPane.add("Change Password", new LibrarianPasswordPanel(user));
        add(optionsPane);

		JPanel bottomBar = getBottomBar(accent);

		add(bottomBar);

        WindowActions.changeLookAndFeel(this);

        setVisible(true);

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
        new LibrarianHome(new JDialog(), "user");
    }

}
