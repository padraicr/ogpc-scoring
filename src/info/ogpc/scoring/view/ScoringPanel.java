package info.ogpc.scoring.view;

import info.ogpc.scoring.model.Achievement;
import info.ogpc.scoring.model.Category;
import info.ogpc.scoring.model.OGPCDataModel;
import info.ogpc.scoring.model.ScoringSheet;
import info.ogpc.scoring.model.Team;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ScoringPanel extends JPanel implements ListSelectionListener {
	OGPCDataModel dataModel = Main.getDataModel();
	JList<Category> categorySelector;
	JList<Team> teamSelector;
	JRadioButton rbHighSchool = new JRadioButton("High School", true);
	JRadioButton rbMiddleSchool = new JRadioButton("Middle School");
	ButtonGroup rbGroup = new ButtonGroup();
	Category activeCategory;
	CheckBoxPanel checkBoxPanel = new CheckBoxPanel();

	public ScoringPanel() {

		rbGroup.add(rbMiddleSchool);
		rbGroup.add(rbHighSchool);

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

		add(rbMiddleSchool);
		add(rbHighSchool);
		add(teamScrollPane);
		add(categoryScrollPane);
		add(checkBoxPanel);

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
