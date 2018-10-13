package top.yztprocs.game;

import java.awt.*;

public class Plane extends GameObject {
    public Plane(Image img, double x, double y) {
        super(img, (int)x, (int)y);
    }

    @Override
    public void drawSelf(Graphics g) {
        super.drawSelf(g);
        setX(getX() + 1);
    }
}
