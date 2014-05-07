package info.ogpc.scoring.model;

import java.util.LinkedList;
import java.util.TreeMap;
import java.util.Collections;

import info.ogpc.scoring.view.Main;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class AchievementRankingTableModel implements TableModel {
	OGPCDataModel dataModel = Main.getDataModel();
	String[] columnNames = { "Points", "Team", "School" };
	Category activeCategory;
	TreeMap<Integer, LinkedList<Team>> teamRankings = new TreeMap<Integer, LinkedList<Team>> (Collections.reverseOrder());
	
	public AchievementRankingTableModel(Category category) {
		activeCategory = category;
		for(Team team : dataModel.getTeams()) {
			Integer score = team.getScoringSheet(activeCategory).getTotalScore();
			LinkedList<Team> list = teamRankings.get(score);
			if (list == null) { 
				list = new LinkedList<Team>();
			}
			list.add(team);
			teamRankings.put(score, list);
		}
	}

	@Override
	public int getRowCount() {
		return dataModel.getTeams().size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int i = 0;
		Team team = null;
		Integer score = null;
		boolean done = false;

		for (Integer tempScore : teamRankings.keySet()) {
			LinkedList<Team> teams = teamRankings.get(tempScore);
			for (Team tempTeam : teams) {
				if (rowIndex == i) {
					done = true;
					score = tempScore;
					team = tempTeam;
					break;
				}
				i++;
			}
			if (done)
				break;
		}
		

		switch (columnIndex) {
		case 0:
			return score;
		case 1:
			return team.getName();
		case 2:
			return team.getSchoolName();
		default:	
			throw new RuntimeException("Invalid column:"+columnIndex);
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// N/A
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// N/A No model changes
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// N/A No model changes

	}

}
