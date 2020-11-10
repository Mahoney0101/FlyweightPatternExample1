import org.junit.Assert;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class SoldierTest {

    SoldierTest() throws IOException {
    }

    private final List<Soldier> nonFlyweightList = new ArrayList<>();

    int windowWidth = 1750;
    int windowHeight = 1000;

    private BufferedImage getRandImage(){
        Random random = new Random();
        int randInt = random.nextInt(8);
        return soldierSprite[randInt];
    }


    private int getRandX(){ return (int)(Math.random()*windowWidth); }
    private int getRandY(){ return (int)(Math.random()*windowHeight); }
    private int getRandHeight(){ return (int)(Math.random()*25);}
    private int getRandWidth(){ return (int)(Math.random()*25);}


    BufferedImage[] soldierSprite = {
            ImageIO.read(getClass().getResource("/minion.png")),
            ImageIO.read(getClass().getResource("/saber.png")),
            ImageIO.read(getClass().getResource("/mutant.png")),
            ImageIO.read(getClass().getResource("/smash.png")),
            ImageIO.read(getClass().getResource("/bash.png")),
            ImageIO.read(getClass().getResource("/boy.png")),
            ImageIO.read(getClass().getResource("/cod.png")),
            ImageIO.read(getClass().getResource("/boss.png"))};

    @org.junit.jupiter.api.Test
    void getRegularCache(){
        for(int i=0; i < 100000; ++i) {
            Soldier soldier = new Soldier(getRandImage(),getRandX(),getRandY(),getRandWidth(),getRandHeight());
            nonFlyweightList.add(soldier);
        }
        Assert.assertEquals(100000, nonFlyweightList.size());
    }
}