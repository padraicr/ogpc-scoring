package info.ogpc.scoring.model;

import java.util.ArrayList;
import java.util.Vector;

import info.ogpc.scoring.view.Main;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AchievementScoreTableModel extends AbstractTableModel implements TableModel {
	OGPCDataModel dataModel = Main.getDataModel();
	Category activeCategory;
	String activeSchoolType;
	Vector<String> columnNames = new Vector<String>();
	private ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();

	public AchievementScoreTableModel(String schoolType) {
		activeSchoolType = schoolType;
		data= new ArrayList<ArrayList<Object>>();
		columnNames.add("Team");
		for (Category category : dataModel.getCategories())
			columnNames.add(category.getName());
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return data.get(0).size();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames.get(columnIndex);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 0)
			return String.class;
		else 
			return Integer.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data.get(rowIndex).get(columnIndex);

		/*
		 * int i = 0; Achievement achievement = null; for (String achievementId
		 * : dataModel.getAchievements(activeCategory).keySet()) { if (i ==
		 * rowIndex) { achievement =
		 * dataModel.getAchievements(activeCategory).get(achievementId); break;
		 * } else i++; }
		 * 
		 * if (achievement == null) throw new
		 * RuntimeException("Unable to find data at row:"
		 * +rowIndex+" column:"+columnIndex);
		 * 
		 * switch (columnIndex) { case 0: return achievement.getName(); case 1:
		 * return achievement.getPointValue().toString(); case 2: return
		 * achievement.getDescription(); default: throw new
		 * RuntimeException("Invalide column:"+columnIndex); } return null;
		 */
	}


	public void loadData() {
		data = new ArrayList<ArrayList<Object>>();
		
		for (Team team : dataModel.getTeams()) {
			ArrayList<Object> rowData = new ArrayList<Object>();
			if (activeSchoolType.equalsIgnoreCase(team.getSchoolType()
					.toString())) {
				rowData.add(team.getName());
				for (Category category : dataModel.getCategories()) {
					ScoringSheet sheet = team.getScoringSheet(category);
					rowData.add(sheet.getTotalScore());
				}
				data.add(rowData);
			}
		}
		System.out.println("firing event");

		fireTableDataChanged();
	}
}
