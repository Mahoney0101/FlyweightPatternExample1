import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GUI extends JFrame{

    private final int windowWidth = 1750;
    private final int windowHeight = 1000;

    private final BufferedImage[] minionSprite = {
            ImageIO.read(getClass().getResource("/minion.png")),
            ImageIO.read(getClass().getResource("/saber.png")),
            ImageIO.read(getClass().getResource("/mutant.png")),
            ImageIO.read(getClass().getResource("/smash.png")),
            ImageIO.read(getClass().getResource("/bash.png")),
            ImageIO.read(getClass().getResource("/boy.png")),
            ImageIO.read(getClass().getResource("/cod.png")),
            ImageIO.read(getClass().getResource("/boss.png"))};

    public GUI() throws IOException {
        // Create the frame, position it and handle closing it
        this.setSize(windowWidth,windowHeight);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Flyweight Timer");
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        final JPanel  drawingPanel  = new JPanel();

        JButton draw = new JButton("Start Test");
        contentPane.add(drawingPanel,  BorderLayout.CENTER);
        contentPane.add(draw, BorderLayout.SOUTH);
        draw.addActionListener(event -> {
            Graphics g = drawingPanel.getGraphics();
            long startTime = System.currentTimeMillis();
            for(int i=0; i < 1000000; ++i) {
                Soldier soldier = SoldierFactory.getSoldier(getRandImage());
                soldier.draw(g, soldier.getImage(), getRandX(), getRandY(),getRandHeight(),getRandWidth());
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Computational Time " + (endTime - startTime) + " milliseconds and there are " + SoldierFactory.getCache() + " objects in cache for this operation");
        });
        this.add(contentPane);
        this.setVisible(true);
    }

    private int getRandX(){ return (int)(Math.random()*windowWidth); }
    private int getRandY(){ return (int)(Math.random()*windowHeight); }
    private int getRandHeight(){ return (int)(Math.random()*25);}
    private int getRandWidth(){ return (int)(Math.random()*25);}

    private BufferedImage getRandImage(){
        Random random = new Random();
        int randInt = random.nextInt(8);
        return minionSprite[randInt];
    }
}
