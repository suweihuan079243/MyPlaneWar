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


	//�ػ��߳�
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
	 * ˫�������ػ�ͼƬ��˸����
	 * @param g
	 */
	public void update(Graphics g) {
		Graphics gOffScreen = planeImg.getGraphics();
		gOffScreen.fillRect(0, 0, 900, 900);
		paint(gOffScreen);
		g.drawImage(planeImg, 0, 0, null);
	}


	/**
	 * ���̼�����
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
			//���ô��ڱ���
			this.setTitle("̹�˴�ս");
			//���ô��ڴ�С��λ��
			this.setBounds(0, 0, 900, 900);
			//���ô��ڿ��ӻ�
			this.setVisible(true);

			//��Ӽ�����
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent arg0) {

					System.exit(0);
				}
			});

			//�����ػ��߳�
			new PaintThread().start();

			//��Ӽ��̼�����
			addKeyListener(new KeyMonitor());
		}
}
