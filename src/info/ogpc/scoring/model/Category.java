package info.ogpc.scoring.model;

import java.util.Collection;
import java.util.LinkedList;

public class Category {
	private String name;
	Collection<Achievement> achievements;

	public Category(String _name) {
		name = _name;
		achievements = new LinkedList<Achievement>();
	}

	public void addAchievement(String name, int value, String description) {
		achievements.add(new Achievement(name, value, description));
	}

	public Collection<Achievement> getAchievements() {
		return achievements;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return getName();
	}
}
