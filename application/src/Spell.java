/**
 * Purpose: Represents arbitrarily complex data actually stored
 * in the database.
 */

public class Spell
{
	private String _name;
	private int _level;
	
	public Spell(String spellName, int spellLevel)
	{
		_name = spellName;
		_level = spellLevel;
	}

	public String name()
	{
		return _name;
	}

	public int level()
	{
		return _level;
	}
}
