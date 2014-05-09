package info.ogpc.scoring.main.tabs;

import info.ogpc.scoring.model.OrdinalTableModel;
import info.ogpc.scoring.model.SchoolType;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class OrdinalPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable ordinalTable;

	public OrdinalPanel() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridheight = 3;
		c.gridwidth = 3;
		c.weightx = 0.5;
		c.weighty = 0.5;
		OrdinalTableModel data = new OrdinalTableModel();
		data.loadData(SchoolType.HIGH_SCHOOL.toString());
		ordinalTable = new JTable(data);

	
		
		JScrollPane scrollPane = new JScrollPane(ordinalTable);
		ordinalTable.setFillsViewportHeight(true);
		ordinalTable.setAutoCreateRowSorter(true);

		add(scrollPane, c);

	}

}
