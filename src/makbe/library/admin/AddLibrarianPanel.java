package makbe.library.admin;

import javax.swing.*;
import java.awt.*;

public class AddLibrarianPanel extends JPanel {

    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int width = screen.width - 100;
    AddLibrarianPanel() {
        setBounds(260, 10, (width - 285), 540);
        setBackground(Color.ORANGE);
        setVisible(true);
    }
}
