package info.ogpc.scoring.view;

import info.ogpc.scoring.model.OGPCDataModel;
import info.ogpc.scoring.model.Team;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;

public class Main {

	private static OGPCDataModel dataModel;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Initialize data model
		dataModel = new OGPCDataModel();
		for (Team team: dataModel.getTeams())
			team.initScoringSheet();
		
		File dataFile = new File("/Users/padraic/tempData.txt");
		if (dataFile.exists()) 
			Main.getDataModel().readData();

		//Launch the GUI
		EventQueue.invokeLater(new Runnable() {
			@Override
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
