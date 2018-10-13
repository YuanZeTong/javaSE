package top.yztprocs.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Function : game's main window
 *
 * @author Zeta
 */
public class MyGameFrame extends JFrame {
    Image sky = GameUtil.getImage("images/sky.jpg");
    Image plane = GameUtil.getImage("images/plane.png");
    Plane myPlane1 = new Plane(plane, 300, 360,3);
    Plane myPlane2 = new Plane(plane, 350, 360,3);
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
        this.setSize(650, 406);
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
    }

    @Override
    public void paint(Graphics g) {    //自动被调用
        g.drawImage(sky,0,0,null);//显示背景天空图片;
        myPlane1.drawSelf(g);
        myPlane2.drawSelf(g);
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
}
