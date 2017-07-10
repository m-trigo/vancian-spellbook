/**
 * Purpose: A POD (Plain Old Data) object to represent state in the database
 * Note: the model will be the last class with a full concept of the database stored data type.
 */

import java.util.*;

public class Model
{
	private Database _context;
	
	public String spellName;
	
	public static final int SPELL_LEVEL = 1; // currently the only spell level supported
	
	public Model(Database context)
	{
		_context = context;
	}
	
	public void learn()
	{
		_context.addElement(new Spell(spellName, SPELL_LEVEL));
	}
	
	public int forget()
	{
		if (_context.containsElementOfId(spellName))
		{
			_context.removeElementById(spellName);
			return 1;
		}
		
		return 0;
	}

	public String[] arrayOfSpellNames()
	{
		List<Spell> deepCopy = _context.deepCopiedFullList();
		int spellCount = deepCopy.size();
		
		String[] spellNames = new String[spellCount];
		for(int index = 0; index < spellCount; index++)
		{
			spellNames[index] = deepCopy.get(index).name();
		}
		
		return spellNames;		
	}
}
