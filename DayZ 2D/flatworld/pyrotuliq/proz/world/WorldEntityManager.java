package pyrotuliq.proz.world;

import java.awt.Dimension;
import java.util.Random;

import pyrotuliq.proz.entity.Entity;
import pyrotuliq.proz.entity.MobEntity;

public class WorldEntityManager {
	/**
	 * This is the number limit that the RGN uses to calculate if it should spawn a MobEntity or not.
	 */
	public static final int MAX_RANDOM_NUMBER = 1024;
	private WorldMemory worldMemory;
	private Random random;
	private float mobFrequency;
	
	/**
	 * Creates a new WorldEntityManager with the WorldMemory object and a value from 0F to 1F which determines how often mobs should spawn.
	 * @param worldMemory The WorldMemory which stores the world and handles the data between this and it's world object.
	 * @param mobFrequency The spawn frequency for the mobs 0F to never spawn 1F to always spawn.
	 */
	public WorldEntityManager(WorldMemory worldMemory, float mobFrequency) {
		this.worldMemory = worldMemory;
		this.mobFrequency = mobFrequency < 0F ? 0F : mobFrequency > 1F ? 1F : mobFrequency;
		this.random = new Random();
	}
	
	/**
	 * This method is called on every tick. It spawns and despawns the necessary entities.
	 */
	public void update() {
		Dimension worldSize = worldMemory.getWorldSize();
		
		for (long uuid = 0; uuid < worldMemory.getEntityCount(); uuid++) {
			Entity entity = worldMemory.getEntity(uuid);
			
			if (entity == null) {
				uuid--;
				continue;
			}

			entity.decreaseLife();
			if (entity.getHealth() <= 0 || entity.getLife() == 0)
				worldMemory.despawnEntity(uuid);
			
			int randomInt = random.nextInt(MAX_RANDOM_NUMBER);
			
			if (randomInt < mobFrequency * MAX_RANDOM_NUMBER - 1)
				worldMemory.spawnEntity(new MobEntity(20, 2000), (int) (random.nextFloat() * worldSize.width), (int) (random.nextFloat() * worldSize.height));
		}
	}
}
