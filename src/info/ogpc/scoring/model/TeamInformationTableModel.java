package info.ogpc.scoring.model;

import info.ogpc.scoring.view.Main;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TeamInformationTableModel implements TableModel {
	OGPCDataModel dataModel = Main.getDataModel();
	String[] columnNames = { "Team ID", "Team Name", "Type", "Coach", "School",
			"Number of Students" };

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
		for (Team tempTeam : dataModel.getTeams()) {
			if (i == rowIndex) {
				team = tempTeam;
				break;
			} else
				i++;
		}
		
		if (team == null)
			throw new RuntimeException("Unable to find data at row:"+rowIndex+" column:"+columnIndex);

		switch (columnIndex) {
		case 0:
			return team.getTeamId();
		case 1:
			return team.getName();
		case 2:
			if (team.getSchoolType() == SchoolType.HIGH_SCHOOL)
				return "High School";
			else  if (team.getSchoolType() == SchoolType.MIDDLE_SCHOOL)
				return "Middle School";
			else 
				return team.getSchoolType();
		case 3:
			return team.getCoachName();
		case 4:
			return team.getSchoolName();
		case 5:
			return team.getNumberOfStudents();
		default:	
			throw new RuntimeException("Invalide column:"+columnIndex);
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
