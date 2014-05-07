package info.ogpc.scoring.view;

import java.awt.Dimension;
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
		teamTable = new JTable(new TeamInformationTableModel());
		
		JScrollPane scrollPane = new JScrollPane(teamTable);
		teamTable.setFillsViewportHeight(true);
		
		scrollPane.setPreferredSize(new Dimension(1024,768));
		add(scrollPane);

		
	}

}
