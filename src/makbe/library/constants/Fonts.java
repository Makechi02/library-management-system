package makbe.library.constants;

import java.awt.*;

public class Fonts {
	private static final String[] fontNames = {"Mali", "Arial", "SansSerif"};
	public static Font defaultFont = getAvailableFont();

	public static Font displayFont = new Font(defaultFont.getFontName(), Font.PLAIN, 20);
	public static Font headingFont = new Font(defaultFont.getFontName(), Font.BOLD, 24);
	public static Font subHeadingFont = new Font(defaultFont.getFontName(), Font.ITALIC, 15);
	public static Font buttonFont = new Font(defaultFont.getFontName(), Font.PLAIN, 15);

	private static Font getAvailableFont() {
		for (String fontName : Fonts.fontNames) {
			Font font = new Font(fontName, Font.PLAIN, 12);
			if (font.canDisplay('a')) return font;
		}

		return new Font(Font.SANS_SERIF, Font.PLAIN, 12);
	}
}
