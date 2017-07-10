/**
 * Purpose: Visually represents certain attributes of stored data.
 * For example, it currently only represents the name of the Spell,
 * but not its level.
 */

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class View extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private final int WINDOW_HEIGHT = 400;
	private final Color JLIST_BACKGROUND_COLOR = new Color(220, 191, 134);
	private final int FONT_SIZE = 30;
	private final Color FONT_COLOR = new Color(92, 59, 49);
	private final Font FONT = new Font ("Viner Hand ITC", Font.ITALIC, FONT_SIZE);
	private final int MARGIN_SIZE = 15;
	private final Border MARGIN = BorderFactory.createEmptyBorder(MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE);
	private final Color HIGHLIGHT_COLOR = new Color(38, 55, 197);
	
	private JList<String> spellList;
	
	public View(String[] arrayOfSpellNames, int windowWidth, Point topLeftCorner)
	{
		super(" ~ Known Spells ~ ");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
		this.setSize(windowWidth, WINDOW_HEIGHT);
		
		JPanel displayPanel = new JPanel();
		displayPanel.setLayout(new BorderLayout()); // The layout will force the JList to fill the JPanel
		
		spellList = new JList<String>(arrayOfSpellNames);
		spellList.setBackground(JLIST_BACKGROUND_COLOR);
		spellList.setSelectionBackground(JLIST_BACKGROUND_COLOR);
		spellList.setSelectionForeground(HIGHLIGHT_COLOR);
		spellList.setForeground(FONT_COLOR);
		spellList.setBorder(MARGIN);
		spellList.setFont(FONT);
		UIManager.put("List.focusCellHighlightBorder", BorderFactory.createEmptyBorder());
		
		displayPanel.add(new JScrollPane(spellList));
		
		this.add(displayPanel); 

		this.setLocation(topLeftCorner);
		this.setVisible(true);
	}
	
	public void update(String[] arrayOfSpellNames)
	{
		spellList.setListData(arrayOfSpellNames);
	}

}// View
