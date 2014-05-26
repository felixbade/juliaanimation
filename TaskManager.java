package juliaanimation;

public class TaskManager {

    private long startTime;
    private int numberOfTasksTotal;
    private int numberOfTasksDone;

    public TaskManager() {
        return;
    }

    public synchronized void setNumberOfTasksTotal(int numberOfTasksTotal) {
        this.numberOfTasksTotal = numberOfTasksTotal;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.numberOfTasksDone = 0;
    }

    public synchronized void didOneTask() {
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
        if (this.getNumberOfTasksDone() > 0) {
            return (long) (this.getElapsedTime() * this.getNumberOfTasksLeft() / this.getNumberOfTasksDone());
        } else {
            return Long.MAX_VALUE;
        }
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
















