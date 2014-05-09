package info.ogpc.scoring.view;

import info.ogpc.scoring.main.Main;
import info.ogpc.scoring.model.Category;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CategoryTypePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ButtonGroup rbGroup = new ButtonGroup();

	public CategoryTypePanel () {
		setLayout(new GridLayout(0, 1));
		for (Category category : Main.getDataModel().getCategories()) {
			JRadioButton radioButton = new JRadioButton(category.getName());
			radioButton.setName(category.getName());
			rbGroup.add(radioButton);
			add(radioButton);
		}
		JRadioButton button = (JRadioButton) rbGroup.getElements().nextElement();
		button.setSelected(true);
	}
	
	public void addActionListener(ActionListener aListener) {
		Enumeration<AbstractButton> buttons = rbGroup.getElements();
		while (buttons.hasMoreElements())	{
			AbstractButton button = buttons.nextElement();
			button.addActionListener(aListener);
		}
		
	}

	public Category getSelectedCategory() {
		Enumeration<AbstractButton> buttons = rbGroup.getElements();
		while (buttons.hasMoreElements())	{
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) 
				return Main.getDataModel().getCategory(button.getName());
			
		}
		return null;
	}

}
