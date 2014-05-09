package info.ogpc.scoring.model;

import info.ogpc.scoring.main.Main;

import java.util.HashMap;
import java.util.Map;

public class Team implements Comparable<Team>{
	private String coachLastName;
	private String coachFirstName;
	private String name;
	private SchoolType schoolType;
	private String schoolName;
	private int numberOfStudents;
	private String teamId;
	private Map<Category, ScoringSheet> scoringSheets;
	private Boolean isRookie = new Boolean(false);

	public Team(String _teamId, String _coachLastName, String _coachFirstName,
			String _name, SchoolType _schoolType, String _schoolName,
			int _numberOfStudents, String _isRookie) {
		teamId = _teamId;
		coachLastName = _coachLastName;
		coachFirstName = _coachFirstName;
		name = _name;
		schoolType = _schoolType;
		schoolName = _schoolName;
		numberOfStudents = _numberOfStudents;
		scoringSheets = new HashMap<Category, ScoringSheet>();
		isRookie = new Boolean(_isRookie);
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

	public char[] printLine() {
		StringBuilder outputLine = new StringBuilder();
		outputLine.append(getTeamId()+",");
		outputLine.append(getName()+",");
		outputLine.append(getCoachLastName()+",");
		outputLine.append(getCoachFirstName()+",");
		outputLine.append(getSchoolType()+",");
		outputLine.append(getSchoolName()+",");
		outputLine.append(getNumberOfStudents()+",");
		outputLine.append(isRookie()+",");

		for (Category category : scoringSheets.keySet()) {
			ScoringSheet sheet = scoringSheets.get(category);
			outputLine.append(category.getName()+",");
			outputLine.append(sheet.printLine());
		}
		outputLine.append("EOL");
		return outputLine.toString().toCharArray();
	}

	public Team(String data) {
		OGPCDataModel dataModel = Main.getDataModel();

		//For File I/O, comma delimited string
		String[] parsedData = data.split(",");
		teamId = parsedData[0];
		name = parsedData[1];
		coachLastName = parsedData[2];
		coachFirstName = parsedData[3];

		if (parsedData[4].equals("HIGH_SCHOOL"))
			schoolType = SchoolType.HIGH_SCHOOL;
		else
			schoolType = SchoolType.MIDDLE_SCHOOL;
		
		schoolName = parsedData[5];
		numberOfStudents = new Integer(parsedData[6]);
		isRookie = new Boolean(parsedData[7]);
		System.out.println(data);

		System.out.println("teamId: "+teamId+" - "+ coachLastName+ " - " +coachFirstName+ " - " +name
				+ " - " +schoolType+ " - " + schoolName+" - " +numberOfStudents + " - "+ isRookie);
		isRookie = new Boolean(parsedData[7]);
		
		Category category = dataModel.getCategory(parsedData[8]);
		ScoringSheet tempSheet = new ScoringSheet(category);
		scoringSheets = new HashMap<Category, ScoringSheet>();
		for (int i = 9; i <= parsedData.length; i+=2) {
			if (parsedData[i].equals("END")) {
				i++; //increment the index to skip "END"
				scoringSheets.put(category, tempSheet);
				System.out.println("adding new sheet");

				if (parsedData[i].equals("EOL")) //we've reached the end 
					break;
				
				category = dataModel.getCategory(parsedData[i]);
				tempSheet = new ScoringSheet(category);
				i++;//increment index as we just handled the category name
			}
			tempSheet.scoreAchievement(parsedData[i], new Integer(parsedData[i+1]));
		}
		
	
	}


	@Override
	public int compareTo(Team o) {
		// TODO Auto-generated method stub
		return name.compareToIgnoreCase(o.getName());
	}


	public boolean isRookie() {
		return isRookie;
	}


	public Integer calculateBestInShow() {
		Integer total = new Integer(0);
		for (Category category : scoringSheets.keySet()) {
			ScoringSheet sheet = scoringSheets.get(category);
			total += sheet.getTotalScore();
		}
		return total;
	}


	public void setRookie(boolean selected) {
		isRookie = selected;
		
	}
	
}
