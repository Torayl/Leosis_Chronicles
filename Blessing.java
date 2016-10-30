package abilities;

import characters.FightableCharacter;

public final class Blessing extends Spell {
	private FightableCharacter user, target;
	
	public Blessing(FightableCharacter u, FightableCharacter t) {
		super("Blessing", "Heals the targeted ally.", new Heal(user, target), 50);
		user = u;
		target = t;
	}

	public final void use() {
		effect.use();
		u.get_mana_points() -= mana_cost;
	}
}