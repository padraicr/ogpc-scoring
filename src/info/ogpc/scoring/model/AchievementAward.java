package info.ogpc.scoring.model;

import java.util.HashMap;
import java.util.Map;

public class AchievementAward {
	private String name;
	private Map achievements;

	public AchievementAward(String _name) {
		this.name = _name;
		achievements = new HashMap();
	}

	public void addAchievement(String name, int value) {
		if (achievements.get(name) == null)
			achievements.put(name, value);
		else
			throw new IllegalArgumentException(
					"Duplicate achievement key found");

	}
}
