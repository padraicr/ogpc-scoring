package info.ogpc.scoring.model;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OGPCDataModel {

	LinkedList<Category> categories = new LinkedList<Category>();
	LinkedList<Team> teams = new LinkedList<Team>();

	public OGPCDataModel() {

		// Hardcoding the data model, if time will make it dynamic, probably
		// best to import it as a
		// CSV as almost everything else is in a spreadsheet.
		// Load the categories and achievements first and the teams second. To
		// save time, I'm having the teams
		// initialize scoring sheets up front which require that the categories
		// be loaded first.
		Category programming = new Category("Programming");
		programming.addAchievement("1","Way of the Wanderer",15,"Show a diagram of at least one element of the game logic (i.e. decision tree, AI process, player progression)");
		programming.addAchievement("2", "Objectify", 5,
				"Use object-oriented programming.");
		programming
				.addAchievement("3", "Functionally Obsolete", 10,
						"Demonstrate a function (or equivalent) that is used in multiple places.");
		programming.addAchievement("4", "Code It Forward", 20,
				"Comment or otherwise document the code.");
		programming.addAchievement("5", "From the Depths", 30,
				"Build your own engine.");
		programming
				.addAchievement("6", "From the Depths", 10,
						"Use an existing engine and demonstrate use of its built-in functions.");
		programming
				.addAchievement("7", "Sharper Than Flat", 20,
						"Game uses 3D coordinate space. 3D rendering isn't necessarily required.");
		programming
				.addAchievement(
						"8",
						"Sharper Than Flat",
						15,
						"Game does not use 3D, but uses a pseudo-3D method such as parallax or isometric.");
		programming
				.addAchievement(
						"9",
						"Sharper Than Flat",
						10,
						"Game is 2D and uses z-indexing to properly order background and foreground objects.");
		programming.addAchievement("10", "Ex Machina", 10,
				"Use a state machine.");
		programming
				.addAchievement("11", "Big Data", 10,
						"Use a data structure and explain its purpose (i.e. tree, map/dict).");
		programming
				.addAchievement("12", "Electric Flyswatter", 20,
						"Design your own testing/debugging tool and explain how it was used.");
		programming
				.addAchievement("13", "Electric Flyswatter", 10,
						"Use an existing testing/debugging tool and explain how it was used.");
		programming
				.addAchievement(
						"14",
						"Optimus",
						10,
						"Demonstrate performance optimization (i.e. multithreading, parallel programming, render culling techniques)");
		programming.addAchievement("15", "Couch Play", 25,
				"Game uses networking, for multiplayer or otherwise.");
		programming
				.addAchievement("16", "Couch Play", 15,
						"Game does not have networking but supports local multiplayer.");
		programming.addAchievement("17", "Take Five", 5,
				"Game can be paused - or pausing is unnecessary.");
		programming.addAchievement("18", "Save Point", 10,
				"Game has a save function.");
		programming.addAchievement("19", "Soundproof", 5,
				"Game has volume controls.");
		programming
				.addAchievement("20", "Level of Detail", 5,
						"Game has quality settings or performs well even on low-end devices.");
		programming.addAchievement("21", "Scroll-Fire", 5,
				"Controls are configurable.");
		categories.add(programming);

		Category gameMechanics = new Category("Game Mechanics");
		gameMechanics.addAchievement("1", "Reflex Scope", 15,
				"Explain how the scope of the game was limited or reduced.");
		gameMechanics
				.addAchievement("2", "Future Sight", 20,
						"Explain how the game would be expanded with more time and resources.");
		gameMechanics
				.addAchievement(
						"3",
						"Chance Encounter",
						15,
						"Demonstrate that game has random elements and describe how odds were determined.");
		gameMechanics
				.addAchievement(
						"4",
						"Chance Encounter",
						15,
						"Demonstrate that game is deterministic and describe why that is important to the game.");
		gameMechanics
				.addAchievement("5", "Escalator", 20,
						"The game starts simple and introduces new features gradually.");
		gameMechanics
				.addAchievement("6", "Tell and Show", 15,
						"The game communicates new mechanics and challenges to the player effectively.");
		gameMechanics.addAchievement("7", "Outside the Box", 10,
				"Use at least one original game mechanic.");
		gameMechanics.addAchievement("8", "Invert the Box", 15,
				"Use an existing game mechanic in an innovative way.");
		gameMechanics.addAchievement("9", "Apply Directly", 5,
				"Player must use creative solutions to overcome challenges.");
		gameMechanics.addAchievement("10", "Your Own Adventure", 10,
				"Player can make choices that affect the game.");
		gameMechanics
				.addAchievement("11", "Focus Intensifies", 15,
						"Player's attention is focused on only a few things at a time.");
		gameMechanics
				.addAchievement("12", "Runner Vision", 15,
						"At any given point, it is clear what the player's current objective is.");
		gameMechanics
				.addAchievement("13", "S Rank", 10,
						"The game gives feedback to the player based on their performance and actions.");
		gameMechanics.addAchievement("14", "Motivational ", 5,
				"Player is given motivation to complete challenging tasks.");
		gameMechanics.addAchievement("15", "Boulder Dash", 20,
				"Game has responsive or adjustable difficulty.");
		gameMechanics.addAchievement("16", "Play It, Sam", 10,
				"Game has a replay factor to keep players coming back.");
		gameMechanics.addAchievement("17", "Trinket", 10,
				"Game has optional additional challenges.");
		categories.add(gameMechanics);

		Category artAndAssets = new Category("Art and Assets");
		artAndAssets.addAchievement("1", "Scribblenaught", 20,
				"All of the game's graphics were made by the team.");
		artAndAssets.addAchievement("2", "Scribblenaught", 10,
				"Only some of the game's graphics were made by the team.");
		artAndAssets.addAchievement("3", "Inception", 5,
				"Show off your concept art.");
		artAndAssets
				.addAchievement(
						"4",
						"Font of Dreams",
						5,
						"Use fonts tastefully (i.e. non-default fonts that match the style of the game).");
		artAndAssets.addAchievement("5", "Black Border", 20,
				"The graphical style is consistent.");
		artAndAssets.addAchievement("6", "Still Life", 10,
				"Use 3D models in the game.");
		artAndAssets.addAchievement("7", "Still Life", 10,
				"3D models are used to generate 2D sprites.");
		artAndAssets.addAchievement("8", "Sting Chameleon", 5,
				"Use dynamic lighting, shading, or coloring.");
		artAndAssets.addAchievement("9", "Steamboat", 15,
				"Most graphics are animated.");
		artAndAssets.addAchievement("10", "Steamboat", 10,
				"Some graphics are animated.");
		artAndAssets.addAchievement("11", "All that Glitters", 5,
				"Include particle effects.");
		artAndAssets.addAchievement("12", "Made to Order", 10,
				"Include a menu.");
		artAndAssets
				.addAchievement(
						"13",
						"Heads Up",
						10,
						"Inform the player of the game state through a heads up display or other UI elements.");
		artAndAssets.addAchievement("14", "Audiosurf", 15,
				"Soundtrack was made by the team.");
		artAndAssets.addAchievement("15", "Tracklist", 10,
				"Soundtrack consists of more than one song.");
		artAndAssets.addAchievement("16", "Tracklist", 5,
				"Soundtrack consists of one song.");
		artAndAssets.addAchievement("17", "Onomatopoeia", 10,
				"Game has sound effects.");
		artAndAssets.addAchievement("18", "Foley and BFXR", 10,
				"Game features custom sound effects made by the team.");
		artAndAssets
				.addAchievement(
						"19",
						"Panoramic",
						5,
						"Audio changes dynamically based on gameplay (i.e. distant sounds are quieter, combat changes music).");
		artAndAssets.addAchievement("20", "Talkie", 10,
				"Audio is well-synced with visuals.");
		categories.add(artAndAssets);

		Category themeAndStyle = new Category("Theme and Style");
		themeAndStyle.addAchievement("1", "Theme Hospital", 20,
				"Game is built completely around theme.");
		themeAndStyle.addAchievement("2", "Theme Hospital", 10,
				"Game is somewhat connected to theme.");
		themeAndStyle.addAchievement("3", "Citrus Twist", 5,
				"Use the theme creatively by adding other elements to it.");
		themeAndStyle.addAchievement("4", "Did the Research", 15,
				"Research the theme and explain what you learned.");
		themeAndStyle.addAchievement("5", "Avatar", 5,
				"Theme is reflected in game mechanics.");
		themeAndStyle.addAchievement("6", "Storytime", 5,
				"Game tells (or shows) a story of some sort.");
		themeAndStyle.addAchievement("7", "Detail-Oriented", 10,
				"Story is shown rather than just told.");
		themeAndStyle.addAchievement("8", "Far Far Away", 10,
				"Game takes place in a clear and vivid setting.");
		themeAndStyle.addAchievement("9", "Exposition", 10,
				"Game environments contain information about the setting.");
		themeAndStyle
				.addAchievement("10", "Easel", 5,
						"Prepare a storyboard of at least one scene or screen in the game.");
		themeAndStyle.addAchievement("11", "E for Everyone", 15,
				"Game is accessible to a wide audience.");
		themeAndStyle.addAchievement("12", "Sand Zone", 20,
				"Game features varied environments or areas.");
		themeAndStyle.addAchievement("13", "Doodle Neon Pixel", 10,
				"Game has a unique and specific artistic style.");
		themeAndStyle
				.addAchievement(
						"14",
						"Character Sheet",
						10,
						"Player character is given a specific personality and background (i.e. many RPG's).");
		themeAndStyle
				.addAchievement(
						"15",
						"Character Sheet",
						10,
						"Player is allowed to project their own personality onto the player character (i.e. silent or amnesiac).");
		themeAndStyle.addAchievement("16", "Genre-Luc", 10,
				"Game exists outside classic genre boundaries");
		themeAndStyle.addAchievement("17", "Genre-Luc", 5,
				"Game fits into a specific genre");
		themeAndStyle.addAchievement("18", "Aardwulf", 5,
				"Include an easter egg or secret.");
		themeAndStyle.addAchievement("19", "NPC", 5,
				"Game includes at least one non-player character.");
		themeAndStyle.addAchievement("20", "Plot Thickener", 15,
				"Game features character development.");
		categories.add(themeAndStyle);

		Category Teamwork = new Category("Teamwork");
		Teamwork.addAchievement("1", "Really Impressive Title", 5,
				"Team has a name.");
		Teamwork.addAchievement("2", "Character Class", 10,
				"Each team member has a formal role.");
		Teamwork.addAchievement("3", "Extra Credits", 10,
				"Each team member describes what they contributed to the project.");
		Teamwork.addAchievement("4", "Visionary", 5, "Team has an artist.");
		Teamwork.addAchievement("5", "World Builder", 5, "Team has a writer.");
		Teamwork.addAchievement("6", "Audiophile", 5,
				"Team has an audio designer.");
		Teamwork.addAchievement("7", "Top-down", 15, "Write a design document.");
		Teamwork.addAchievement("8", "Adaptive Design", 5,
				"Show updates to the design document that reflect changes in your design.");
		Teamwork.addAchievement("9", "Clockwinding", 15,
				"Document meeting minutes or other notes regarding team decisions.");
		Teamwork.addAchievement("10", "Bronze Calendar", 10,
				"Create a development schedule with concrete milestones.");
		Teamwork.addAchievement("11", "Collaboration", 10,
				"	Describe how two or more team members worked together on a single task.");
		Teamwork.addAchievement("12", "Dissonance", 10,
				"Describe a conflict the team resolved.");
		Teamwork.addAchievement("13", "Strength in Numbers", 10,
				"Describe how you helped or were helped by another OGPC team.");
		Teamwork.addAchievement("14", "And Accounted For", 10,
				"Each team member is present (or has a pressing obligation).");
		Teamwork.addAchievement("15", "Mystic Tutor", 5,
				"Describe the role of technical mentors or other outside resources used.");
		Teamwork.addAchievement("16", "Controlling Chaos", 15,
				"Use source control - or back up multiple versions of the source.");
		categories.add(Teamwork);

		Category professionalism = new Category("Professionalism");
		professionalism.addAchievement("1", "Emcee", 10,
				"Give a short presentation on your game.");
		professionalism.addAchievement("2", "Chorus of Voices", 10,
				"Every team member presents during the demo.");
		professionalism.addAchievement("3", "Intel Briefcase", 10,
				"Presentation is clearly well-prepared.");
		professionalism.addAchievement("4", "A Thousand Words", 10,
				"Presentation includes screenshots of the game.");
		professionalism.addAchievement("5", "Dress for Success", 5,
				"Team is dressed professionally.");
		professionalism
				.addAchievement(
						"6",
						"Exhibit A",
						15,
						"Presentation includes a visual aid such as a powerpoint, posterboard, or website.");
		professionalism
				.addAchievement("7", "13th Floor", 10,
						"Present the game's elevator pitch (may be during the presentation or not).");
		professionalism.addAchievement("8", "Forge of Paper", 15,
				"Show off a paper prototype of your game (picture is okay)");
		professionalism.addAchievement("9", "Taking Aim", 5,
				"Describe the game's target audience.");
		professionalism.addAchievement("10", "Front Man", 10,
				"Explain how the game appeals to its target audience.");
		professionalism.addAchievement("11", "Launch Octopus", 20,
				"Release your game on multiple platforms.");
		professionalism.addAchievement("12", "Blogatog", 10,
				"Maintain a development blog or social media page.");
		professionalism
				.addAchievement("13", "Giving Back", 10,
						"Publish a tutorial on a problem you solved during development.");
		professionalism
				.addAchievement("14", "Chirp", 5,
						"Advertise your game on a game development website or community.");
		professionalism.addAchievement("15", "In the Papers", 10,
				"Receive local news coverage about your team.");
		professionalism
				.addAchievement("16", "In the Papers", 10,
						"Do not receive coverage, but create a press release about your team.");
		professionalism
				.addAchievement("17", "License to Win", 5,
						"Release your source code under an open source license (i.e. GPL, MIT, CC0).");
		professionalism.addAchievement("18", "Impossible", 10,
				"Game finished and released before the Main Event.");
		categories.add(professionalism);
		Collections.sort(categories);

		File dataFile = new File("/Users/padraic/tempData.txt");
		if (!dataFile.exists()) {

			teams.add(new Team("701", "Freman", "Patrick",
					"Franklin Laser Cats", SchoolType.MIDDLE_SCHOOL,
					"Lucidyne Technologies Inc.", 0));
			teams.add(new Team("702", "Gasper", "John", "Game Droid",
					SchoolType.MIDDLE_SCHOOL, "<Unknown>", 0));
			teams.add(new Team("703", "Gordon", "Lynda", "Level Up",
					SchoolType.MIDDLE_SCHOOL, "Cedar Park Middle School", 0));
			teams.add(new Team("704", "Jamalapuram", "Sairama", "Three Amigos",
					SchoolType.MIDDLE_SCHOOL, "<Unknown>", 0));
			teams.add(new Team("705", "Jhala", "Bhadraraj", "SmartGamers",
					SchoolType.MIDDLE_SCHOOL, "Nike", 0));
			teams.add(new Team("706", "Menon", "Narayan", "Bad Robots",
					SchoolType.MIDDLE_SCHOOL, "<Unknown>", 0));

			teams.add(new Team("901", "Horner", "Linda",
					"Lebanaon Tech Warriors", SchoolType.HIGH_SCHOOL,
					"Lebanon High School", 0));
			teams.add(new Team("902", "Datta", "Chitra", "Glitchbusters",
					SchoolType.HIGH_SCHOOL, "<Unknown>", 0));
			teams.add(new Team("903", "Hubbard", "Jill", "Crimsonites",
					SchoolType.HIGH_SCHOOL, "Tigard Tualatin School District",
					0));
			teams.add(new Team("904", "Meyers", "Bill", "Powerful Pixels",
					SchoolType.HIGH_SCHOOL, "Ashland High School", 0));
			teams.add(new Team("905", "Owings", "Ron", "BullDawgs Bashers",
					SchoolType.HIGH_SCHOOL, "Sutherlin High school", 0));
			teams.add(new Team("906", "Macdonald", "Randy", "<Unknown>",
					SchoolType.HIGH_SCHOOL, "Franklin High School", 0));
			teams.add(new Team("907", "Smith", "Terrel", "SHS OGPC Team",
					SchoolType.HIGH_SCHOOL, "Sherwood High School", 0));
			teams.add(new Team("908", "Cuthbert", "Laura",
					"Error 404: The Team You Are Looking for Does Not Exist",
					SchoolType.HIGH_SCHOOL,
					"Clover STEMs Science Club: Deschutes Co 4-H", 0));
			teams.add(new Team("909", "Macdonald", "Randy", "<Unknown>",
					SchoolType.HIGH_SCHOOL, "Franklin High School", 0));
			teams.add(new Team("910", "Seawright", "Andrew", "Sandwich Mafia",
					SchoolType.HIGH_SCHOOL, "Riverdale / LO ", 0));
			teams.add(new Team("911", "Boley", "Jan", "Astral Horde",
					SchoolType.HIGH_SCHOOL, "Crescent Valley High School", 0));
			teams.add(new Team("912", "Fulton", "Steve",
					"Tiny Walrus Interactive", SchoolType.HIGH_SCHOOL,
					"Tigard High School", 0));
			teams.add(new Team("913", "Bartlo", "Chris", "<Unknown>",
					SchoolType.HIGH_SCHOOL, "Wilson High School", 0));
			teams.add(new Team("914", "Fassio", "Erin",
					"Melted Gravel Software", SchoolType.HIGH_SCHOOL,
					"Amity High School", 0));
			teams.add(new Team("915", "Bartlo", "Chris", "Based Trojans",
					SchoolType.HIGH_SCHOOL, "Wilson High School", 0));
			teams.add(new Team("916", "Boley", "Jan", "Penteract",
					SchoolType.HIGH_SCHOOL, "Crescent Valley High School", 0));
			teams.add(new Team("917", "Fulton", "Steve", "Bumbler Interactive",
					SchoolType.HIGH_SCHOOL, "Tigard High School", 0));
			teams.add(new Team("918", "Galbraith", "Jason",
					"Incarnate Infinity", SchoolType.HIGH_SCHOOL,
					"Sunset High School", 0));
			teams.add(new Team("919", "Galbraith", "Jason", "Project Gyme",
					SchoolType.HIGH_SCHOOL, "Sunset High School", 0));
			teams.add(new Team("920", "Fulton", "Steve",
					"Fire-Breathing Kittens", SchoolType.HIGH_SCHOOL,
					"Tigard High School", 0));
			teams.add(new Team("921", "Galbraith", "Jason", "IDEK Gaming",
					SchoolType.HIGH_SCHOOL, "Sunset High School", 0));
			teams.add(new Team("922", "Bartlo", "Chris", "Ballad Games",
					SchoolType.HIGH_SCHOOL, "Wilson High School", 0));
			teams.add(new Team("923", "Boley", "Jan", "GLOVE Studio",
					SchoolType.HIGH_SCHOOL, "Crescent Valley High School", 0));
			teams.add(new Team("924", "Fulton", "Steve", "TANSTAAFL!",
					SchoolType.HIGH_SCHOOL, "Tigard High School", 0));
			teams.add(new Team("925", "Galbraith", "Jason",
					"Fire-breathing Rubber Duckies", SchoolType.HIGH_SCHOOL,
					"Sunset High School", 0));
			teams.add(new Team("926", "Galbraith", "Jason",
					"Direct Entertainment Revolution Project",
					SchoolType.HIGH_SCHOOL, "Sunset High School", 0));
			teams.add(new Team("927", "Bartlo", "Chris", "Magma Drakes",
					SchoolType.HIGH_SCHOOL, "Wilson High School", 0));
			teams.add(new Team("928", "Galbraith", "Jason", "Team 1",
					SchoolType.HIGH_SCHOOL, "Sunset High School", 0));
			teams.add(new Team("929", "Boley", "Jan", "IX (9th) Legion",
					SchoolType.HIGH_SCHOOL, "Crescent Valley High School", 0));
			teams.add(new Team("930", "Bartlo", "Chris", "leetfleet",
					SchoolType.HIGH_SCHOOL, "Wilson High School", 0));
			teams.add(new Team("931", "Bartlo", "Chris", "Team Henry",
					SchoolType.HIGH_SCHOOL, "Wilson High School", 0));
			teams.add(new Team("932", "Bartlo", "Chris", "Based Pattern",
					SchoolType.HIGH_SCHOOL, "Wilson High School", 0));
			teams.add(new Team("933", "Steinfeld", "Peter",
					"Worst dev team ever", SchoolType.HIGH_SCHOOL,
					"Hillsboro High School", 0));
			teams.add(new Team("934", "Galbraith", "Jason", "E-lemon-ators",
					SchoolType.HIGH_SCHOOL, "Sunset High School", 0));

			teams.add(new Team("935", "Bartlo", "Chris", "Wilson JV2",
					SchoolType.HIGH_SCHOOL, "Wilson High School", 0));

	
		}

	}

	public String[] calculateBestInShow() {
		String[] rankings = {"besty"};
		return rankings;
	}

	public String[] calculateProChoice() {
		String[] rankings = {"pro-y"};
		return rankings;
	}

	public String[] calculateStudentChoice() {
		String[] rankings = {"study"};
		return rankings;
	}
	
	public String[] calculateRookieAward() {
		String[] rankings = {"rookie"};
		return rankings;
	}


	public String[] calculateCategoryAward(Category category) {
		// Need to add category heirarchy here
		String[] rankings = new String[3];
		String firstPlace = "", secondPlace = "", thirdPlace = "";

		int firstPlaceScore = -1, secondPlaceScore = -1, thirdPlaceScore = -1;
		for (Team team : getTeams()) {
			ScoringSheet sheet = team.getScoringSheet(category);
			Integer value = sheet.getTotalScore();
			if (value > firstPlaceScore) {
				thirdPlace = secondPlace;
				secondPlace = firstPlace;
				firstPlace = team.getName();
				thirdPlaceScore = secondPlaceScore;
				secondPlaceScore = firstPlaceScore;
				firstPlaceScore = value;
			} else if (value == firstPlaceScore) {
				firstPlace = firstPlace + ":" + team.getName();
			} else if (value > secondPlaceScore) {
				thirdPlace = secondPlace;
				secondPlace = team.getName();
				thirdPlaceScore = secondPlaceScore;
				secondPlaceScore = value;
			} else if (value == secondPlaceScore) {
				secondPlace = secondPlace + ":" + team.getName();
			} else if (value > thirdPlaceScore) {
				thirdPlace = team.getName();
				thirdPlaceScore = value;
			} else if (value == thirdPlaceScore) {
				thirdPlace = thirdPlace + ":" + team.getName();
			}
		}
		rankings[0]=firstPlace;
		rankings[1]=secondPlace;
		rankings[2]=thirdPlace;
		
		return rankings;
	}


	public Collection<Category> getCategories() {
		
		return categories;
	}

	public Category getCategory(String id) {
		for (Category category : categories) {
			if (category.getName().equals(id))
				return category;
		}
		return null;
	}

	public Collection<Team> getTeams() {
		return teams;
	}

	public Map<String, Achievement> getAchievements(Category category) {
		if (category != null)
			return category.getAchievements();
		else
			throw new RuntimeException("Category is null");
	}

	public void writeData() {
		System.out.println("writing data");

		try {
			FileWriter write = new FileWriter("/Users/padraic/tempData.txt",
					false);
			PrintWriter printLine = new PrintWriter(write);

			for (Team team : teams) {
				printLine.println(team.printLine());
			}
			printLine.close();
		} catch (IOException e) {
			throw new RuntimeException("Unable to write file");
		}

	}

	public void readData() {
		System.out.println("reading data");

		try {
			FileReader fileReader = new FileReader("/Users/padraic/tempData.txt");
			BufferedReader textReader = new BufferedReader(fileReader);
			int numLines = 0;
			while ((textReader.readLine()) != null) {
				numLines++;
			}
			textReader.close();
			fileReader.close();

			fileReader = new FileReader("/Users/padraic/tempData.txt");
			textReader = new BufferedReader(fileReader);

			LinkedList<Team> tempTeams = new LinkedList<Team>();

			for (int i = 0; i < numLines; i++) {
				String foo = textReader.readLine();
				Team temp = new Team(foo);
				tempTeams.add(temp);
			}
			fileReader.close();
			teams = tempTeams;
			Collections.sort(teams);

		} catch (IOException e) {
			throw new RuntimeException("Unable to read file");
		}

	}

}
