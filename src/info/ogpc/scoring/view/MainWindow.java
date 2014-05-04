package info.ogpc.scoring.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainWindow extends JPanel implements ChangeListener {
	JTabbedPane contentPane;
	SummaryPanel summaryPage = new SummaryPanel();
	JComponent scoringPage = new ScoringPanel();
	JComponent teamInformation = new TeamInformationPanel();
	JComponent Achievements = new AchievementInfoPanel();

	public MainWindow() {

		contentPane = new JTabbedPane();
		contentPane.addChangeListener(this);

		JComponent summaryPage = new SummaryPanel();
		JComponent scoringPage = new ScoringPanel();
		JComponent teamInformation = new TeamInformationPanel();
		JComponent Achievements = new AchievementInfoPanel();

		contentPane.setPreferredSize(new Dimension(1024, 768));
		setMinimumSize(new Dimension(1024, 768));

		contentPane.addTab("Scoring Summary", summaryPage);
		contentPane.addTab("Scoring Details", scoringPage);
		contentPane.addTab("Team Information", teamInformation);
		contentPane.addTab("Achievements", Achievements);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		add(contentPane);
	}

	protected JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(filler);
		return panel;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		summaryPage.updateSummary();
	}
}
