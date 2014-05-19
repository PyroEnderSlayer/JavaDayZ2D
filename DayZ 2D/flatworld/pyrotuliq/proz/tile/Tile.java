package pyrotuliq.proz.tile;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import pyrotuliq.proz.entity.Entity;
import pyrotuliq.proz.graphics.IconRegister;
import pyrotuliq.proz.internal.IDConflictError;

public class Tile {
	protected BufferedImage tileIcon;
	private static Map<Integer, Tile> tiles = new HashMap<>();
	private int id;
	private String textureName;
	
	protected Tile(int id) {
		if (tiles.containsKey(tiles))
			throw new IDConflictError("Tile " + id + " already exists!");
		
		this.textureName = "unnamed";
		this.id = id;
	}
	
	/**
	 * Is called when an entity steps on the tile.
	 * @param entity The entity that stepped on the tile.
	 */
	public void onStepOn(Entity entity) {
		// DO NOTHING
	}
	
	/**
	 * Checks if entities can walk through this tile.
	 * @return True if the tile cannot be walked through.
	 */
	public boolean isSolid() {
		return false;
	}
	
	/**
	 * Sets the texture file for this tile.
	 * @param textureName The name of the file to load without file extension.
	 */
	public void setTextureName(String textureName) {
		this.textureName = textureName;
	}
	
	/**
	 * Gets the texture file for this tile.
	 * @return The name of the texture file for this tile.
	 */
	public String getTextureName() {
		return this.textureName;
	}
	
	public final BufferedImage getIcon() {
		return this.tileIcon;
	}
	
	/**
	 * Gets the id for this tile.
	 * @return The id for this tile.
	 */
	public int getID() {
		return this.id;
	}
	
	/**
	 * Registers the icon(s) required to display this tile.
	 * @param iconRegister The IconRegister that will load the texture(s).
	 */
	public void registerIcon(IconRegister iconRegister) {
		// TODO Code register icon to register an icon located at "[icon]"
	}
}