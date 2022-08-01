package objects;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

import static utilities.Constants.ObjectNames.KEY;

public class Object_Key extends Object{
    public Object_Key() {
        name = KEY;
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/key.png")));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
