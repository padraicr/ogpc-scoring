package info.ogpc.scoring.main.tabs;

import info.ogpc.scoring.model.OrdinalTableModel;
import info.ogpc.scoring.model.SchoolType;

import java.awt.Color;
import java.awt.Component;
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

public class OrdinalPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable ordinalTable;
	OrdinalTableModel data = new OrdinalTableModel();

	public OrdinalPanel() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridheight = 3;
		c.gridwidth = 3;
		c.weightx = 0.5;
		c.weighty = 0.5;
		data.loadData(SchoolType.HIGH_SCHOOL.toString());
		ordinalTable = new JTable(data) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Component prepareRenderer(TableCellRenderer renderer,
					int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (isRowSelected(row))
					c.setBackground(Color.BLUE);
				else if ((row % 2) == 0)
					c.setBackground(new Color(221, 243, 202));
				else
					c.setBackground(Color.WHITE);

				if (c instanceof JComponent) {
					((JComponent) c).setBorder(BorderFactory
							.createLineBorder(Color.LIGHT_GRAY));
				}

				return c;
			}
		};

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < ordinalTable.getColumnCount(); i++)
			ordinalTable.getColumnModel().getColumn(i)
					.setCellRenderer(centerRenderer);
		((DefaultTableCellRenderer) ordinalTable.getTableHeader()
				.getDefaultRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
			ordinalTable.getColumnModel().getColumn(1)
					.setCellRenderer(leftRenderer);

		ordinalTable.setAutoCreateRowSorter(true);

		JScrollPane scrollPane = new JScrollPane(ordinalTable);
		ordinalTable.setFillsViewportHeight(true);
		ordinalTable.setAutoCreateRowSorter(true);

		add(scrollPane, c);

	}

	public void loadData() {
		data.loadData(SchoolType.HIGH_SCHOOL.toString());
	}

}
