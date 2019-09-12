package cn.suweihuan_01;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 子弹类
 */
public class Bullet {
    private double  bullet_Height;
    private double bullet_Width;
    private int bullet_X;
    private int bullet_Y;
    private int bullet_Speed=5;
    public static boolean flag=false;

    public Bullet(PlaneFactory plane){
        bullet_X=plane.plane_X;
        bullet_Y=plane.plane_Y;

        bullet_Height=10;
        bullet_Width=10;
    }

    public void drawBullet(Graphics graphics){
       if(flag){
           while(bullet_Y>=0){
               graphics.fillOval(bullet_X, bullet_Y, (int)bullet_Width,(int) bullet_Height);
               bullet_Y-=bullet_Speed;
           }
        }
    }

    public void generateBullet(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_SPACE:
                flag=true;
                break;
        }
    }

    public void stopGenerateBullet(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_SPACE:
                flag=false;
                break;
        }
    }
}
