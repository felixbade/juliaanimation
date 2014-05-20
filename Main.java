package juliaanimation;

public class Main {

    public static void main(String[] args) {

        int durationInSeconds = 100;
        int framerate = 25;

        int totalFrames = framerate * durationInSeconds;
        TaskManager manager = new TaskManager();
        manager.setNumberOfTasksTotal (totalFrames);
        FractalImage image = new FractalImage();
        image.setTotalFrameNumber(totalFrames);
       
        while (manager.isNotDone()) {
            int currentFrameNumber = manager.getNumberOfTasksDone() + 1;
            int lastFrameNumber = manager.getNumberOfTasksTotal();
            if (currentFrameNumber == 1) {
                System.out.printf("\r\033[2KRendering frame %d/%d",
                        currentFrameNumber, lastFrameNumber);
            } else {
                String ETA = manager.getHumanReadableETA();
                System.out.printf("\r\033[2KRendering frame %d/%d (ETA: %s)",
                        currentFrameNumber, lastFrameNumber, ETA);
            }
            
            image.setCurrentFrameNumber(currentFrameNumber);
            image.render();
            image.saveAsPNG();

            manager.didOneTask();
        }
        
        System.out.println();
        manager.printSummary();
    }
}
