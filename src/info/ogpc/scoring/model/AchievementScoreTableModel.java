package info.ogpc.scoring.model;

import info.ogpc.scoring.main.Main;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class AchievementScoreTableModel extends AbstractTableModel implements
		TableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	OGPCDataModel dataModel = Main.getDataModel();
	Category activeCategory;
	Vector<String> columnNames = new Vector<String>();
	private ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();

	public AchievementScoreTableModel() {
		data = new ArrayList<ArrayList<Object>>();
		columnNames.add("Team ID");
		columnNames.add("Team");
		columnNames.add("Best In Show");
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

	}

	public void loadData(String activeSchoolType) {
		data = new ArrayList<ArrayList<Object>>();

		for (Team team : dataModel.getTeams()) {
			ArrayList<Object> rowData = new ArrayList<Object>();
			if (activeSchoolType.equalsIgnoreCase(team.getSchoolType()
					.toString())) {
				rowData.add(team.getTeamId());
				if (team.isRookie())
					rowData.add("*" + team.getName());
				else
					rowData.add(team.getName());
				rowData.add(team.calculateBestInShow());
				for (Category category : dataModel.getCategories()) {
					ScoringSheet sheet = team.getScoringSheet(category);
					rowData.add(sheet.getTotalScore());
				}
				data.add(rowData);
			}
		}
		fireTableDataChanged();
	}
}
