package juliaanimation;

public class HumanReadableTime {

    public static final int SECONDS_IN_A_MINUTE = 60;
    public static final int SECONDS_IN_AN_HOUR = 60*60;
    public static final int SECONDS_IN_A_DAY = 24*60*60;
    public static final int SECONDS_IN_A_WEEK = 7*24*60*60;
    public static final int SECONDS_IN_A_MONTH = 30*24*60*60;
    public static final int SECONDS_IN_A_YEAR = 365*24*60*60;

    public static String getHumanReadableTimeFromSeconds (long seconds) {
        if (seconds < 0) {
            return "negative time";
        } else if (seconds == 0) {
            return "less than a second";
        } else if (seconds == 1) {
            return "a second";
        } else if (seconds < SECONDS_IN_A_MINUTE) {
            return String.format("%d seconds", seconds);
        
        } else if (seconds < 2 * SECONDS_IN_A_MINUTE) {
            return "about a minute";
        } else if (seconds < SECONDS_IN_AN_HOUR) {
            return String.format("about %d minutes", seconds/SECONDS_IN_A_MINUTE);
        
        } else if (seconds < 2 * SECONDS_IN_AN_HOUR) {
            return "about an hour";
        } else if (seconds < SECONDS_IN_A_DAY) {
            return String.format("about %d hours", seconds/SECONDS_IN_AN_HOUR);
        
        } else if (seconds < 2 * SECONDS_IN_A_DAY) {
            return "about a day";
        } else if (seconds < SECONDS_IN_A_WEEK) {
            return String.format("about %d days", seconds/SECONDS_IN_A_DAY);
        
        } else if (seconds < 2 * SECONDS_IN_A_WEEK) {
            return "about a week";
        } else if (seconds < SECONDS_IN_A_MONTH) {
            return String.format("about %d weeks", seconds/SECONDS_IN_A_WEEK);
        
        } else if (seconds < 2 * SECONDS_IN_A_MONTH) {
            return "about a month";
        } else if (seconds < SECONDS_IN_A_YEAR) {
            return String.format("about %d months", seconds/SECONDS_IN_A_MONTH);
        
        } else if (seconds < 2 * SECONDS_IN_A_YEAR) {
            return "about a year";
        } else {
            return String.format("about %d years", seconds/SECONDS_IN_A_YEAR);
        }
    }

    public static String getHumanReadableTimeFromMilliseconds (long ms) {
        if (ms == 0) {
            return "less than a millisecond";
        } else if (ms < 1000) {
            return String.format("%d ms", ms);
        } else {
            return getHumanReadableTimeFromSeconds(ms / 1000);
        }
    }

    public static String getHumanReadableAndRawTimeFromMilliseconds (long ms) {
        if (ms == 0) {
            return "less than a millisecond";
        } else if (ms < 1000) {
            return String.format("%d ms", ms);
        } else {
            return String.format("%s (%d ms)", getHumanReadableTimeFromSeconds(ms / 1000), ms);
        }
    }
}
