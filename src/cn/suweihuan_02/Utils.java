package cn.suweihuan_02;
/**
 *	 工具类
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return bufferedImage;		
	}
}
