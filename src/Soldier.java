import java.awt.*;
import java.awt.image.BufferedImage;

    public class Soldier {
        private final BufferedImage image;
        private int X;
        private int Y;
        private int width;
        private int height;

        public Soldier(BufferedImage image, int X, int Y, int width, int height){
            this.image = image;
            this.X = X;
            this.Y = Y;
            this.width = width;
            this.height = height;
        }

        public void drawNonFlyweight(Graphics g) {
            g.drawImage(image,X,Y,height,width,null); //can add with, height, background colour arguments here later
        }
    }

