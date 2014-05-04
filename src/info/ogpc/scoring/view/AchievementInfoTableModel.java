package info.ogpc.scoring.view;

import info.ogpc.scoring.model.Achievement;
import info.ogpc.scoring.model.OGPCDataModel;
import info.ogpc.scoring.model.Category;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class AchievementInfoTableModel implements TableModel {
	OGPCDataModel dataModel = Main.getDataModel();
	String[] columnNames = { "Name", "Point Value", "Description" };
	Category activeCategory;
	
	public AchievementInfoTableModel(Category category) {
		activeCategory = category;
	}

	@Override
	public int getRowCount() {
		return dataModel.getAchievements(activeCategory).size();
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
		Achievement achievement = null;
		for (String achievementId : dataModel.getAchievements(activeCategory).keySet()) {
			if (i == rowIndex) {
				achievement = dataModel.getAchievements(activeCategory).get(achievementId);
				break;
			} else
				i++;
		}
		
		if (achievement == null)
			throw new RuntimeException("Unable to find data at row:"+rowIndex+" column:"+columnIndex);

		switch (columnIndex) {
		case 0:
			return achievement.getName();
		case 1:
			return achievement.getPointValue().toString();
		case 2:
			return achievement.getDescription();
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
