package info.ogpc.scoring.model;

import java.util.HashMap;
import java.util.Map;

public class Category {
	private String name;
	Map<String, Achievement> achievements;

	public Category(String _name) {
		name = _name;
		achievements = new HashMap<String, Achievement>();
	}

	public void addAchievement(String id, String name, int value, String description) {
		if (achievements.put(id, new Achievement(name, value, description)) != null)
			throw new RuntimeException("Duplicate achievement ID found");
	}

	public Map<String,Achievement> getAchievements() {
		return achievements;
	}

	public Achievement getAchievement(String id) {
		return achievements.get(id);
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return getName();
	}
}
