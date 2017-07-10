import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Controller extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private final int FONT_SIZE = 20;
	private final Color BACKGROUND_COLOR = new Color(220, 191, 134);
	private final Color BUTTONS_BACKGROUND_COLOR = new Color(178, 162, 131);
	private final Font FONT = new Font ("Viner Hand ITC", Font.PLAIN, FONT_SIZE);
	private final Color FONT_COLOR = new Color(38, 55, 197);
	
	private Database _context;
	private View _view;
	
	private JTextField inputTextField;
	private String VIEW_BUTTON_ACTION_COMMAND = "View Known Spells";
	private String ADD_BUTTON_ACTION_COMMAND = "Add Spell";
	private String REMOVE_BUTTON_ACTION_COMMAND = "Remove Spell";
	
	public Controller(Database context)
	{
		super(" ~ Spellbook ~ ");
		_context = context;
		_view = null;
		
		JPanel controllerPanel = new JPanel();
		controllerPanel.setLayout(new BorderLayout()); 

		JPanel inputPanel = new JPanel();
		inputPanel.setBackground(BACKGROUND_COLOR);
		
		JLabel inputFieldLabel = new JLabel("Spell Name  –  ");
		inputFieldLabel.setBackground(BACKGROUND_COLOR);
		inputFieldLabel.setFont(FONT);
		inputFieldLabel.setForeground(FONT_COLOR);
		inputPanel.add(inputFieldLabel);
		
		inputTextField = new JTextField(27);
		inputTextField.setFont(FONT);
		inputTextField.setBackground(BACKGROUND_COLOR);
		inputTextField.setBorder(BorderFactory.createEmptyBorder());
		inputPanel.add(inputTextField);
		
		controllerPanel.add(inputPanel, BorderLayout.NORTH);
		
		ActionListener buttonListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				String buttonLabel = event.getActionCommand();
				
				if (buttonLabel.equals(VIEW_BUTTON_ACTION_COMMAND))
				{
					if (_view != null)
					{
						_view.dispose();
						_view = null;
					}
					else
					{
						_view = new View(new Model(_context).arrayOfSpellNames(), getWidth(), getBottomLeftCorner());
					}
				}
				else 
				{
					String spellName = inputTextField.getText();
					if (spellName.isEmpty())
					{
						return;
					}

					Model spellModel = new Model(_context);
					spellModel.spellName = spellName;
						
					if (buttonLabel.equals(ADD_BUTTON_ACTION_COMMAND))
					{
						spellModel.learn();
					}
					else if (buttonLabel.equals(REMOVE_BUTTON_ACTION_COMMAND))
					{
						spellModel.forget();
					}
					
					_view.update(spellModel.arrayOfSpellNames());

				}
			}
		};

		JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
		
		// View
		JButton viewButton = new JButton(VIEW_BUTTON_ACTION_COMMAND);
		viewButton.setFont(FONT);
		viewButton.setBackground(BUTTONS_BACKGROUND_COLOR);
		viewButton.setForeground(FONT_COLOR);
		viewButton.addActionListener(buttonListener);
		buttonPanel.add(viewButton);
		
		// Add
		JButton addButton = new JButton(ADD_BUTTON_ACTION_COMMAND);
		addButton.setFont(FONT);
		addButton.setBackground(BUTTONS_BACKGROUND_COLOR);
		addButton.setForeground(FONT_COLOR);
		addButton.addActionListener(buttonListener);
		buttonPanel.add(addButton);
		
		// Remove
		JButton removeButton = new JButton(REMOVE_BUTTON_ACTION_COMMAND);
		removeButton.setFont(FONT);
		removeButton.setBackground(BUTTONS_BACKGROUND_COLOR);
		removeButton.setForeground(FONT_COLOR);
		removeButton.addActionListener(buttonListener);
		buttonPanel.add(removeButton);
		
		controllerPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		this.add(controllerPanel); 
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
	}
	
	private Point getBottomLeftCorner()
	{
		return new Point(this.getX(), this.getY() + this.getHeight());
	}
}
