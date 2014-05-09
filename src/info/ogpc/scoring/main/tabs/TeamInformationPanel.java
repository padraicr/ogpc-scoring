package info.ogpc.scoring.main.tabs;

import info.ogpc.scoring.model.TeamInformationTableModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

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
		teamTable = new JTable(new TeamInformationTableModel()) {
		    public Component prepareRenderer(
			        TableCellRenderer renderer, int row, int column)
			    {
			        Component c = super.prepareRenderer(renderer, row, column);
			        if ((row % 2) == 0)
			        	c.setBackground(new Color(221, 243, 202));
			        else
			        	c.setBackground(Color.WHITE);
			        
			        if (c instanceof JComponent) {
			        	((JComponent) c).setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
			        }
			        

			        return c;
			    }
			};
	
			DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
			rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				teamTable.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
			((DefaultTableCellRenderer)teamTable.getTableHeader().getDefaultRenderer())
		    .setHorizontalAlignment(JLabel.CENTER);
			teamTable.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		((DefaultTableCellRenderer)teamTable.getTableHeader().getDefaultRenderer())
	    .setHorizontalAlignment(JLabel.CENTER);
		teamTable.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
	((DefaultTableCellRenderer)teamTable.getTableHeader().getDefaultRenderer())
    .setHorizontalAlignment(JLabel.CENTER);
		JScrollPane scrollPane = new JScrollPane(teamTable);
		teamTable.setFillsViewportHeight(true);
		teamTable.setAutoCreateRowSorter(true);

		
		//scrollPane.setPreferredSize(new Dimension(1024,768));
		add(scrollPane,c);

		
	}

}
