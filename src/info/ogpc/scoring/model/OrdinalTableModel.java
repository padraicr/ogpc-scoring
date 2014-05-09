package info.ogpc.scoring.model;

import info.ogpc.scoring.main.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class OrdinalTableModel extends AbstractTableModel implements TableModel {

	private static final long serialVersionUID = 1L;
	OGPCDataModel dataModel = Main.getDataModel();
	Category activeCategory;
	Vector<String> columnNames = new Vector<String>();
	private ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();

	public OrdinalTableModel() {
		data= new ArrayList<ArrayList<Object>>();
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
		return columnNames.size();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames.get(columnIndex);
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
		return data.get(rowIndex).get(columnIndex);

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
	
	public void loadData(String activeSchoolType) {
		data = new ArrayList<ArrayList<Object>>();
		ArrayList<ArrayList<Object>> teamScores = new ArrayList<ArrayList<Object>>();;
		
		for (Team team : dataModel.getTeams()) {
			ArrayList<Object> rowData = new ArrayList<Object>();
			if (activeSchoolType.equalsIgnoreCase(team.getSchoolType()
					.toString())) {
				rowData.add(team.getName());
				rowData.add(team.calculateBestInShow());
				for (Category category : dataModel.getCategories()) {
					ScoringSheet sheet = team.getScoringSheet(category);
					rowData.add(sheet.getTotalScore());
				}
				teamScores.add(rowData);
			}
		
		}
		System.out.println("size="+teamScores.size());
		
		//rowData.add(teamList);
		ArrayList orderedScores =  new ArrayList();

		int i = 1;
		//int column = 1;
		for (int column = 1; column < teamScores.get(0).size();column++) {
			ArrayList<Integer> scores =  new ArrayList<Integer>();

			for (int row = 0; row < teamScores.size(); row++) {
				scores.add(new Integer(teamScores.get(row).get(column).toString()));	
			}
			Collections.sort(scores);
			orderedScores.add(scores);
		}
			
		
		for (int row = 0; row < teamScores.size(); row++){
			ArrayList<Object>  rowData = new ArrayList<Object>();
			rowData.add(teamScores.get(row).get(0));
			System.out.println("team="+teamScores.get(row)+teamScores.get(0).size()+" "+orderedScores.size());
			for (int column = 1; column < teamScores.get(0).size();column++) {
				int ordinal = 1;
				ArrayList orderedScore = (ArrayList) orderedScores.get(column-1);

				for (int scoreIndex = orderedScore.size()-1; scoreIndex >= 0; scoreIndex--) {

					System.out.println("checking-"+teamScores.get(row).get(column) + " vs "+ orderedScore.get(scoreIndex)+" "+teamScores.get(row).get(column).equals(orderedScore.get(scoreIndex)));
					if (teamScores.get(row).get(column).equals(orderedScore.get(scoreIndex))){
	
						break;
					}
					else
						ordinal++;
						
				}
				System.out.println("checking score for="+teamScores.get(row).get(column)+" ord:"+ordinal);
				rowData.add(ordinal);

			}
			data.add(rowData);
		}
		
		System.out.println("data="+data.size()+", "+data.get(0).size());

		
		fireTableDataChanged();
	}

}
