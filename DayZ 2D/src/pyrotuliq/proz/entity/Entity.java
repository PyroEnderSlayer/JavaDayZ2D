package pyrotuliq.proz.entity;

import java.util.Map;

public class Entity {
	private static Map<Long, Entity> entities;
	private static long nextUUID = 0;
	private long uuid;
	
	public Entity() {
		this.uuid = nextUUID++;
	}
	
	public static Entity getEntityFromID(long uuid) {
		if (entities.containsKey(uuid))
			return entities.get(uuid);
		return null;
	}
	
	public long getUUID() {
		return uuid;
	}
}
