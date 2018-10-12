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
    Image ball = GameUtil.getImage("images/ball.png");
    public void launchFrame() {
        //初始化窗口的方法
        this.setTitle("Zeta's Plane");
        this.setSize(500, 500);
        this.setVisible(true);
        this.setLocation(500, 250);
        this.addWindowListener(new WindowAdapter() { //匿名内部类
            @Override
            public void windowClosing(WindowEvent e) { //当游戏窗口关闭时退出程序
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {    //自动被调用
        //画图方法
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

        g.drawImage(ball,250,250,null);
    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }
}
