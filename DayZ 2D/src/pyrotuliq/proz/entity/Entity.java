package pyrotuliq.proz.entity;

import java.util.Map;

public class Entity {
	private static Map<Long, Entity> entities;
	private static long nextUUID = -1;
	private long uuid;
	private int health;
	
	/**
	 * Creates a new Entity with of health 0.
	 * @param health
	 */
	public Entity(int health) {
		this.uuid = nextUUID++;
		this.health = health;
	}
	
	/**
	 * Gets the entity corresponding to the UUID.
	 * @param uuid The UUID of the entity you are looking for.
	 * @return The entity which has the entered UUID, otherwise null.
	 */
	public static Entity getEntityFromID(long uuid) {
		if (entities.containsKey(uuid))
			return entities.get(uuid);
		return null;
	}
	
	/**
	 * Gets the UUID of this entity.
	 * @return This entity's UUID.
	 */
	public long getUUID() {
		return uuid;
	}
	
	/**
	 * Gets the health of this entity.
	 * @return This entity's health.
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * Sets the health of this entity.
	 * @param health The new health for this entity.
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	
	/**
	 * Damages this entity by the entered value and returns the new health for the entity.
	 * @param health How much damage you want to deal to this entity.
	 * @return The health this entity has after damaging it.
	 */
	public int damage(int health) {
		if (this.health - health < 0)
			this.health = 0;
		this.health -= health;
		return this.health;
	}
	
	/**
	 * Heals this entity by the specified amount of health and returns it's new health.
	 * @param health How much you want to heal this entity.
	 * @return This entity's new health.
	 */
	public int heal(int health) {
		if (this.health + health < 0)
			this.health = 0;
		this.health += health;
		return this.health;
	}
}
