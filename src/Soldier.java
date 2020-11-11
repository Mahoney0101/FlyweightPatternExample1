import java.awt.*;
import java.awt.image.BufferedImage;

    public class Soldier {
        private final BufferedImage image;

        public Soldier(BufferedImage image){
            this.image = image;
        }

        public void draw(Graphics g, BufferedImage image, int X, int Y, int height, int width) {
            g.drawImage(image,X,Y,height,width,null); //can add with, height, background colour arguments here later
        }

        public BufferedImage getImage(){
            return this.image;
        }
    }

