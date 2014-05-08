package info.ogpc.scoring.view;

import info.ogpc.scoring.model.TeamInformationTableModel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TeamInformationPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable teamTable;

	public TeamInformationPanel () {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridheight = 3;
		c.gridwidth = 3;
		c.weightx = 0.5;
		c.weighty = 0.5;
		teamTable = new JTable(new TeamInformationTableModel());
		
		JScrollPane scrollPane = new JScrollPane(teamTable);
		teamTable.setFillsViewportHeight(true);
		
		//scrollPane.setPreferredSize(new Dimension(1024,768));
		add(scrollPane,c);

		
	}

}
