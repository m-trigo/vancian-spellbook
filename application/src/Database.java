import java.util.*;

public class Database
{
	private Vector<Spell> _listOfSpells;
	
	public Database()
	{
		_listOfSpells = new Vector<Spell>();
	}
	
	public void addElement(Spell spell)
	{
		_listOfSpells.add(spell);
	}
	
	// Note: This method is currently private!
	private Spell getElementById(String spellName)
	{
		for(Spell s : _listOfSpells)
		{
			if (s.name().equals(spellName))
			{
				return s;
			}
		}
		
		return null;
	}
	
	public boolean containsElementOfId(String spellName)
	{
		return getElementById(spellName) != null;
	}
	
	public int removeElementById(String spellName)
	{
		Spell spell = getElementById(spellName);
		if (spell != null)
		{
			_listOfSpells.remove(spell);
			return 1;
		}
			
		return 0;
	}
	
	public List<Spell> deepCopiedFullList()
	{
		return new Vector<Spell>(_listOfSpells);
	}
	
}
