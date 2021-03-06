	package pyrotuliq.proz.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import pyrotuliq.proz.ProZ;

public class IconRegister {
	private static IconRegister instance;
	
	private IconRegister() {
		// DO NOTHING
	}
	
	public static IconRegister instance() {
		return instance == null ? instance = new IconRegister() : instance;
	}
	
	/**
	 * Loads the image at "assets/textures/tile/[icon].png" and returns it in the form of a BufferedImage object if it is 32x32 pixels.
	 * @param icon The name of the icon file.
	 * @return The image that was loaded from the file, otherwise null.
	 */
	public BufferedImage createTileIcon(String icon) {
		try {
			BufferedImage image = ImageIO.read(ProZ.class.getClassLoader().getResourceAsStream("assets/textures/tile/" + icon + ".png"));
			if (image.getWidth() != 32 || image.getHeight() != 32) {
				System.err.println("Failed to load texture: Invalid texture size");
				return null;
			}
			return image;
		} catch (IOException e) {
			System.err.println("Failed to load texture: " + icon);
			return null;
		}
	}
	
	/**
	 * Loads the image at "assets/textures/gui/[icon].png" and returns it in the form of a BufferedImage object.
	 * @param icon The name of the icon file.
	 * @return The image that was loaded from the file, otherwise null.
	 */
	public BufferedImage createGuiIcon(String icon) {
		try {
			BufferedImage image = ImageIO.read(ProZ.class.getClassLoader().getResourceAsStream("assets/textures/gui/" + icon + ".png"));
			return image;
		} catch (IOException e) {
			System.err.println("Failed to load texture: " + icon);
			return null;
		}
	}
	
	/**
	 * Loads the image at "assets/textures/entity/[icon].png" and returns it in the form of a BufferedImage object if it is 32x32 pixels.
	 * @param icon The name of the icon file.
	 * @return The image that was loaded from the file, otherwise null.
	 */
	public BufferedImage createEntityIcon(String icon) {
		try {
			BufferedImage image = ImageIO.read(ProZ.class.getClassLoader().getResourceAsStream("assets/textures/entity/" + icon + ".png"));
			if (image.getWidth() != 32 || image.getHeight() != 32) {
				System.err.println("Failed to load texture: Invalid texture size");
				return null;
			}
			return image;
		} catch (IOException e) {
			System.err.println("Failed to load texture: " + icon);
			return null;
		}
	}
}
