package info.ogpc.scoring.view;

import info.ogpc.scoring.model.Category;
import info.ogpc.scoring.model.OGPCDataModel;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SummaryPanel extends JPanel {
	JLabel lblBestInShowValue = new JLabel("Best In Show:");
	JLabel lblProChoiceValue = new JLabel("Pro's Choice:");
	JLabel lblStudentChoiceValue = new JLabel("Student's Choice:");
	JLabel lblRookieValue = new JLabel("Rookie:");
	OGPCDataModel dataModel = Main.getDataModel();
	
	public SummaryPanel () {
		setLayout(new GridLayout(0,2));
		setPreferredSize(new Dimension(1024,768));
		add(lblBestInShowValue);
		add(new JLabel(Main.getDataModel().calculateBestInShow()));
		add(lblProChoiceValue);
		add(new JLabel(Main.getDataModel().calculateProChoice()));
		add(lblStudentChoiceValue);
		add(new JLabel(Main.getDataModel().calculateStudentChoice()));
		add(lblRookieValue);
		add(new JLabel(Main.getDataModel().calculateRookieAward()));

		for (Category category : dataModel.getCategories()) {
			add(new JLabel(category.getName()+": "));
			add(new JLabel(dataModel.calculateCategoryAward(category.getName())));
		}
	}

}
