package top.yztprocs.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GameUtil {
    //图片加载类
    private GameUtil(){
    }  //工具类最好将构造器私有化。
    public static Image getImage(String path){
        BufferedImage bi = null;
        try{
            URL u = GameUtil.class.getClassLoader().getResource(path);
            bi = ImageIO.read(u);
        } catch (IOException e){
            e.printStackTrace();
        }
        return bi;
    }
}
