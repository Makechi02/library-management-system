package makbe.library.librarian;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class ManageStudentPanel extends JPanel {

    ManageStudentPanel() {
        setLayout(null);

        JTabbedPane studentsPane = new JTabbedPane();
        studentsPane.setBounds(30, 10, 1000, 490);
        studentsPane.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        studentsPane.add("Add New Student", new AddStudent());
        studentsPane.add("Student Details", new StudentDetails());
        studentsPane.add("Edit Student", new EditStudent());
        add(studentsPane);
    }

}

class AddStudent extends JPanel {

    private final String[] courses = {
            "COMPUTER SCIENCE",
            "EDUCATION ARTS",
            "EDUCATION SCIENCE",
            "BUSINESS ADMINISTRARTION",
            "LAW",
            "MASS COMMUNICATION"
    };

    JLabel label;
    JTextField nameField = new JTextField();
    JTextField regField = new JTextField();
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JTextField emailField = new JTextField();
    JComboBox<String> deptBox = new JComboBox<>(courses);
    JTextField dobField = new JTextField();
    JComboBox<String> sexBox = new JComboBox<>();
    JTextField contactField = new JTextField();
    JTextField joinedField = new JTextField();
    JComboBox<JFileChooser> imageButton = new JComboBox<JFileChooser>();
    JFileChooser imageChooser = new JFileChooser();
    Font font = new Font("Iosevka Term", Font.PLAIN, 18);

    AddStudent() {
        setLayout(null);

        imageChooser.setCurrentDirectory(new File("."));
        imageChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "gif", "jpg", "jpeg"));
        imageChooser.setAcceptAllFileFilterUsed(false);

        label = new JLabel("NAME:");
        label.setBounds(20, 20, 100, 40);
        label.setFont(font);
        label.setLabelFor(nameField);
        add(label);

        nameField.setBounds(150, 20, 300, 40);
        nameField.setFont(font);
        add(nameField);

        label = new JLabel("DEPT.:");
        label.setBounds(530, 20, 100, 40);
        label.setFont(font);
        label.setLabelFor(deptBox);
        add(label);

        deptBox.setBounds(670, 20, 300, 40);
        deptBox.setFont(font);
        add(deptBox);

        label = new JLabel("REG. NO:");
        label.setBounds(20, 90, 100, 40);
        label.setFont(font);
        label.setLabelFor(regField);
        add(label);

        regField.setBounds(150, 90, 300, 40);
        regField.setFont(font);
        add(regField);

        label = new JLabel("D.O.B:");
        label.setBounds(530, 90, 100, 40);
        label.setFont(font);
        label.setLabelFor(dobField);
        add(label);

        dobField.setBounds(670, 90, 300, 40);
        dobField.setFont(font);
        add(dobField);

        label = new JLabel("USERNAME:");
        label.setBounds(20, 160, 100, 40);
        label.setFont(font);
        label.setLabelFor(usernameField);
        add(label);

        usernameField.setBounds(150, 160, 300, 40);
        usernameField.setFont(font);
        add(usernameField);

        label = new JLabel("SEX:");
        label.setBounds(530, 160, 100, 40);
        label.setFont(font);
        label.setLabelFor(sexBox);
        add(label);

        sexBox.setBounds(670, 160, 300, 40);
        sexBox.setFont(font);
        sexBox.addItem("MALE");
        sexBox.addItem("FEMALE");
        add(sexBox);

        label = new JLabel("PASSWORD:");
        label.setBounds(20, 230, 100, 40);
        label.setFont(font);
        label.setLabelFor(passwordField);
        add(label);

        passwordField.setBounds(150, 230, 300, 40);
        passwordField.setFont(font);
        add(passwordField);

        label = new JLabel("CONTACT:");
        label.setBounds(530, 230, 100, 40);
        label.setFont(font);
        label.setLabelFor(contactField);
        add(label);

        contactField.setBounds(670, 230, 300, 40);
        contactField.setFont(font);
        add(contactField);

        label = new JLabel("EMAIL:");
        label.setBounds(20, 300, 100, 40);
        label.setFont(font);
        label.setLabelFor(emailField);
        add(label);

        emailField.setBounds(150, 300, 300, 40);
        emailField.setFont(font);
        add(emailField);

        label = new JLabel("YEAR JOINED:");
        label.setBounds(530, 300, 100, 40);
        label.setFont(new Font("Iosevka Term", Font.PLAIN, 16));
        label.setLabelFor(joinedField);
        add(label);

        joinedField.setBounds(670, 300, 300, 40);
        joinedField.setFont(font);
        add(joinedField);

        label = new JLabel("IMAGE:");
        label.setBounds(20, 370, 100, 40);
        label.setFont(font);
        add(label);

        imageButton.setBounds(150, 370, 300, 40);
        imageButton.addItem(imageChooser);
        add(imageButton);
    }

}

class StudentDetails extends JPanel {
    JLabel label = new JLabel("University Information");

    StudentDetails() {
        label.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        add(label);
    }
}

class EditStudent extends JPanel {

}
