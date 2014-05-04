package info.ogpc.scoring.model;

import info.ogpc.scoring.view.Main;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Team {
	private String coachLastName;
	private String coachFirstName;
	private String name;
	private SchoolType schoolType;
	private String schoolName;
	private int numberOfStudents;
	private String teamId;
	private Map<Category, ScoringSheet> scoringSheets;

	public Team(String _teamId, String _coachLastName, String _coachFirstName,
			String _name, SchoolType _schoolType, String _schoolName,
			int _numberOfStudents) {
		teamId = _teamId;
		coachLastName = _coachLastName;
		coachFirstName = _coachFirstName;
		name = _name;
		schoolType = _schoolType;
		schoolName = _schoolName;
		numberOfStudents = _numberOfStudents;
		scoringSheets = new HashMap<Category, ScoringSheet>();

	}
	
	@Override
	public String toString() {
		return name;
	}

	public void initScoringSheet() {
		OGPCDataModel dataModel = Main.getDataModel();
		for (Category category : dataModel.getCategories()) {
			scoringSheets.put(category, new ScoringSheet(category));
		}

	}

	public String getTeamId() {
		return teamId;
	}

	public String getCoachLastName() {
		return coachLastName;
	}

	public String getCoachFirstName() {
		return coachFirstName;
	}

	public String getCoachName() {
		return coachFirstName + " " + coachLastName;
	}

	public String getName() {
		return name;
	}

	public SchoolType getSchoolType() {
		return schoolType;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public Map<Category, ScoringSheet> getScoringSheets() {
		return scoringSheets;
	}

	public ScoringSheet getScoringSheet(Category category) {
		ScoringSheet sheet = scoringSheets.get(category);
		if (sheet != null)
			return sheet;
		else
			throw new RuntimeException(
					"getScoringSheet - Can not find scoringSheet for category:"
							+ category);
	}

	public void scoreAchievement(Category category, String achievementId,
			Integer value) {
		ScoringSheet scoringSheet = scoringSheets.get(category);
		if (scoringSheet == null)
			throw new RuntimeException(
					"scoreAchievement - Can not find scoringSheet for category:"
							+ category);
		System.out.println("scoring achievement - "+value);
		scoringSheet.scoreAchievement(achievementId, value);

	}

	public void scoreAchievement(Category category, String achievementId) {
		ScoringSheet scoringSheet = scoringSheets.get(category);
		if (scoringSheet == null)
			throw new RuntimeException(
					"scoreAchievement - Can not find scoringSheet for category:"
							+ category);
		Achievement achievement = category.getAchievement(achievementId);
		System.out.println("scoring achievement - "+achievement.getPointValue());
		scoringSheet.scoreAchievement(achievementId, achievement.getPointValue());

	}

}
