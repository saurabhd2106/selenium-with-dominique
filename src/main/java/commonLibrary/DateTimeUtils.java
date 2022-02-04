package commonLibrary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

	public static String getCurrentDateAndTime() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy-hh-mm-ss");
		String dateTimeFormat = dateTime.format(format);

		return dateTimeFormat;
	}

}
