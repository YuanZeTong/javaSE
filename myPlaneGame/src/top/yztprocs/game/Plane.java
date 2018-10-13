package top.yztprocs.game;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {
    private boolean right,left,up,down;//添加控制方向
    public Plane(Image img, double x, double y) {
        super(img, (int)x, (int)y);
    }
    public Plane(Image img, double x, double y, int speed){
        super(img, (int)x, (int)y);
        setSpeed(speed);
    }

    @Override
    public void drawSelf(Graphics g) {
        super.drawSelf(g);
        int controlSpeed = 5;
        setY(getY() - getSpeed());
        if(right){
            setX(getX() + controlSpeed);}
        if(left){
            setX(getX() - controlSpeed);}
        if(up){
            setY(getY() - controlSpeed);}
        if(down){
            setY(getY() + controlSpeed);}
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
