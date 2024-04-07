package makbe.library.admin;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static makbe.library.constants.Fonts.defaultFont;

public class HomePanel extends JPanel {
    JLabel logIn = new JLabel("Logged in as: Super Admin");
    JLabel welcomeText = new JLabel("Welcome Back!");
    JLabel welcomeText2 = new JLabel("Choose your option from the left panel");
    JPanel datePanel = new JPanel();
    JLabel monthLabel, dateLabel, dayLabel;
    JPanel timePanel = new JPanel();
    JLabel hourLabel = new JLabel();
    JLabel minutesLabel = new JLabel();
    Calendar calendar = Calendar.getInstance();

    HomePanel() {
        setLayout(null);

        logIn.setBounds(690, 10, 300, 40);
        logIn.setHorizontalAlignment(JLabel.CENTER);
        logIn.setVerticalAlignment(JLabel.CENTER);
        logIn.setFont(new Font(defaultFont.getFontName(), Font.PLAIN, 15));
        add(logIn);

        welcomeText.setBounds(100, 80, 800, 50);
        welcomeText.setHorizontalAlignment(JLabel.CENTER);
        welcomeText.setVerticalAlignment(JLabel.CENTER);
        welcomeText.setFont(new Font(defaultFont.getFontName(), Font.BOLD, 23));
        add(welcomeText);

        welcomeText2.setBounds(100, 130, 800, 50);
        welcomeText2.setHorizontalAlignment(JLabel.CENTER);
        welcomeText2.setVerticalAlignment(JLabel.CENTER);
        welcomeText2.setFont(new Font(defaultFont.getFontName(), Font.BOLD, 22));
        add(welcomeText2);

        datePanel.setBounds(750, 240, 180, 180);
        datePanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        datePanel.setBackground(Color.BLACK);
        datePanel.setFont(new Font(defaultFont.getFontName(), Font.BOLD, 16));
        add(datePanel);

        String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

        String[] months = {
                "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
        };

        monthLabel = new JLabel(months[calendar.get(Calendar.MONTH)].toUpperCase());
        monthLabel.setForeground(Color.ORANGE);
        monthLabel.setFont(new Font(defaultFont.getFontName(), Font.BOLD, 20));
        monthLabel.setHorizontalAlignment(JLabel.CENTER);
        monthLabel.setVerticalAlignment(JLabel.CENTER);
        datePanel.add(monthLabel, constraints);

        dateLabel = new JLabel(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
        dateLabel.setForeground(Color.ORANGE);
        dateLabel.setFont(new Font(defaultFont.getFontName(), Font.PLAIN, 20));
        dateLabel.setHorizontalAlignment(JLabel.CENTER);
        dateLabel.setVerticalAlignment(JLabel.CENTER);
        constraints.gridy = 1;
        datePanel.add(dateLabel, constraints);

        dayLabel = new JLabel(days[calendar.get(Calendar.DAY_OF_WEEK) - 1].toUpperCase());
        dayLabel.setForeground(Color.WHITE);
        dayLabel.setFont(new Font(defaultFont.getFontName(), Font.PLAIN, 17));
        dayLabel.setHorizontalAlignment(JLabel.CENTER);
        dayLabel.setVerticalAlignment(JLabel.CENTER);
        constraints.gridy = 2;
        datePanel.add(dayLabel, constraints);

        timePanel.setBackground(Color.DARK_GRAY);
        constraints.gridy = 3;
        datePanel.add(timePanel, constraints);

        Font timeFont = new Font(defaultFont.getFontName(), Font.PLAIN, 17);

        hourLabel.setFont(timeFont);
        hourLabel.setForeground(Color.WHITE);
        constraints.gridy = 4;
        timePanel.add(hourLabel);

        JLabel colon = new JLabel(" : ");
        colon.setFont(timeFont);
        colon.setForeground(Color.WHITE);
        timePanel.add(colon);

        minutesLabel.setFont(timeFont);
        minutesLabel.setForeground(Color.WHITE);
        constraints.gridy = 5;
        timePanel.add(minutesLabel);

        new ClockThread(this);

        setVisible(true);
    }
}

class ClockThread extends Thread {
    HomePanel homePanel;

    ClockThread(HomePanel homePanel) {
        this.homePanel = homePanel;
        start();
    }

    public void run() {
        while (true) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            String newDate = sdf.format(date);
            String[] timeArray = newDate.split(":");
            homePanel.hourLabel.setText(timeArray[0]);
            homePanel.minutesLabel.setText(timeArray[1]);
        }
    }
}
