package info.ogpc.scoring.view;

import info.ogpc.scoring.model.Category;
import info.ogpc.scoring.model.OGPCDataModel;
import info.ogpc.scoring.model.Team;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class ScoringPanel extends JPanel implements ActionListener,ItemListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	OGPCDataModel dataModel = Main.getDataModel();
	CheckBoxPanel checkBoxPanel;
	ScoringTablePanel scoringTablePanel;
	SchoolTypeAndCategoryPanel schoolTypeAndCategoryPanel = new SchoolTypeAndCategoryPanel();

	public ScoringPanel() {
		setLayout(new GridBagLayout());
		setMinimumSize(new Dimension(1024, 768));
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth=1;
		// c.weightx = 0.2;
		// c.weighty = 0.2;
		 c.ipadx = 20;
		// c.insets = new Insets(5,5,5,5);
		c.anchor = GridBagConstraints.NORTH;
		schoolTypeAndCategoryPanel.addActionListener(this);
		add(schoolTypeAndCategoryPanel, c);
		
		checkBoxPanel = new CheckBoxPanel();

		checkBoxPanel.setLayout(new GridLayout(9, 4));
		c.gridx = 1;
		c.gridwidth=2;
		c.ipadx = 0;
		add(checkBoxPanel,c);
		updateCheckBoxPanel();
		checkBoxPanel.addItemListener(this);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth=3;
		c.gridheight=2;
		c.weightx=0.5;
		c.weighty=0.5;

		scoringTablePanel = new ScoringTablePanel(schoolTypeAndCategoryPanel.getSelectedSchoolType());
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5,5,5,5);

		scoringTablePanel.setBorder(BorderFactory.createLineBorder(Color.black));

		add(scoringTablePanel,c);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		updateCheckBoxPanel();
	}

	private void updateCheckBoxPanel() {
		checkBoxPanel.removeItemListener(this);
		checkBoxPanel.removeAll();
		Team currentTeam = schoolTypeAndCategoryPanel.getSelectedTeam();
		Category currentCategory = schoolTypeAndCategoryPanel.getSelectedCategory();
		checkBoxPanel.initCheckBoxes(currentCategory, currentTeam);
		checkBoxPanel.addItemListener(this);

		validate();
		repaint();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		//Kick this off at the end of the event queue so the GUI repaints at the proper time. 
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				scoringTablePanel.updateData();
			}
		});
	}	
}
