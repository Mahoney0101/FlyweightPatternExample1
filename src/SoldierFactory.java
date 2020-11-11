// Intrinsic State: Image
// Extrinsic State: X & Y Values
import java.awt.image.BufferedImage;
import java.util.HashMap;
public class SoldierFactory {
    private static final HashMap<BufferedImage, Soldier> soldierBySprite = new HashMap<>();

    public static Soldier getSoldier(BufferedImage image) {
        Soldier soldier = soldierBySprite.get(image);
        if(soldier == null) {
            soldier = new Soldier(image);
            soldierBySprite.put(image, soldier);
        }
        return soldier;
    }

    public static int getCache(){
        return soldierBySprite.size();
    }
}