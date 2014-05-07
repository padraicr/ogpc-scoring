package info.ogpc.scoring.view;

import info.ogpc.scoring.model.AchievementInfoTableModel;
import info.ogpc.scoring.model.AchievementRankingTableModel;
import info.ogpc.scoring.model.Category;
import info.ogpc.scoring.model.OGPCDataModel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AchievementInfoPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable achievementTable;
	JTable achievementRankingTable;
	JComboBox<Category> categorySelector;
	SchoolTypeAndCategoryPanel schoolTypeAndCategoryPanel = new SchoolTypeAndCategoryPanel();
	public AchievementInfoPanel () {
		OGPCDataModel dataModel = Main.getDataModel();
		setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(1024,768));
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridheight = 50;
		c.gridwidth = 100;
		c.insets = new Insets(2,2,2,2);
		c.ipadx  =5;
		c.ipady = 5;
		add(schoolTypeAndCategoryPanel,c);
		categorySelector = new JComboBox<Category>();
		for (Category category : dataModel.getCategories()) {
			categorySelector.addItem(category);
		}
//		categorySelector.setPreferredSize(new Dimension(100,500));
		categorySelector.addActionListener(this);
				
		achievementTable = new JTable(new AchievementInfoTableModel(categorySelector.getItemAt(0)));
		achievementRankingTable = new JTable(new AchievementRankingTableModel(categorySelector.getItemAt(0)));
	//	achievementTable.setPreferredScrollableViewportSize(new Dimension(100,500));
		JScrollPane scrollPane = new JScrollPane(achievementTable);
//		achievementTable.setFillsViewportHeight(true);

		JScrollPane scrollRankingPane = new JScrollPane(achievementRankingTable);
		//achievementRankingTable.setFillsViewportHeight(true);
		
		//achievementRankingTable.setPreferredSize(new Dimension(600,768));
		//scrollRankingPane.setPreferredSize(new Dimension(600,768));
		add(categorySelector,c);
		c.fill = GridBagConstraints.BOTH;
		add(scrollPane,c);
		add(scrollRankingPane,c);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JComboBox) {
		JComboBox<Category> cb = (JComboBox<Category>)e.getSource();
		achievementTable.setModel(new AchievementInfoTableModel((Category) cb.getSelectedItem()));
		achievementRankingTable.setModel(new AchievementRankingTableModel((Category) cb.getSelectedItem()));
		this.repaint();
		}
		
		
	}
}
