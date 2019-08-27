package duke.task;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDateTime;
import java.time.LocalTime;

import duke.command.DukeInvalidArgumentException;

public class TaskUtil {
    private static final String DATE_FORMAT = "d/M/y HHmm";
    private static final String TIME_FORMAT = "HHmm";
    private static final String DISPLAY_FORMAT = "EEE, d MMM y h:mma";
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(TIME_FORMAT);
    private static final DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern(DISPLAY_FORMAT);

    public static void validateTaskDescription(String description)
            throws DukeInvalidArgumentException {

        if (description.length() == 0) {
            throw new DukeInvalidArgumentException(
                    "User specified description of task is empty",
                    " ☹  OOPS!!! The description of a task cannot be empty.");
        }
    }

    static LocalDateTime getDateFromString(String dateString) throws DukeInvalidArgumentException {
        try {
            return LocalDateTime.parse(dateString.trim(), dateFormatter);
        } catch (DateTimeParseException ex) {
            throw new DukeInvalidArgumentException(
                    "Invalid date format inputted by user",
                    " ☹  OOPS!!! The format of the timing is invalid!\n"
                            + " Enter your time with " + DATE_FORMAT);
        }
    }

    static LocalTime getTimeFromString(String timeString) throws DukeInvalidArgumentException {
        try {
            return LocalTime.parse(timeString.trim(), timeFormatter);
        } catch (DateTimeParseException ex) {
            throw new DukeInvalidArgumentException(
                    "Invalid time format inputted by user",
                    " ☹  OOPS!!! The format of the timing is invalid!\n"
                            + " Enter your time with " + TIME_FORMAT);
        }
    }

    static String getDisplayTime(LocalDateTime dateTime) {
        return displayFormatter.format(dateTime);
    }
}
