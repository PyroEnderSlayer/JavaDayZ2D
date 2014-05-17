package pyrotuliq.proz.tile;

import pyrotuliq.proz.graphics.IconRegister;

public class WallTile extends Tile {
	public WallTile(int id) {
		super(id);
	}
	
	@Override
	public void registerIcon(IconRegister register) {
		this.tileIcon = register.createTileIcon("wall");
	}
}