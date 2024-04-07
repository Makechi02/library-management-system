package makbe.library.librarian;

import javax.swing.*;
import java.awt.*;

public class ManageBookPanel extends JPanel {
    ManageBookPanel() {
        setLayout(null);

        JTabbedPane studentsPane = new JTabbedPane();
        studentsPane.setBounds(30, 10, 1000, 490);
        studentsPane.setFont(new Font("Iosevka Term", Font.PLAIN, 20));

        studentsPane.add("Add New Book", new AddBook());
        studentsPane.add("Edit Book", new EditBook());
        studentsPane.add("List of Books", new BooksList());
        add(studentsPane);
    }
}

class AddBook extends JPanel {

}

class EditBook extends JPanel {

}

class BooksList extends JPanel {

}
