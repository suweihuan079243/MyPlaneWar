package cn.suweihuan_02;
/**
 *	 ������
 * @author Administrator
 *
 */

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class Utils {
	private Utils() {
		
	}
	
	public static Image getImage(String path) {
		BufferedImage bufferedImage=null;
		try {
		URL url=Utils.class.getClassLoader().getResource(path);
		bufferedImage=ImageIO.read(url);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return bufferedImage;		
	}
}
