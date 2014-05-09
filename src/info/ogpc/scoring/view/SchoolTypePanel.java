package info.ogpc.scoring.view;

import info.ogpc.scoring.model.SchoolType;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SchoolTypePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JRadioButton rbHighSchool = new JRadioButton("High School", true);
	JRadioButton rbMiddleSchool = new JRadioButton("Middle School");
	ButtonGroup rbGroup = new ButtonGroup();

	public SchoolTypePanel () {
		setLayout(new GridLayout(2, 1));
		rbHighSchool.setName(SchoolType.HIGH_SCHOOL.toString());
		rbMiddleSchool.setName(SchoolType.MIDDLE_SCHOOL.toString());

		rbGroup.add(rbMiddleSchool);
		rbGroup.add(rbHighSchool);
		rbMiddleSchool.setSelected(true);
		add(rbMiddleSchool);
		add(rbHighSchool);
		
		setMaximumSize(new Dimension(1,1));
	}
	
	public void addActionListener(ActionListener aListener) {
		rbMiddleSchool.addActionListener(aListener);
		rbHighSchool.addActionListener(aListener);
	}
	
	public String getSelection() {
		Enumeration<AbstractButton> buttons = rbGroup.getElements();
		while (buttons.hasMoreElements())	{
			AbstractButton button = buttons.nextElement();
			if (button.isSelected())
				return button.getName();
		}
		return null;
	}
}
