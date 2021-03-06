package info.ogpc.scoring.model;

import java.util.HashMap;

public class ScoringSheet {
	private HashMap<Integer, Integer> scoringMatrix;

	public ScoringSheet(Category _category) {
		Category category = _category;
		scoringMatrix = new HashMap<Integer, Integer>();

		// Initialize the scoring matrix to all zeros. When a team scores an
		// achievement this value will get filled with the points. By default it
		// will equal the achievement points but we want users to also be able
		// to override the value

		for (Integer achievementId : category.getAchievements().keySet()) {
			scoringMatrix.put(achievementId, new Integer(0));
		}

	}

	public void scoreAchievement(Integer id, Integer value) {
		scoringMatrix.put(id, value);
	}

	public Integer getAchievementValue(Integer id) {
		return scoringMatrix.get(id);
	}

	public Integer getTotalScore() {
		Integer total = new Integer(0);

		for (Integer id : scoringMatrix.keySet()) {
			total += scoringMatrix.get(id);
		}

		return total;
	}

	public String printLine() {
		StringBuilder sb = new StringBuilder();
		for (Integer id : scoringMatrix.keySet()) {
			sb.append(id + ",");
			sb.append(scoringMatrix.get(id) + ",");
		}
		sb.append("END,");

		return sb.toString();
	}

}
