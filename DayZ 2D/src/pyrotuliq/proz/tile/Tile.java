package pyrotuliq.proz.tile;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import pyrotuliq.proz.entity.Entity;
import pyrotuliq.proz.lang.IDConflictError;

public class Tile {
	protected Image tileIcon;
	private static Map<Integer, Tile> tiles = new HashMap<>();
	private int id;
	private String textureName;
	
	protected Tile(int id) {
		if (tiles.containsKey(tiles))
			throw new IDConflictError("Tile " + id + " already exists!");
		
		this.textureName = "unnamed";
		this.id = id;
	}
	
	public void onStepOn(Entity entity) {
		// DO NOTHING
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public void setTextureName(String textureName) {
		this.textureName = textureName;
	}
	
	public String getTextureName() {
		return this.textureName;
	}
	
	public int getID() {
		return this.id;
	}
	
	public void registerIcon(IconRegister iconRegister) {
		// TODO Code register icon to register an icon located at "[icon]"
	}
}