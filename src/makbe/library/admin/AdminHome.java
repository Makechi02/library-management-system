package makbe.library.admin;

import javax.swing.*;
import java.awt.*;

public class AdminHome extends JFrame {

    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int width = screen.width - 100;
    int height = screen.height - 100;

    JPanel topBar = new JPanel();
    JLabel universityLabel = new JLabel("MAKBE UNIVERSITY");
    JButton home = new JButton("Home");
    JButton signOut = new JButton("Sign Out");

    JPanel bottomBar = new JPanel();

    UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();

    AdminHome() {
        super("Administrator Panel");
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setFont(new Font("Iosevka Term", Font.PLAIN, 20));

        topBar.setBackground(Color.BLACK);
        topBar.setBounds(0, 0, width, 50);
        topBar.setLayout(null);

        //universityLabel.setIcon(new ImageIcon("image1.jpg"));
        universityLabel.setBounds(20, 0, 250, 50);
        universityLabel.setHorizontalAlignment(JLabel.CENTER);
        universityLabel.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        universityLabel.setForeground(Color.WHITE);
        topBar.add(universityLabel);

        home.setBounds(900, 10, 100, 30);
        home.setFont(new Font("Iosevka Term", Font.PLAIN, 16));
        topBar.add(home);

        signOut.setBounds(1020, 10, 100, 30);
        signOut.setFont(new Font("Iosevka Term", Font.PLAIN, 16));
        topBar.add(signOut);

        add(topBar);

        JTabbedPane optionsPane = new JTabbedPane(JTabbedPane.LEFT);
        optionsPane.setBounds(10, 55, width - 40, 530);
        optionsPane.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        optionsPane.add("Home", new HomePanel());
        optionsPane.add("Add Librarian", new AddLibrarianPanel());
        optionsPane.add("Edit Librarian", new EditLibrarianPanel());
        optionsPane.add("View Librarian", new ViewLibrarianPanel());
        optionsPane.add("Library Report", new LibraryReportPanel());
        optionsPane.add("Academy Settings", new AcademySettingsPanel());
        optionsPane.add("Library Settings", new LibrarySettingsPanel());
        optionsPane.add("MySQL Settings", new mysqlSettingsPanel());
        optionsPane.add("FTP Settings", new ftpSettingsPanel());
        optionsPane.add("Messenger Settings", new messengerSettingsPanel());
        optionsPane.add("Generate Backup", new backupPanel());
        optionsPane.add("Notice Board", new noticeBoardPanel());
        optionsPane.add("Change Password", new passwordPanel());
        add(optionsPane);

        bottomBar.setBackground(Color.BLACK);
        bottomBar.setForeground(Color.WHITE);
        bottomBar.setBounds(0, 590, width, 40);
        add(bottomBar);

        try {
            UIManager.setLookAndFeel(looks[3].getClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        setVisible(true);
    }

}
