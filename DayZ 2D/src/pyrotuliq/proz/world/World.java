package pyrotuliq.proz.world;

import java.util.HashMap;
import java.util.Map;

import pyrotuliq.proz.entity.Entity;
import pyrotuliq.proz.tile.Tile;

/**
 * Manages all the data about the world, the entities and the tiles.
 */
public class World {
	private Map<Long, Entity> entities;
	private Tile[][] tiles;
	private float scale;
	
	/**
	 * Enumeration of all possible entity movement directions.
	 */
	public static enum Direction {
		UP, DOWN, LEFT, RIGHT;
	}
	
	/**
	 * Creates a new world with specified scale, width and height.
	 * @param scale The scale for rendering the world. Defaults to 1 if smaller or equal to 0.
	 * @param width The number of tiles that can be stored horizontally. Defaults to 1 if smaller than 1.
	 * @param height The number of tiles that can be stored vertically. Defaults to 1 if smaller than 1.
	 */
	public World(float scale, int width, int height) {
		if (scale <= 0)
			scale = 1;
		if (width < 1)
			width = 1;
		if (height < 1)
			height = 1;
		
		this.scale = scale;
		tiles = new Tile[width][height];
		entities = new HashMap<>();
	}
	
	/**
	 * Creates a new world using the specified scale and the tile array array.
	 * @param scale The scale for rendering the world. Defaults to 1 if smaller or equal to 0.
	 * @param tiles The tile array array that will predefine all the tiles. Defaults to 16x16 array of null tiles if null.
	 */
	public World(float scale, Tile[][] tiles) {
		if (scale <= 0)
			scale = 1;
		if (tiles == null)
			tiles = new Tile[16][16];
		this.scale = scale;
		this.tiles = tiles;
		entities = new HashMap<>();
	}
	
	/**
	 * Spawns the specified entity at the specified position.
	 * The specified entity cannot be spawned more than once in each world!
	 * @param entity The entity you want to spawn.
	 * @param x The x coordinate at which you want to spawn it.
	 * @param y The y coordinate at which you want to spawn it.
	 * @return True if the entity was successfully spawned.
	 */
	public boolean spawnEntity(Entity entity, int x, int y) {
		if (x < 0 || x >= tiles.length || y < 0 || y >= tiles[x].length)
			return false;
		if (tiles[x][y].isSolid())
			return false;
		entities.put(entity.getUUID(), entity);
		tiles[x][y].onStepOn(entity);
		return true;
	}
	
	/**
	 * Gets the tile at the specified location.
	 * @param x The x coordinate for the location of the tile.
	 * @param y The y coordinate for the location of the tile.
	 * @return The tile found at the specified coordinates, otherwise null.
	 */
	public Tile getTile(int x, int y) {
		if (x < 0 || x >= tiles.length || y < 0 || y >= tiles[x].length)
			return null;
		return tiles[x][y];
	}
	
	/**
	 * Gets the scale for rendering this world.
	 * @return The scale for rendering this world.
	 */
	public float getScale() {
		return scale;
	}
	
	public int getWidth() {
		return tiles.length;
	}
	
	public int getHeight() {
		return tiles[0].length;
	}
	
	/**
	 * Gets the entity who's UUID is the specified long.
	 * @return The entity at the specified UUID, otherwise null.
	 */
	public Entity getEntity(long uuid) {
		if (entities.containsKey(uuid))
			return entities.get(uuid);
		return null;
	}
	
	/**
	 * Sets the tile at the specified location.
	 * @param tile The new tile.
	 * @param x The x coordinate for the old tile.
	 * @param y The y coordinate for the old tile.
	 * @return True if the tile was changed.
	 */
	public boolean setTile(Tile tile, int x, int y) {
		if (x < 0 || x >= tiles.length || y < 0 || y >= tiles[x].length)
			return false;
		tiles[x][y] = tile;
		return true;
	}
}
