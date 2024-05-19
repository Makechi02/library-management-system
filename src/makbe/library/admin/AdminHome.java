package makbe.library.admin;

import makbe.library.UI.HomePanel;
import makbe.library.constants.UserType;
import makbe.library.constants.WindowActions;

import javax.swing.*;
import java.awt.*;

import static makbe.library.constants.Fonts.*;

public class AdminHome extends JFrame {
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int width = screen.width - 100;
    int height = screen.height - 100;

    public AdminHome(JDialog dialog, String name) {
        super("Administrator Panel");
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel label;
        JPanel topBar = new JPanel();
        JPanel bottomBar = new JPanel();

        topBar.setBackground(Color.BLACK);
        topBar.setBounds(0, 0, width, 50);
        topBar.setLayout(null);

        label = new JLabel("MAKBE UNIVERSITY");
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

        add(topBar);

        JTabbedPane optionsPane = new JTabbedPane(JTabbedPane.LEFT);
        optionsPane.setBounds(10, 55, width - 40, 530);
        optionsPane.setFont(displayFont);
		optionsPane.add("Home", new HomePanel(UserType.ADMIN));
        optionsPane.add("Add Librarian", new AddLibrarianPanel());
        optionsPane.add("View Librarian", new ViewLibrarianPanel());
//        optionsPane.add("Library Report", new LibraryReportPanel());
//        optionsPane.add("Academy Settings", new AcademySettingsPanel());
//        optionsPane.add("Library Settings", new LibrarySettingsPanel());
//        optionsPane.add("MySQL Settings", new mysqlSettingsPanel());
//        optionsPane.add("FTP Settings", new ftpSettingsPanel());
//        optionsPane.add("Messenger Settings", new messengerSettingsPanel());
//        optionsPane.add("Generate Backup", new backupPanel());
//        optionsPane.add("Notice Board", new noticeBoardPanel());
        optionsPane.add("Change Password", new PasswordPanel(name));
        add(optionsPane);

        bottomBar.setBackground(Color.BLACK);
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

		JRadioButton connected = new JRadioButton("Database Connected. ");
		connected.setBackground(Color.BLACK);
        connected.setForeground(Color.WHITE);
        connected.setHorizontalAlignment(JRadioButton.RIGHT);
        connected.setFont(new Font(defaultFont.getFontName(), Font.PLAIN, 13));
		boolean connect = false;
		connected.setSelected(connect);
        bottomBar.add(connected);

        add(bottomBar);

        WindowActions.changeLookAndFeel(this);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AdminHome(new JDialog(), "user");
    }

}
