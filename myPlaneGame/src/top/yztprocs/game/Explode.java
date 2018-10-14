package top.yztprocs.game;

import java.awt.*;
/**
 *
 * Function 爆炸类
 * @author Zeta
 */

public class Explode {
    private double x, y;
    static Image[] imgs = new Image[6];
    static{
        for(int i = 0; i < 6; i++){
            imgs[i] = GameUtil.getImage("images/b" + (i + 1) + ".png");
            imgs[i].getWidth(null);
        }
    }
    int count = 0;

    public void draw(Graphics g) {
        if (count <= 5) {
            g.drawImage(imgs[count], (int) x, (int) y, null);
            count++;
        }
    }
    public Explode(double x, double y){
        this.x = x;
        this.y = y;
    }
}
