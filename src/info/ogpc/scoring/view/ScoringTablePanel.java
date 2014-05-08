package info.ogpc.scoring.view;

import info.ogpc.scoring.model.AchievementInfoTableModel;
import info.ogpc.scoring.model.AchievementScoreTableModel;
import info.ogpc.scoring.model.Category;
import info.ogpc.scoring.model.SchoolType;
import info.ogpc.scoring.model.TeamInformationTableModel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class ScoringTablePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable teamTable;
	AchievementScoreTableModel data;

	public ScoringTablePanel (String schoolType) {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridheight = 3;
		c.gridwidth = 3;
		c.weightx = 0.5;
		c.weighty = 0.5;
		
		data = new AchievementScoreTableModel(schoolType);

		data.loadData();
		teamTable = new JTable(data);
		teamTable.setAutoCreateRowSorter(true);
		
		JScrollPane scrollPane = new JScrollPane(teamTable);
		teamTable.setFillsViewportHeight(true);
		
		//scrollPane.setPreferredSize(new Dimension(1024,768));
		add(scrollPane,c);

		
	}

	public void updateData() {
		data.loadData();		
	}

}
