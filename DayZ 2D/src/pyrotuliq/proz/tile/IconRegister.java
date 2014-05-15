	package pyrotuliq.proz.tile;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import pyrotuliq.proz.ProZ;

public class IconRegister {
	private IconRegister() {
		// DO NOTHING
	}
	
	/**
	 * Loads the image at "assets/textures/[icon].png" and returns it in the form of an Image object if it is 32x32 pixels.
	 * @param icon The name of the icon file.
	 * @return The image that was loaded from the file, otherwise null.
	 */
	public Image registerIcon(String icon) {
		try {
			BufferedImage image = ImageIO.read(ProZ.class.getResourceAsStream("assets/textures/" + icon + ".png"));
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
