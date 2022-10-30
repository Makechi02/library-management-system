package makbe.library.student;

import javax.swing.*;
import java.awt.*;

public class StudentHome extends JFrame {

    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int width = screen.width - 100;
    int height = screen.height - 100;

    JPanel topBar = new JPanel();
    JButton signOut = new JButton("Sign Out");

    JPanel bottomBar = new JPanel();

    UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();

    Color accent = Color.PINK;

    public StudentHome(JDialog dialog, String user) {
        super("Student Panel");
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setFont(new Font("Iosevka Term", Font.PLAIN, 20));

        topBar.setBackground(accent);
        topBar.setBounds(0, 0, width, 50);
        topBar.setLayout(null);

        JLabel label = new JLabel("MAKBE UNIVERSITY");
        //label.setIcon(new ImageIcon("image1.jpg"));
        label.setBounds(20, 0, 250, 50);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        label.setForeground(Color.WHITE);
        topBar.add(label);

        signOut.setBounds(1020, 10, 100, 30);
        signOut.setFont(new Font("Iosevka Term", Font.PLAIN, 16));
        signOut.addActionListener(e -> {
            setVisible(false);
            dialog.setVisible(true);
        });
        topBar.add(signOut);

        add(topBar);

        JTabbedPane optionsPane = new JTabbedPane(JTabbedPane.LEFT);
        optionsPane.setBounds(10, 55, width - 40, 530);
        optionsPane.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        optionsPane.add("Profile", new StudentProfilePanel());
        optionsPane.add("Book List", new BookListPanel());
        optionsPane.add("Search Book", new StudentSearchBookPanel());
        optionsPane.add("Borrow List", new BorrowListPanel());
        optionsPane.add("Book Request", new StudentBookRequestPanel());
        optionsPane.add("Report", new StudentReportPanel());
        optionsPane.add("Soft Book", new StudentSoftBookPanel());
        optionsPane.add("Upload Book", new StudentUploadPanel());
        optionsPane.add("Messenger", new StudentMessengerPanel());
        optionsPane.add("View Notice", new StudentNoticeBoardPanel());
        optionsPane.add("Edit Profile", new editProfilePanel());
        optionsPane.add("Change Password", new StudentPasswordPanel());
        add(optionsPane);

        bottomBar.setBackground(accent);
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
        System.out.println(width + ", " + height);
    }

    public static void main(String[] args) {
        new StudentHome(new JDialog(), "user");
    }

}
