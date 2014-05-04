package info.ogpc.scoring.model;

import java.util.Collection;
import java.util.Map;

public class Team {
	private String coachLastName;
	private String coachFirstName;
	private String name;
	private SchoolType schoolType;
	private String schoolName;
	private int numberOfStudents;
	private String teamId;

	public Team(String _teamId, String _coachLastName, String _coachFirstName, String _name,
			SchoolType _schoolType, String _schoolName, int _numberOfStudents) {
		teamId = _teamId;
		coachLastName = _coachLastName;
		coachFirstName = _coachFirstName;
		name = _name;
		schoolType = _schoolType;
		schoolName = _schoolName;
		numberOfStudents = _numberOfStudents;

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

}
