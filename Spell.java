package abilities;

public abstract class Spell extends Ability {
	protected int mana_cost;
	
	public Spell(String n, String d, Effect e, int mana_cost) {
		super(n, d, e);
	}
	
	public String toString() {
		return super.toString() + " - " + mana_cost + " MP";
	}
}