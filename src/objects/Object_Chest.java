package objects;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

import static utilities.Constants.ObjectNames.CHEST;

public class Object_Chest extends Object{
    public Object_Chest() {
        name = CHEST;
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/chest.png")));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
