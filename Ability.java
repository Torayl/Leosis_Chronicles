package abilities;

public abstract class Ability {
	protected String name;
	protected String definition;
	protected Effect effect;
	
	public Ability(String n, String d, Effect e) {
		name = n;
		definition = d;
		effect = e;
	}
	
	public String toString() {
		return name + " : " + definition;
	}
}