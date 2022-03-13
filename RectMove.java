package JogoAranha;

import java.awt.*;

abstract public class RectMove extends Rectangle {
    public RectMove(int x, int y, int width, int height) {
        super(x,y,width,height);
    }

    abstract public void move();
}
