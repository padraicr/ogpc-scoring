package info.ogpc.scoring.view;

import info.ogpc.scoring.model.Category;
import info.ogpc.scoring.model.SchoolType;
import info.ogpc.scoring.model.Team;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import sun.awt.HorizBagLayout;

public class SchoolTypeAndCategoryPanel extends JPanel implements ActionListener{
	SchoolTypePanel schoolTypePanel = new SchoolTypePanel();
	CategoryTypePanel categoryTypePanel = new CategoryTypePanel();
	JComboBox<Team> cbTeams = new JComboBox<Team>();

	public SchoolTypeAndCategoryPanel () {
		JPanel containerPanel = new JPanel();
		setLayout(new GridBagLayout());
		containerPanel.setLayout(new GridBagLayout());
		containerPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		GridBagConstraints c = new GridBagConstraints();
		c.gridheight = 2;
//		c.gridwidth = 100;
		c.insets = new Insets(5,5,5,5);
		c.ipadx  =5;
		c.ipady = 5;	
		containerPanel.add(schoolTypePanel,c);

		c.gridy = 1;
		containerPanel.add(categoryTypePanel,c);

		c = new GridBagConstraints();
		c.insets = new Insets(5,5,2,5);
		c.gridwidth = 3;
		add(containerPanel,c);

		c = new GridBagConstraints();
		c.insets = new Insets(2,25,5,2);
		c.gridwidth = 1;
		c.gridx=0;
		c.gridy=1;
		add(new JLabel("School:"),c);
				
		for (Team team : Main.getDataModel().getTeams()) {
			String selected = schoolTypePanel.getSelection();
			if (selected.equals(team.getSchoolType().toString()))
				cbTeams.addItem(team);
		}
		cbTeams.setMaximumSize(new Dimension(20,20));
		//Dummy team only for display sizing purposes.
		cbTeams.setPrototypeDisplayValue(new Team("","","","123456789012345678901234",SchoolType.HIGH_SCHOOL,"",0));

		c = new GridBagConstraints();
		c.insets = new Insets(2,2,5,20);
		c.gridwidth = 2;
		c.gridx=1;
		c.gridy=1;
		c.anchor = GridBagConstraints.EAST;
		add(cbTeams,c);
		schoolTypePanel.addActionListener(this);
				
	}
	
	public void addActionListener (ActionListener aListener) {
		cbTeams.addActionListener(aListener);
		schoolTypePanel.addActionListener(aListener);
		categoryTypePanel.addActionListener(aListener);

	}

	public Category getSelectedCategory() {
		return categoryTypePanel.getSelectedCategory();
	}

	public Team getSelectedTeam() {
		return (Team) cbTeams.getSelectedItem();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
			//	cbTeams.removeAllItems();
				 DefaultComboBoxModel<Team> model = new DefaultComboBoxModel<Team>();
				
				for (Team team : Main.getDataModel().getTeams()) {
					String selected = schoolTypePanel.getSelection();
					if (selected.equals(team.getSchoolType().toString()))
						model.addElement(team);
				}
				cbTeams.setModel(model);
				
			}
		});

	}

	public String getSelectedSchoolType() {
		// TODO Auto-generated method stub
		return schoolTypePanel.getSelection();
	}
}
