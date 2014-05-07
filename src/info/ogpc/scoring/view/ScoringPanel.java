package info.ogpc.scoring.view;

import info.ogpc.scoring.model.Category;
import info.ogpc.scoring.model.OGPCDataModel;
import info.ogpc.scoring.model.Team;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ScoringPanel extends JPanel implements ListSelectionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	OGPCDataModel dataModel = Main.getDataModel();
	JList<Category> categorySelector;
	JList<Team> teamSelector;
	JRadioButton rbHighSchool = new JRadioButton("High School", true);
	JRadioButton rbMiddleSchool = new JRadioButton("Middle School");
	ButtonGroup rbGroup = new ButtonGroup();
	Category activeCategory;
	CheckBoxPanel checkBoxPanel = new CheckBoxPanel();
	SchoolTypeAndCategoryPanel schoolTypeAndCategoryPanel = new SchoolTypeAndCategoryPanel();

	public ScoringPanel() {
		setLayout(new GridBagLayout());
		setMinimumSize(new Dimension(1024,768));
		GridBagConstraints c = new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		c.weightx = 0.2;
	//	c.weighty = 0.2;
		c.ipadx = 20;
		c.insets = new Insets(5,5,5,5);
		c.anchor = GridBagConstraints.NORTHWEST;
		add(schoolTypeAndCategoryPanel,c);
		
		c.gridx=0;
		c.gridy=1;
		c.weightx = 0.2;
		c.weighty = 0.3;
		//c.ipadx = 20;
		c.insets = new Insets(5,5,5,5);
		add(new JLabel("School:"),c);
	
		JComboBox cbTeams = new JComboBox();
		for (Team team : dataModel.getTeams()) {
			cbTeams.addItem(team);
		}
	//	teamSelector = new JList<Team>(teamListModel);
		//JScrollPane teamScrollPane = new JScrollPane(teamSelector);
		//teamSelector.addListSelectionListener(this);
		c.ipady = 20;
		c.weighty=0.2;
		add(cbTeams,c);
		
		
		DefaultListModel<Category> categoryListModel = new DefaultListModel<Category>();
		for (Category category : dataModel.getCategories()) {
			categoryListModel.addElement(category);
		}
		categorySelector = new JList<Category>(categoryListModel);
		JScrollPane categoryScrollPane = new JScrollPane(categorySelector);
		categorySelector.addListSelectionListener(this);

		DefaultListModel<Team> teamListModel = new DefaultListModel<Team>();
		for (Team team : dataModel.getTeams()) {
			teamListModel.addElement(team);
		}
		teamSelector = new JList<Team>(teamListModel);
		JScrollPane teamScrollPane = new JScrollPane(teamSelector);
		teamSelector.addListSelectionListener(this);

		checkBoxPanel.setLayout(new GridLayout(10, 4));

//		add(teamScrollPane);
	//	add(categoryScrollPane);
		//add(checkBoxPanel);

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		checkBoxPanel.removeAll();
		// checkBoxPanel = new CheckBoxPanel();

		if ((categorySelector.getSelectedIndex() == -1)
				|| (teamSelector.getSelectedIndex() == -1)) {
			// clean this up later
			return;
		} else {
			Category currentCategory = categorySelector.getSelectedValue();
			Team currentTeam = teamSelector.getSelectedValue();
			checkBoxPanel.initCheckBoxes(currentCategory, currentTeam);
		}
		validate();
		repaint();
	}

}
