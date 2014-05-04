package info.ogpc.scoring.view;

import info.ogpc.scoring.model.Achievement;
import info.ogpc.scoring.model.Category;
import info.ogpc.scoring.model.OGPCDataModel;
import info.ogpc.scoring.model.ScoringSheet;
import info.ogpc.scoring.model.Team;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class Main {

	private JTabbedPane contentPane;
	private static OGPCDataModel dataModel;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Initialize data model
		dataModel = new OGPCDataModel();
		for (Team team: dataModel.getTeams())
			team.initScoringSheet();
		
		File dataFile = new File("/home/padraic/tempData.txt");
		if (dataFile.exists()) 
			Main.getDataModel().readData();

		//Launch the GUI
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame("OGPC Scoring");
					frame.setBounds(100, 100, 1200, 800);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
					frame.add(new MainWindow(), BorderLayout.CENTER);
					frame.pack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static OGPCDataModel getDataModel() {
		return dataModel;
	}


}
