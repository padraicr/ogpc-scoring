package info.ogpc.scoring.model;

import java.util.Map;
import java.util.TreeMap;

public class Category implements Comparable<Category> {
	private String name;
	Map<String, Achievement> achievements;
	private Integer ranking;

	public Category(String _name, Integer _ranking) {
		name = _name;
		ranking = _ranking;
		achievements = new TreeMap<String, Achievement>();
	}

	public void addAchievement(String id, String name, int value,
			String description) {
		if (achievements.put(id, new Achievement(name, value, description)) != null)
			throw new RuntimeException("Duplicate achievement ID found");
	}

	public Map<String, Achievement> getAchievements() {
		return achievements;
	}

	public Achievement getAchievement(String id) {
		return achievements.get(id);
	}

	public String getName() {
		return name;
	}

	public Integer getRanking() {
		return ranking;
	}

	@Override
	public String toString() {
		return getName();
	}

	@Override
	public int compareTo(Category o) {
		return ranking.compareTo(o.getRanking());
	}
}
