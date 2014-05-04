package info.ogpc.scoring.view;

import info.ogpc.scoring.model.Category;
import info.ogpc.scoring.model.OGPCDataModel;
import info.ogpc.scoring.model.SchoolType;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AchievementInfoPanel extends JPanel implements ActionListener {
	JTable achievementTable;
	JTable achievementRankingTable;
	JComboBox<Category> categorySelector;
	public AchievementInfoPanel () {
		OGPCDataModel dataModel = Main.getDataModel();
		setLayout(new GridBagLayout());

		categorySelector = new JComboBox<Category>();
		for (Category category : dataModel.getCategories()) {
			categorySelector.addItem(category);
		}
		
		categorySelector.addActionListener(this);
				
		achievementTable = new JTable(new AchievementInfoTableModel(categorySelector.getItemAt(0)));
		achievementRankingTable = new JTable(new AchievementRankingTableModel(categorySelector.getItemAt(0)));
		
		JScrollPane scrollPane = new JScrollPane(achievementTable);
		achievementTable.setFillsViewportHeight(true);

		JScrollPane scrollRankingPane = new JScrollPane(achievementRankingTable);
		achievementRankingTable.setFillsViewportHeight(true);
		
//		scrollPane.setPreferredSize(new Dimension(600,768));
		add(categorySelector);
		add(scrollPane);
		add(scrollRankingPane);
	}

	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox<Category>)e.getSource();
		achievementTable.setModel(new AchievementInfoTableModel((Category) cb.getSelectedItem()));
		achievementRankingTable.setModel(new AchievementRankingTableModel((Category) cb.getSelectedItem()));
		
		
	}
}
