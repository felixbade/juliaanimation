package julia8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FractalImage {

    private static final int WIDTH = 1920;
    private static final int HEIGHT = 1080;
    private static final String FILE_NAME_PREFIX = "images/julia_fractal";
    private static final int MAX_ITERATIONS = 100;
    private static final int ANTIALIAS_LEVEL = 3;

    private BufferedImage image;
    private Graphics graphics;
    private int currentFrameNumber;
    private int totalFrames;
    private int width;
    private int height;

    public FractalImage() {
        this.width = WIDTH * ANTIALIAS_LEVEL;
        this.height = HEIGHT * ANTIALIAS_LEVEL;
        this.image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
        this.graphics = image.createGraphics();
    }

    public void setCurrentFrameNumber(int currentFrameNumber) {
        this.currentFrameNumber = currentFrameNumber;
    }

    public void setTotalFrameNumber(int totalFrames) {
        this.totalFrames = totalFrames;
    }

    public void render() {
        double magnification = 0.5 * 1.61;

        double omega = 2 * Math.PI * this.currentFrameNumber / this.totalFrames;
        double hr = 0.5 * Math.cos(omega);
        double hi = 0.5 * Math.sin(omega);
        double cr = hr - hr*hr + hi*hi;
        double ci = hi - 2*hr*hi;

        double ratio = (double) WIDTH / HEIGHT;
        double x1 = -ratio / magnification;
        double x2 = ratio / magnification;
        double y1 = -1.0 / magnification;
        double y2 = 1.0 / magnification;

        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                
                Color pixelColor = new Color(0, 0, 0);
                double xr = x1 + (x2 - x1) * ((double) x / width);
                double xi = y1 + (y2 - y1) * ((double) y / height);
                for (int i = 0; i < MAX_ITERATIONS; i++) {
                    double xrs = xr * xr;
                    double xis = xi * xi;
                    if (xrs + xis > 4) {
                        int gradient = 255;//255 - i * 255 / MAX_ITERATIONS;
                        pixelColor = new Color(gradient, gradient, gradient);
                        break;
                    }
                    xi = 2 * xr * xi + ci;
                    xr = xrs - xis + cr;
                }
                this.graphics.setColor(pixelColor);
                this.graphics.drawLine(x, y, x, y);
            }
        }
    }

    public void saveAsPNG() {
        try {
            String fileName = FILE_NAME_PREFIX + "_" + this.currentFrameNumber + ".png";
            ImageIO.write(this.image, "png", new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
