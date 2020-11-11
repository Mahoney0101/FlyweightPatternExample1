import java.awt.*;
import java.awt.image.BufferedImage;

    public class Soldier {
        private final BufferedImage image;
        private int X;
        private int Y;
        private int width;
        private int height;

        public Soldier(BufferedImage image){
            this.image = image;
        }

        public Soldier(BufferedImage image, int x, int y, int width, int height) {
            this.image=image;
            this.X=x;
            this.Y=y;
            this.width=width;
            this.height=height;
        }

        public void draw(Graphics g, int X, int Y, int height, int width) {
            g.drawImage(image,X,Y,height,width,null); //can add with, height, background colour arguments here later
        }

        public void drawNonFlyweight(Graphics g) {
            g.drawImage(image,X,Y,height,width,null); //can add with, height, background colour arguments here later
        }

        public BufferedImage getImage(){
            return this.image;
        }
    }

