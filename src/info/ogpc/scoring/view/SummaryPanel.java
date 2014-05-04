package info.ogpc.scoring.view;

import info.ogpc.scoring.model.Category;
import info.ogpc.scoring.model.OGPCDataModel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

public class SummaryPanel extends JPanel {
	final JLabel lblBestInShow = new JLabel("Best In Show:");
	final JLabel lblProChoice = new JLabel("Pro's Choice:");
	final JLabel lblStudentChoice = new JLabel("Student's Choice:");
	final JLabel lblRookie = new JLabel("Rookie:");
	
	JList<String> lsBestInShow;
	JList<String> lsProChoice;
	JList<String> lsStudentChoice;
	JList<String> lsRookie;
	

	HashMap<String, JList<String>> categoryLabelValues = new HashMap<String, JList<String>>();
	OGPCDataModel dataModel = Main.getDataModel();

	public SummaryPanel() {
		setLayout(new GridLayout(0, 2));
		setPreferredSize(new Dimension(1024, 768));


		lsBestInShow = new JList<String>(Main.getDataModel().calculateBestInShow());
		lsProChoice = new JList<String>(Main.getDataModel().calculateProChoice());
		lsStudentChoice= new JList<String>(Main.getDataModel()
				.calculateStudentChoice());
		lsRookie = new JList<String>(Main.getDataModel().calculateRookieAward());

		add(lblBestInShow);
		add(lsBestInShow);
		add(lblProChoice);
		add(lsProChoice);
		add(lblStudentChoice);
		add(lsStudentChoice);
		add(lblRookie);
		add(lsRookie);
		
		for (Category category : dataModel.getCategories()) {
			add(new JLabel(category.getName() + ": "));
			JList<String> list= new JList<String>
					(dataModel.calculateCategoryAward(category));
			categoryLabelValues.put(category.getName(), list);
			add(list);
		}
		
	}

	public void updateSummary() {
		System.out.println("Updating summary");
/*		listModel = new DefaultListModel<string>
		lsBestInShow.setModel(new DefaultListModel<String>());
		lblBestInShowValue.setText(Main.getDataModel().calculateBestInShow());
		lblProChoiceValue.setText(Main.getDataModel().calculateProChoice());
		lblStudentChoiceValue.setText(Main.getDataModel()
				.calculateStudentChoice());
		lblRookieValue.setText(Main.getDataModel().calculateRookieAward());*/
		for (Category category : dataModel.getCategories()) {
			JList list = categoryLabelValues.get(category.getName());
			DefaultListModel<String> lm = new DefaultListModel<String>();
			for (String s : dataModel.calculateCategoryAward(category)) {
				lm.addElement(s);
			}
			list.setModel(lm);
		}
	}
}
