package info.ogpc.scoring.view;

import info.ogpc.scoring.main.Main;
import info.ogpc.scoring.model.Category;
import info.ogpc.scoring.model.SchoolType;
import info.ogpc.scoring.model.Team;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SchoolTypeAndCategoryPanel extends JPanel implements
		ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SchoolTypePanel schoolTypePanel = new SchoolTypePanel();
	CategoryTypePanel categoryTypePanel = new CategoryTypePanel();
	JComboBox<Team> cbTeams = new JComboBox<Team>();
	JCheckBox cbRookie = new JCheckBox("Rookie Team");

	public SchoolTypeAndCategoryPanel() {
		JPanel containerPanel = new JPanel();
		setLayout(new GridBagLayout());
		containerPanel.setLayout(new GridBagLayout());
		containerPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		GridBagConstraints c = new GridBagConstraints();
		c.gridheight = 2;
		// c.gridwidth = 100;
		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 5;
		c.ipady = 5;
		containerPanel.add(schoolTypePanel, c);

		c.gridy = 1;
		containerPanel.add(categoryTypePanel, c);

		c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 2, 5);
		c.gridwidth = 3;
		add(containerPanel, c);

		c = new GridBagConstraints();
		c.insets = new Insets(2, 25, 2, 2);
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		add(new JLabel("School:"), c);

		for (Team team : Main.getDataModel().getTeams()) {
			String selected = schoolTypePanel.getSelection();
			if (selected.equals(team.getSchoolType().toString()))
				cbTeams.addItem(team);
		}
		cbTeams.setMaximumSize(new Dimension(20, 20));
		// Dummy team only for display sizing purposes.
		cbTeams.setPrototypeDisplayValue(new Team("", "", "",
				"123456789012345678901234", SchoolType.HIGH_SCHOOL, "", 0,
				"FALSE"));
		cbTeams.addActionListener(this);
		c = new GridBagConstraints();
		c.insets = new Insets(2, 2, 2, 20);
		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.WEST;
		add(cbTeams, c);
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(0, 0, 2, 0);
		cbRookie.setSelected(((Team) cbTeams.getSelectedItem()).isRookie());
		add(cbRookie, c);
		schoolTypePanel.addActionListener(this);
		cbRookie.addActionListener(this);

	}

	public void addActionListener(ActionListener aListener) {
		cbTeams.addActionListener(aListener);
		cbRookie.addActionListener(aListener);
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
		System.out.println("e-source=" + e.getSource());
		if (e.getSource() instanceof JCheckBox) {
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					getSelectedTeam().setRookie(cbRookie.isSelected());
				}
			});
		} else if (e.getSource() instanceof JComboBox<?>) {
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					cbRookie.setSelected(getSelectedTeam().isRookie());
				}
			});
		} else {
			System.out.println("in else clause");
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					// cbTeams.removeAllItems();
					DefaultComboBoxModel<Team> model = new DefaultComboBoxModel<Team>();

					for (Team team : Main.getDataModel().getTeams()) {
						String selected = schoolTypePanel.getSelection();
						if (selected.equals(team.getSchoolType().toString()))
							model.addElement(team);
					}
					cbTeams.setModel(model);
					cbRookie.setSelected(getSelectedTeam().isRookie());

				}
			});
		}

	}

	public String getSelectedSchoolType() {
		// TODO Auto-generated method stub
		return schoolTypePanel.getSelection();
	}
}
