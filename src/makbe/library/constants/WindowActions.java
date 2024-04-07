package makbe.library.constants;

import javax.swing.*;

public class WindowActions {
	public static void changeLookAndFeel(JFrame component) {
		UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
		try {
			UIManager.setLookAndFeel(looks[3].getClassName());
			SwingUtilities.updateComponentTreeUI(component);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
				 UnsupportedLookAndFeelException e) {
			throw new RuntimeException(e);
		}
	}
}
