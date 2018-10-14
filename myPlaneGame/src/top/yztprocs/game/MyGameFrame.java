package top.yztprocs.game;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

/**
 * Function : game's main window
 *
 * @author Zeta
 */
public class MyGameFrame extends Frame {
    Image sky = GameUtil.getImage("images/sky.png");
    Image plane = GameUtil.getImage("images/plane.png");
    Plane myPlane1 = new Plane(plane, 300, 360,5);
    Bullet[] bulletArray = new Bullet[50];
    Explode boom;
    Date startTime = new Date();
    int period;
    //增加键盘监听内部类
    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            myPlane1.addDirection(e);

        }

        @Override
        public void keyReleased(KeyEvent e) {
            myPlane1.miusDirection(e);
        }
    }
    public void launchFrame() {
        //初始化窗口的方法
        this.setTitle("Zeta's Plane");
        this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        this.setVisible(true);
        this.setLocation(500, 250);
        this.addWindowListener(new WindowAdapter() { //匿名内部类
            @Override
            public void windowClosing(WindowEvent e) { //当游戏窗口关闭时退出程序
                System.exit(0);
            }
        });
        new  PaintThread().start();//启动PainThread线程
        addKeyListener(new KeyMonitor());//给窗口创建键盘监听
        for(int i = 0; i < 50; i++){
            bulletArray[i] = new Bullet();
        }
        /*for(Bullet e : bulletArray){
            e = new Bullet();
        }这种写法是错误的,foreach 不能初始化数组,不能改变数组内容*/
    }

    @Override
    public void paint(Graphics g) {    //自动被调用
        Color c = g.getColor();
        Font f = g.getFont();
        g.drawImage(sky,0,0,null);//显示背景天空图片;
        myPlane1.drawSelf(g);

        for(int i = 0; i < 50; i++){
            bulletArray[i].draw(g);
            boolean met = bulletArray[i].getRect().intersects(myPlane1.getRect());//利用矩形进行碰撞检测
            if(met){
                if(myPlane1.isLive()){
                    Date endTime = new Date();
                    period =(int)(endTime.getTime() - startTime.getTime())/1000;
                    myPlane1.setLive(false);
                }
                /**
                 * 待调试修复的爆炸模块
               if(boom == null){
                   boom = new Explode(myPlane1.getX(), myPlane1.getY());
                   boom.draw(g);
                }
                */

            }
            if(!myPlane1.isLive()){
                Font myFont = new Font("楷体",Font.BOLD,35);
                g.setFont(myFont);
                g.setColor((Color.PINK));
                g.drawString("存活时间:"+ period + "秒" , 200, 200);
            }
        }
        /*for(Bullet e : bulletArray){
            e.draw(g);
        }这种写法是错误的,foreach 不能初始化数组,不能改变数组内容*/
        g.setColor(c);
        g.setFont(f);
    }
    class PaintThread extends Thread{
        //帮助一直重画窗口
        @Override
        public void run() {
            while (true){
                repaint();//重画
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }

    //双缓冲技术就解决闪烁问题
    private Image offScreenImage;
    public void update(Graphics g){
        if(offScreenImage == null){
            offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        }
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }
}
