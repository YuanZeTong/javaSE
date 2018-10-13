package top.yztprocs.game;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {
    private boolean live = true;
    private boolean right,left,up,down;//添加控制方向

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Plane(Image img, double x, double y) {
        super(img, (int)x, (int)y);
        setWidth(img.getWidth(null));
        setHeight(img.getHeight(null));
    }
    public Plane(Image img, double x, double y, int speed){
        this(img, x, y);
        setSpeed(speed);
    }

    @Override
    public void drawSelf(Graphics g) {
        if(live){
            super.drawSelf(g);
            if(right){
                setX(getX() + getSpeed());}
            if(left){
                setX(getX() - getSpeed());}
            if(up){
                setY(getY() - getSpeed());}
            if(down){
                setY(getY() + getSpeed());}

        }
        else{
            System.out.println("飞机被攻击了");
        }

    }
    public void addDirection(KeyEvent e){
        //添加一个方向
        switch (e.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
        }
    }
    public void miusDirection(KeyEvent e){
        //减少一个方向
        switch(e.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
        }
    }

}
