package makbe.library.admin;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class HomePanel extends JPanel {

    JLabel logIn = new JLabel("Logged in as: Super Admin");
    JLabel welcomeText = new JLabel("Welcome Back! " + "\n" +
            "Choose your option from left panel");
    JPanel datePanel = new JPanel();
    JLabel monthLabel, dateLabel, dayLabel, timeLabel;
    Date date = new Date();
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int width = screen.width - 100;

    HomePanel() {
        setBounds(260, 10, (width - 285), 540);
        add(logIn);
        add(welcomeText);
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

        monthLabel = new JLabel(months[date.getMonth() - 1]);
        dateLabel = new JLabel(String.valueOf(date.getDate()));
        dayLabel = new JLabel(days[date.getDay() - 1]);
        timeLabel = new JLabel(date.getHours() + " : " + date.getMinutes());

        datePanel.add(monthLabel);
        datePanel.add(dateLabel);
        datePanel.add(dayLabel);
        datePanel.add(timeLabel);

        setVisible(true);
    }
}
