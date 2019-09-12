package cn.suweihuan_01;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PlaneFactory {
    private  Image image;
    public int  plane_X;
    public  int  plane_Y;
    private int plane_Width;
    private int plane_Height;

    public boolean left;
    public boolean right;
    public boolean up;
    public boolean down;


    public void drawPlane(Graphics graphics){
        graphics.drawImage(image,plane_X ,plane_Y,null );
        if(left){
            plane_X-=5;
        }else if(right){
            plane_X+=5;
        }else if(up){
            plane_Y-=5;
        }else if(down){
            plane_Y+=5;
        }
    }

    public PlaneFactory(Image image, int plane_X, int plane_Y, int plane_Width, int plane_Height) {
        this.image = image;
        this.plane_X = plane_X;
        this.plane_Y = plane_Y;
        this.plane_Width = plane_Width;
        this.plane_Height = plane_Height;
    }

    public PlaneFactory(Image image, int plane_X, int plane_Y) {
        this.image = image;
        this.plane_X = plane_X;
        this.plane_Y = plane_Y;
    }

    /**
     * 返回飞机所在的矩形，用于碰撞检测
     * @return
     */
    public Rectangle getRectangle(){
        return new Rectangle(plane_X,plane_Y,plane_Width,plane_Height);
    }

    /**
     * 按下键盘调整方向
     * @param e
     */
    public void addDirections(KeyEvent e){
//        if((e.getKeyCode())==37){
//            //左
//          left=true;
//        }else if((e.getKeyCode())==38){
//            //上
//          up=true;
//        }else if((e.getKeyCode())==39){
//            //右
//            right=true;
//        }else if((e.getKeyCode()==40)){
//            //下
//            down=true;
//        }
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left=true;
                break;
            case KeyEvent.VK_RIGHT:
                    right=true;
                    break;
            case KeyEvent.VK_UP:
                        up=true;
                        break;
            case KeyEvent.VK_DOWN:
                            down=true;
                            break;
        }
    }

    public void subDiretions(KeyEvent e){
//        if((e.getKeyCode())==37){
//            //左
//            left=false;
//        }else if((e.getKeyCode())==38){
//            //上
//            up=false;
//        }else if((e.getKeyCode())==39){
//            //右
//            right=false;
//        }else if((e.getKeyCode()==40)){
//            //下
//            down=false;
//        }

        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left=false;
                break;
            case KeyEvent.VK_RIGHT:
                right=false ;
                break;
            case KeyEvent.VK_UP:
                up=false ;
                break;
            case KeyEvent.VK_DOWN:
                down= false ;
                break;
        }
    }
}



