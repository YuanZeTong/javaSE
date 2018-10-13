package top.yztprocs.game;

import java.awt.*;

import static java.lang.Math.PI;

public class Bullet extends GameObject{
    //子弹类
    private double degree;
    public Bullet(){
        setX(200);
        setY(200);
        setHeight(10);
        setWidth(10);
        setSpeed(3);
        degree = Math.random()*2*PI;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public double getDegree() {
        return degree;
    }
    public void draw(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval((int)getX(), (int)getY(), getWidth(), getHeight());
        //炮弹沿着任意角度去飞
        setX(getX() + getSpeed() * Math.cos(degree));
        setY(getY() + getSpeed() * Math.sin(degree));
        if(getX() < 5 || getX() > Constant.GAME_WIDTH - 15){
            degree = PI - degree;//反转角度,遇到左右边界反弹
        }
        if(getY() < 0 + 40 || getY() >Constant.GAME_HEIGHT-15){
            degree = -degree;//反转角度,遇到上下边界反弹
        }
        g.setColor(c);
    }
}
