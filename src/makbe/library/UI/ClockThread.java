package makbe.library.UI;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockThread extends Thread {
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