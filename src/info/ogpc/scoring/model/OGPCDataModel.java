package info.ogpc.scoring.model;

import java.util.Collection;
import java.util.LinkedList;

public class OGPCDataModel {
	
	Collection<Category> categories = new LinkedList<Category>();
	Collection<Team> teams = new LinkedList<Team>();
	
	public OGPCDataModel() {
		
		//Hardcoding the data model, if time will make it dynamic.
		Category programming = new Category("Programming");
		programming.addAchievement("Way of the Wanderer", 15, "Show a diagram of at least one element of the game logic (i.e. decision tree, AI process, player progression)");
		categories.add(programming);
		
		categories.add(new Category("Game Mechanics"));
		categories.add(new Category("Art and Assets"));
		categories.add(new Category("Theme and Style"));
		categories.add(new Category("Teamwork"));
		categories.add(new Category("Professionalism"));
		teams.add(new Team("701","Freman", "Patrick", "Franklin Laser Cats", SchoolType.MIDDLE_SCHOOL,"Lucidyne Technologies, Inc.",0));
		teams.add(new Team("702","Gasper", "John", "Game Droid", SchoolType.MIDDLE_SCHOOL,"<Unknown>",0));
		teams.add(new Team("703","Gordon", "Lynda", "Level Up", SchoolType.MIDDLE_SCHOOL,"Cedar Park Middle School",0));
		teams.add(new Team("704","Jamalapuram", "Sairama", "Three Amigos", SchoolType.MIDDLE_SCHOOL,"<Unknown>",0));
		teams.add(new Team("705","Jhala", "Bhadraraj", "SmartGamers", SchoolType.MIDDLE_SCHOOL,"Nike",0));
		teams.add(new Team("706","Menon", "Narayan", "Bad Robots", SchoolType.MIDDLE_SCHOOL,"<Unknown>",0));
		
		teams.add(new Team("901","Horner", "Linda", "Lebanaon Tech Warriors", SchoolType.HIGH_SCHOOL,"Lebanon High School",0));
		teams.add(new Team("902","Datta", "Chitra", "Glitchbusters", SchoolType.HIGH_SCHOOL,"<Unknown>",0));
		teams.add(new Team("903","Hubbard", "Jill", "Crimsonites", SchoolType.HIGH_SCHOOL,"Tigard Tualatin School District",0));
		teams.add(new Team("904","Meyers", "Bill", "Powerful Pixels", SchoolType.HIGH_SCHOOL,"Ashland High School",0));
		teams.add(new Team("905","Owings", "Ron", "BullDawgs Bashers", SchoolType.HIGH_SCHOOL,"Sutherlin High school",0));
		teams.add(new Team("906","Macdonald", "Randy", "<Unknown>", SchoolType.HIGH_SCHOOL,"Franklin High School",0));
		teams.add(new Team("907","Smith", "Terrel", "SHS OGPC Team", SchoolType.HIGH_SCHOOL,"Sherwood High School",0));
		teams.add(new Team("908","Cuthbert", "Laura", "Error 404: The Team You Are Looking for Does Not Exist", SchoolType.HIGH_SCHOOL,"Clover STEMs Science Club: Deschutes Co 4-H",0));
		teams.add(new Team("909","Macdonald", "Randy", "<Unknown>", SchoolType.HIGH_SCHOOL,"Franklin High School",0));
		teams.add(new Team("910","Seawright", "Andrew", "Sandwich Mafia", SchoolType.HIGH_SCHOOL,"Riverdale / LO ",0));
		teams.add(new Team("911","Boley", "Jan", "Astral Horde", SchoolType.HIGH_SCHOOL,"Crescent Valley High School",0));
		teams.add(new Team("912","Fulton", "Steve", "Tiny Walrus Interactive", SchoolType.HIGH_SCHOOL,"Tigard High School",0));
		teams.add(new Team("913","Bartlo", "Chris", "<Unknown>", SchoolType.HIGH_SCHOOL,"Wilson High School",0));
		teams.add(new Team("914","Fassio", "Erin", "Melted Gravel Software", SchoolType.HIGH_SCHOOL,"Amity High School",0));
		teams.add(new Team("915","Bartlo", "Chris", "Based Trojans", SchoolType.HIGH_SCHOOL,"Wilson High School",0));
		teams.add(new Team("916","Boley", "Jan", "Penteract", SchoolType.HIGH_SCHOOL,"Crescent Valley High School",0));
		teams.add(new Team("917","Fulton", "Steve", "Bumbler Interactive", SchoolType.HIGH_SCHOOL,"Tigard High School",0));
		teams.add(new Team("918","Galbraith", "Jason", "Incarnate Infinity", SchoolType.HIGH_SCHOOL,"Sunset High School",0));
		teams.add(new Team("919","Galbraith", "Jason", "Project Gyme", SchoolType.HIGH_SCHOOL,"Sunset High School",0));
		teams.add(new Team("920","Fulton", "Steve", "Fire-Breathing Kittens", SchoolType.HIGH_SCHOOL,"Tigard High School",0));
		teams.add(new Team("921","Galbraith", "Jason", "IDEK Gaming", SchoolType.HIGH_SCHOOL,"Sunset High School",0));
		teams.add(new Team("922","Bartlo", "Chris", "Ballad Games", SchoolType.HIGH_SCHOOL,"Wilson High School",0));
		teams.add(new Team("923","Boley", "Jan", "GLOVE Studio", SchoolType.HIGH_SCHOOL,"Crescent Valley High School",0));
		teams.add(new Team("924","Fulton", "Steve", "TANSTAAFL!", SchoolType.HIGH_SCHOOL,"Tigard High School",0));
		teams.add(new Team("925","Galbraith", "Jason", "Fire-breathing Rubber Duckies", SchoolType.HIGH_SCHOOL,"Sunset High School",0));
		teams.add(new Team("926","Galbraith", "Jason", "Direct Entertainment Revolution Project", SchoolType.HIGH_SCHOOL,"Sunset High School",0));
		teams.add(new Team("927","Bartlo", "Chris", "Magma Drakes", SchoolType.HIGH_SCHOOL,"Wilson High School",0));
		teams.add(new Team("928","Galbraith", "Jason", "Team 1", SchoolType.HIGH_SCHOOL,"Sunset High School",0));
		teams.add(new Team("929","Boley", "Jan", "IX (9th) Legion", SchoolType.HIGH_SCHOOL,"Crescent Valley High School",0));
		teams.add(new Team("930","Bartlo", "Chris", "leetfleet", SchoolType.HIGH_SCHOOL,"Wilson High School",0));
		teams.add(new Team("931","Bartlo", "Chris", "Team Henry", SchoolType.HIGH_SCHOOL,"Wilson High School",0));
		teams.add(new Team("932","Bartlo", "Chris", "Based Pattern", SchoolType.HIGH_SCHOOL,"Wilson High School",0));
		teams.add(new Team("933","Steinfeld", "Peter", "Worst dev team ever", SchoolType.HIGH_SCHOOL,"Hillsboro High School",0));
		teams.add(new Team("934","Galbraith", "Jason", "E-lemon-ators", SchoolType.HIGH_SCHOOL,"Sunset High School",0));
		teams.add(new Team("935","Bartlo", "Chris", "Wilson JV2", SchoolType.HIGH_SCHOOL,"Wilson High School",0));

	}
	
	public String calculateBestInShow() {
		return "Besty";
	}
	
	public String calculateProChoice() {
		return "Proy";
	}

	public String calculateStudentChoice() {
		return "Studenty";
	}

	public String calculateCategoryAward(String category) {
		return category;
	}

	public String calculateRookieAward() {
		return "rookie";
	}
	
	public Collection<Category> getCategories() {
		return categories;
	}
	
	public Collection<Team> getTeams() {
		return teams;
	}

	public Collection<Achievement> getAchievements(Category category) {
		if (category != null)
			return category.getAchievements();
		else
			throw new RuntimeException("Category is null");
	}

	
}
