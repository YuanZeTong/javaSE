package top.yztprocs.game;

import java.awt.*;
/**
 * Function 游戏物体的父类
 * @author Zeta
 */
public class GameObject {
    private Image img;//游戏对象图片
    private double x, y;//初始坐标
    private int speed;//游戏物体的速度
    private int width, height;//游戏物体的外边矩形的大小

    public void drawSelf(Graphics g) {
        //画出自己
        g.drawImage(img, (int) x, (int) y, null);
    }

    public GameObject(Image img, double x, double y, int speed, int width, int height) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public GameObject(Image img, double x, double y) {
        this.img = img;
        this.x = x;
        this.y = y;
    }

    public GameObject() {
    }

    public Image getImg() {
        return img;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle getRect(){
        return new Rectangle((int)x, (int)y, width, height);
    }
}