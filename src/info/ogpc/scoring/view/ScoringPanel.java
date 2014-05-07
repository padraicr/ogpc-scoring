package info.ogpc.scoring.view;

import info.ogpc.scoring.model.Category;
import info.ogpc.scoring.model.OGPCDataModel;
import info.ogpc.scoring.model.Team;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ScoringPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	OGPCDataModel dataModel = Main.getDataModel();
	CheckBoxPanel checkBoxPanel = new CheckBoxPanel();
	SchoolTypeAndCategoryPanel schoolTypeAndCategoryPanel = new SchoolTypeAndCategoryPanel();

	public ScoringPanel() {
		setLayout(new GridBagLayout());
		setMinimumSize(new Dimension(1024, 768));
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		// c.weightx = 0.2;
		// c.weighty = 0.2;
		// c.ipadx = 20;
		// c.insets = new Insets(5,5,5,5);
		c.anchor = GridBagConstraints.NORTHWEST;
		schoolTypeAndCategoryPanel.addActionListener(this);
		add(schoolTypeAndCategoryPanel, c);

		checkBoxPanel.setLayout(new GridLayout(10, 4));
		add(checkBoxPanel);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				checkBoxPanel.removeAll();
				Team currentTeam = schoolTypeAndCategoryPanel.getSelectedTeam();
				Category currentCategory = schoolTypeAndCategoryPanel.getSelectedCategory();
				checkBoxPanel.initCheckBoxes(currentCategory, currentTeam);
				validate();
				repaint();
			}
		});
	}

}
