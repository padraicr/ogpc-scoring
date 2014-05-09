package info.ogpc.scoring.main;

import info.ogpc.scoring.main.tabs.OrdinalPanel;
import info.ogpc.scoring.main.tabs.ScoringPanel;
import info.ogpc.scoring.main.tabs.TeamInformationPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainWindow extends JPanel implements ChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTabbedPane contentPane;
	JComponent scoringPage = new ScoringPanel();
	JComponent teamInformation = new TeamInformationPanel();

	public MainWindow() {

		contentPane = new JTabbedPane();
		contentPane.addChangeListener(this);

		JComponent scoringPage = new ScoringPanel();
		JComponent teamInformation = new TeamInformationPanel();
		JComponent ordinalPanel = new OrdinalPanel();

		contentPane.setPreferredSize(new Dimension(1024, 768));
		setMinimumSize(new Dimension(1024, 768));

		contentPane.addTab("Scoring Details", scoringPage);
		contentPane.addTab("Team Information", teamInformation);
		contentPane.addTab("Ordinal Ranking", ordinalPanel);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		add(contentPane);
	}

	protected JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(SwingConstants.CENTER);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(filler);
		return panel;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		Main.getDataModel().writeData();
//		Main.getDataModel().readData();
		
	}
}
