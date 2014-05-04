package info.ogpc.scoring.view;

import info.ogpc.scoring.model.Category;
import info.ogpc.scoring.model.OGPCDataModel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SummaryPanel extends JPanel {
	final JLabel lblBestInShow = new JLabel("Best In Show:");
	final JLabel lblProChoice = new JLabel("Pro's Choice:");
	final JLabel lblStudentChoice = new JLabel("Student's Choice:");
	final JLabel lblRookie = new JLabel("Rookie:");

	final JLabel lblBestInShowValue = new JLabel("Best In Show:");
	final JLabel lblProChoiceValue = new JLabel("Pro's Choice:");
	final JLabel lblStudentChoiceValue = new JLabel("Student's Choice:");
	final JLabel lblRookieValue = new JLabel("Rookie:");

	HashMap<String, JLabel> categoryLabelValues = new HashMap<String, JLabel>();
	OGPCDataModel dataModel = Main.getDataModel();

	public SummaryPanel() {
		setLayout(new GridLayout(0, 2));
		setPreferredSize(new Dimension(1024, 768));
		add(lblBestInShow);
		add(lblBestInShowValue);
		add(lblProChoice);
		add(lblProChoiceValue);
		add(lblStudentChoice);
		add(lblStudentChoiceValue);
		add(lblRookie);
		add(lblRookieValue);

		lblBestInShowValue.setText(Main.getDataModel().calculateBestInShow());
		lblProChoiceValue.setText(Main.getDataModel().calculateProChoice());
		lblStudentChoiceValue.setText(Main.getDataModel()
				.calculateStudentChoice());
		lblRookieValue.setText(Main.getDataModel().calculateRookieAward());

		for (Category category : dataModel.getCategories()) {
			add(new JLabel(category.getName() + ": "));
			JLabel label = new JLabel(
					dataModel.calculateCategoryAward(category));
			categoryLabelValues.put(category.getName(), label);
			add(label);
		}
	}

	public void updateSummary() {
		System.out.println("Updating summary");
		lblBestInShowValue.setText(Main.getDataModel().calculateBestInShow());
		lblProChoiceValue.setText(Main.getDataModel().calculateProChoice());
		lblStudentChoiceValue.setText(Main.getDataModel()
				.calculateStudentChoice());
		lblRookieValue.setText(Main.getDataModel().calculateRookieAward());
		for (Category category : dataModel.getCategories()) {
			JLabel label = categoryLabelValues.get(category.getName());
			label.setText(dataModel.calculateCategoryAward(category));
			categoryLabelValues.put(category.getName(), label);
			System.out.println("Updating category value:" + label.getText());
		}
	}
}
