package makbe.library.admin;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePanel extends JPanel {

    JLabel logIn = new JLabel("Logged in as: Super Admin");
    JLabel welcomeText = new JLabel("Welcome Back!");
    JLabel welcomeText2 = new JLabel("Choose your option from left panel");
    JPanel datePanel = new JPanel();
    JLabel monthLabel, dateLabel, dayLabel;
    JPanel timePanel = new JPanel();
    JLabel hourLabel = new JLabel();
    JLabel minutesLabel = new JLabel();
    Date date = new Date();

    HomePanel() {
        //setBackground(Color.GRAY);
        setLayout(null);

        logIn.setBounds(690, 10, 300, 40);
        logIn.setHorizontalAlignment(JLabel.CENTER);
        logIn.setVerticalAlignment(JLabel.CENTER);
        logIn.setFont(new Font("Iosevka Term", Font.PLAIN, 15));
        add(logIn);

        welcomeText.setBounds(100, 80, 800, 50);
        welcomeText.setHorizontalAlignment(JLabel.CENTER);
        welcomeText.setVerticalAlignment(JLabel.CENTER);
        welcomeText.setFont(new Font("Iosevka Term", Font.BOLD, 23));
        add(welcomeText);

        welcomeText2.setBounds(100, 130, 800, 50);
        welcomeText2.setHorizontalAlignment(JLabel.CENTER);
        welcomeText2.setVerticalAlignment(JLabel.CENTER);
        welcomeText2.setFont(new Font("Iosevka Term", Font.BOLD, 22));
        add(welcomeText2);

        datePanel.setBounds(750, 240, 180, 180);
        datePanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        datePanel.setBackground(Color.BLACK);
        datePanel.setFont(new Font("Iosevka Term", Font.BOLD, 16));
        add(datePanel);

        String[] days = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };

        String[] months = {
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        };

        monthLabel = new JLabel(months[date.getMonth() - 1].toUpperCase());
        monthLabel.setFont(new Font("Iosevka Term", Font.BOLD, 20));
        monthLabel.setForeground(Color.ORANGE);
        monthLabel.setHorizontalAlignment(JLabel.CENTER);
        monthLabel.setVerticalAlignment(JLabel.CENTER);
        datePanel.add(monthLabel, constraints);

        dateLabel = new JLabel(String.valueOf(date.getDate()));
        dateLabel.setForeground(Color.ORANGE);
        dateLabel.setFont(new Font("Iosevka Term", Font.PLAIN, 20));
        dateLabel.setHorizontalAlignment(JLabel.CENTER);
        dateLabel.setVerticalAlignment(JLabel.CENTER);
        constraints.gridy = 1;
        datePanel.add(dateLabel, constraints);

        dayLabel = new JLabel(days[date.getDay() - 1].toUpperCase());
        dayLabel.setFont(new Font("Iosevka Term", Font.PLAIN, 17));
        dayLabel.setForeground(Color.WHITE);
        dayLabel.setHorizontalAlignment(JLabel.CENTER);
        dayLabel.setVerticalAlignment(JLabel.CENTER);
        constraints.gridy = 2;
        datePanel.add(dayLabel, constraints);

        timePanel.setBackground(Color.DARK_GRAY);
        constraints.gridy = 3;
        datePanel.add(timePanel, constraints);

        hourLabel.setFont(new Font("Iosevka Term", Font.PLAIN, 17));
        hourLabel.setForeground(Color.WHITE);
        constraints.gridy = 4;
        timePanel.add(hourLabel);

        JLabel colon = new JLabel(" : ");
        colon.setForeground(Color.WHITE);
        timePanel.add(colon);

        minutesLabel.setFont(new Font("Iosevka Term", Font.PLAIN, 17));
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
