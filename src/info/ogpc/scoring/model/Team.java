package info.ogpc.scoring.model;

public class Team {
	private String coachLastName;
	private String coachFirstName;
	private String name;
	private SchoolType schoolType;
	private String schoolName;
	private int numberOfStudents;
	
	public String getCoachLastName() {
		return coachLastName;
	}
	public void setCoachLastName(String coachLastName) {
		this.coachLastName = coachLastName;
	}
	public String getCoachFirstName() {
		return coachFirstName;
	}
	public void setCoachFirstName(String coachFirstName) {
		this.coachFirstName = coachFirstName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SchoolType getSchoolType() {
		return schoolType;
	}
	public void setSchoolType(SchoolType schoolType) {
		this.schoolType = schoolType;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	
}
