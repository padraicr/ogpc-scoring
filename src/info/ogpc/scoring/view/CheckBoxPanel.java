package info.ogpc.scoring.view;

import info.ogpc.scoring.model.Achievement;
import info.ogpc.scoring.model.Category;
import info.ogpc.scoring.model.ScoringSheet;
import info.ogpc.scoring.model.Team;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class CheckBoxPanel extends JPanel implements ItemListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Category currentCategory;
	Team currentTeam;
	HashMap<JCheckBox, String> checkBoxMap;
	
	public CheckBoxPanel() {
		setLayout(new GridLayout(7, 3));	
		checkBoxMap = new HashMap<JCheckBox, String>();
	}
	
	public void initCheckBoxes(Category _currentCategory, Team _currentTeam){
		currentCategory = _currentCategory;
		currentTeam = _currentTeam;
		checkBoxMap = new HashMap<JCheckBox, String>();
				
		ScoringSheet currentSheet = currentTeam.getScoringSheet(currentCategory);
		
		for (String achievementId : currentCategory.getAchievements().keySet()) {
			Achievement currentAchievement = currentCategory.getAchievements().get(achievementId);
			JCheckBox checkBox = new JCheckBox(currentAchievement.getDisplayName());
			checkBoxMap.put(checkBox,  achievementId);
			checkBox.setToolTipText(currentAchievement.getDescription());
			if (currentSheet.getAchievementValue(achievementId) > 0) {
				checkBox.setSelected(true);
			}
			add(checkBox);
			checkBox.addItemListener(this);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JCheckBox cb = (JCheckBox)e.getSource();
		String id = checkBoxMap.get(cb);
		if (cb.isSelected())
			currentTeam.scoreAchievement(currentCategory, id);
		else
			currentTeam.scoreAchievement(currentCategory, id, 0);
			
	}
	public void addItemListener(ItemListener il) {
		for(JCheckBox box : checkBoxMap.keySet()) {
			box.addItemListener(il);
		}
	}

	public void removeItemListener(ItemListener il) {
		for(JCheckBox box : checkBoxMap.keySet()) {
			box.removeItemListener(il);
		}
	}
}
