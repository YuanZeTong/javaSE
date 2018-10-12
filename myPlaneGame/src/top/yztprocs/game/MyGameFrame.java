package top.yztprocs.game;

import javax.swing.*;
import java.awt.*;
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
    int xPlane = 300, yPlane = 356;
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
    }

    @Override
    public void paint(Graphics g) {    //自动被调用
        //画图方法
        /*
        Color c = g.getColor(); //备份画笔颜色和字体
        Font b = g.getFont();

        g.setColor(Color.BLUE);
        g.drawLine(100, 100, 300, 300);
        g.drawRect(100, 100, 300, 300);
        g.drawOval(100, 100, 40, 40);
        g.setColor(Color.red);
        g.setFont(new Font("楷体", Font.BOLD, 50));
        g.drawString("Zeta's plane!", 100, 100);

        g.setColor(c);//还原画笔颜色和字体
        g.setFont(b);
        */

        g.drawImage(sky,0,0,null);
        g.drawImage(plane, xPlane, yPlane, null);
        xPlane++;
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
