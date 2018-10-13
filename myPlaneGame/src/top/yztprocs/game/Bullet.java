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
        g.fillOval((int)x, (int)y, getWidth(), getHeight());

        g.setColor(c);
    }
}
