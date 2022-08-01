package objects;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

import static utilities.Constants.ObjectNames.DOOR;

public class Object_Door extends Object{
    public Object_Door() {
        name = DOOR;
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/door.png")));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
