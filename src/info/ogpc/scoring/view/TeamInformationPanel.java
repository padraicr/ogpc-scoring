package info.ogpc.scoring.view;

import info.ogpc.scoring.model.OGPCDataModel;
import info.ogpc.scoring.model.SchoolType;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TeamInformationPanel extends JPanel {
	JTable teamTable;

	public TeamInformationPanel () {
		teamTable = new JTable(new TeamInformationTableModel());
		
		JScrollPane scrollPane = new JScrollPane(teamTable);
		teamTable.setFillsViewportHeight(true);
		
		scrollPane.setPreferredSize(new Dimension(1024,768));
		add(scrollPane);

		
	}

}
