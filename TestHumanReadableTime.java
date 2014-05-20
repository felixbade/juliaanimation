package julia8;

public class TestHumanReadableTime {

    public static void main(String[] args) {
        boolean success = true;
        success = success && getHumanReadableTimeFromSeconds();
        //success = success && getHumanReadableTimeFromMilliseconds();
        System.out.println(success);
    }
    
    public static boolean getHumanReadableTimeFromSeconds() {
        boolean success = true;
        System.out.println("negative time" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(-1));
        System.out.println("less than a second" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(0));
        System.out.println("a second" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(1));
        System.out.println("2 seconds" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(2));
        System.out.println("59 seconds" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(59));
        System.out.println("a minute" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(60));
        System.out.println("a minute" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(119));
        System.out.println("2 minutes" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(120));
        System.out.println("59 minutes" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(60*60-1));
        System.out.println("an hour" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(60*60));
        System.out.println("an hour" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(2*60*60-1));
        System.out.println("2 hours" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(2*60*60));
        System.out.println("23 hours" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(24*60*60-1));
        System.out.println("a day" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(24*60*60));
        System.out.println("a day" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(2*24*60*60-1));
        System.out.println("2 days" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(2*24*60*60));
        System.out.println("6 days" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(7*24*60*60-1));
        System.out.println("a week" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(7*24*60*60));
        System.out.println("a week" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(2*7*24*60*60-1));
        System.out.println("2 weeks" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(2*7*24*60*60));
        System.out.println("4 weeks" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(30*24*60*60-1));
        System.out.println("a month" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(30*24*60*60));
        System.out.println("a month" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(2*30*24*60*60-1));
        System.out.println("2 months" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(2*30*24*60*60));
        System.out.println("12 months" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(365*24*60*60-1));
        System.out.println("a year" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(365*24*60*60));
        System.out.println("a year" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(2*365*24*60*60-1));
        System.out.println("2 years" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(2*365*24*60*60));
        System.out.println("100000 years" + "\t" + HumanReadableTime.getHumanReadableTimeFromSeconds(100000L*365*24*60*60));
        return success;
    }
}
