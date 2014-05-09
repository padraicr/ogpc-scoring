package info.ogpc.scoring.view;

import info.ogpc.scoring.model.AchievementScoreTableModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class ScoringTablePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable teamTable;
	AchievementScoreTableModel data;

	public ScoringTablePanel(String schoolType) {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridheight = 3;
		c.gridwidth = 3;
		c.weightx = 0.5;
		c.weighty = 0.5;

		data = new AchievementScoreTableModel();

		data.loadData(schoolType);
		teamTable = new JTable(data) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Component prepareRenderer(TableCellRenderer renderer,
					int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (c instanceof JComponent) {
					((JComponent) c).setBorder(BorderFactory
							.createLineBorder(Color.LIGHT_GRAY));
				}

				return c;
			}
		};

		teamTable.setIntercellSpacing(new Dimension(1, 1));

		teamTable.setAutoCreateRowSorter(true);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		((DefaultTableCellRenderer) teamTable.getTableHeader()
				.getDefaultRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
	
		for (int i = 0; i < teamTable.getColumnCount(); i++)
			teamTable.getColumnModel().getColumn(i)
					.setCellRenderer(centerRenderer);

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
			teamTable.getColumnModel().getColumn(1)
					.setCellRenderer(leftRenderer);

		
		JScrollPane scrollPane = new JScrollPane(teamTable);
		teamTable.setFillsViewportHeight(true);

		// scrollPane.setPreferredSize(new Dimension(1024,768));
		add(scrollPane, c);

	}

	public void updateData(String schoolType) {
		data.loadData(schoolType);
	}

}
