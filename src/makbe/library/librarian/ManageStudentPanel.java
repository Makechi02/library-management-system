package makbe.library.librarian;

import javax.swing.*;
import java.awt.*;

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


}

class StudentDetails extends JPanel {
    JLabel label = new JLabel("University Information");

    StudentDetails() {
        add(label);
        label.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
    }
}

class EditStudent extends JPanel {

}
