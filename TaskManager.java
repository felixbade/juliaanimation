package juliaanimation;

public class TaskManager {

    private long startTime;
    private int numberOfTasksTotal;
    private int numberOfTasksDone;

    public TaskManager() {
        this.startTime = System.currentTimeMillis();
    }

    public void setNumberOfTasksTotal(int numberOfTasksTotal) {
        this.numberOfTasksTotal = numberOfTasksTotal;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.numberOfTasksDone = 0;
    }

    public void didOneTask() {
        this.numberOfTasksDone++;
    }

    public boolean isNotDone() {
        return this.numberOfTasksDone < this.numberOfTasksTotal;
    }

    public int getNumberOfTasksTotal() {
        return this.numberOfTasksTotal;
    }

    public int getNumberOfTasksDone() {
        return this.numberOfTasksDone;
    }

    public int getNumberOfTasksLeft() {
        return this.numberOfTasksTotal - this.numberOfTasksDone;
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - this.startTime;
    }

    public String getHumanReadableElapsedTime() {
        long elapsed = System.currentTimeMillis() - this.startTime;
        return HumanReadableTime.getHumanReadableTimeFromMilliseconds(elapsed);
    }

    public long getETA() {
        long elapsedTime = this.getElapsedTime();
        int numberOfTasksLeft = this.getNumberOfTasksLeft();
        int numberOfTasksDone = this.getNumberOfTasksDone();
        return (int) (elapsedTime * numberOfTasksLeft / (numberOfTasksDone));
    }

    public String getHumanReadableETA() {
        long ETAInMilliseconds = this.getETA();
        return HumanReadableTime.getHumanReadableTimeFromMilliseconds(ETAInMilliseconds);
    }

    public String getSummary() {
        if (this.isNotDone()) {
            return String.format("ETA: %s",
                       this.getHumanReadableETA());
        } else {
            long elapsedMilliseconds = this.getElapsedTime();
            return String.format("Done in %s",
                       HumanReadableTime.getHumanReadableAndRawTimeFromMilliseconds(elapsedMilliseconds));
        }
    }
    
    public void printSummary() {
        System.out.println(getSummary());
    }
}
















