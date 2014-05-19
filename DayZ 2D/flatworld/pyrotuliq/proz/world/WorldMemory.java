package pyrotuliq.proz.world;

import java.awt.Dimension;

import pyrotuliq.proz.entity.Entity;

public interface WorldMemory {
	/**
	 * Spawns the specified entity at the specified location.
	 * @param entity The entity to spawn.
	 * @param x The x coordinate of the world location to spawn it.
	 * @param y The y coordinate of the world location to spawn it.
	 */
	public void spawnEntity(Entity entity, int x, int y);
	
	/**
	 * Gets the entity with the specified UUID.
	 * @param uuid The UUID of the entity.
	 * @return The entity which has been found with the specified UUID, otherwise null.
	 */
	public Entity getEntity(long uuid);
	
	/**
	 * Gets the number of entities that have been spawned in the world.
	 * @return The number of entities that have been spawned, excluding the player's entity.
	 */
	public long getEntityCount();
	
	/**
	 * Gets the world's tile size.
	 * @return The world's tile size.
	 */
	public Dimension getWorldSize();
	
	/**
	 * Despawns the entity with the specified UUID.
	 * @param uuid The UUID of the entity to despawn.
	 */
	public void despawnEntity(long uuid);
}
