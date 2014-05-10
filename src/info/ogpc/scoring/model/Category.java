package info.ogpc.scoring.model;

import java.util.Map;
import java.util.TreeMap;

public class Category implements Comparable<Category> {
	private String name;
	Map<Integer, Achievement> achievements;
	private Integer ranking;

	public Category(String _name, Integer _ranking) {
		name = _name;
		ranking = _ranking;
		achievements = new TreeMap<Integer, Achievement>();
	}

	public void addAchievement(String id, String name, int value,
			String description) {
		//The new integer is a hack because I don't want to go back and clean up all of the manual data
		if (achievements.put(new Integer(id), new Achievement(name, value, description)) != null)
			throw new RuntimeException("Duplicate achievement ID found");
	}

	public Map<Integer, Achievement> getAchievements() {
		return achievements;
	}

	public Achievement getAchievement(Integer id) {
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
