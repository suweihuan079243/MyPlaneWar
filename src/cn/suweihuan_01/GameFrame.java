package cn.suweihuan_01;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import cn.suweihuan_02.Utils;

public class GameFrame extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -9197948383446226227L;

	private Image bgImg = Utils.getImage("bg.jpg");

	private Image planeImg = Utils.getImage("plane.png");

	//private int plane_X=450;

	//private int plane_Y=900;

	PlaneFactory plane = new PlaneFactory(planeImg, 450, 800);


	@Override
	public void paint(Graphics g) {
//		g.drawOval(100,100,200,300);
		//g.drawRect(100,100,200,300);
		//g.drawImage(myTank, 200, 200, null);
		//g.dr	awLine(100,100,200,300);

		g.drawImage(bgImg, 0, 0, null);
		plane.drawPlane(g);

	}


	//重画线程
	class PaintThread extends Thread {

		@Override
		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 双缓冲解决重画图片闪烁问题
	 * @param g
	 */
	public void update(Graphics g) {
		Graphics gOffScreen = planeImg.getGraphics();
		gOffScreen.fillRect(0, 0, 900, 900);
		paint(gOffScreen);
		g.drawImage(planeImg, 0, 0, null);
	}


	/**
	 * 键盘监听器
	 */
	class KeyMonitor extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			plane.addDirections(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			plane.subDiretions(e);

		}
	}
		public void launchFrame() {
			//设置窗口标题
			this.setTitle("坦克大战");
			//设置窗口大小和位置
			this.setBounds(0, 0, 900, 900);
			//设置窗口可视化
			this.setVisible(true);

			//添加监听器
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent arg0) {

					System.exit(0);
				}
			});

			//启动重画线程
			new PaintThread().start();

			//添加键盘监听器
			addKeyListener(new KeyMonitor());
		}
}
