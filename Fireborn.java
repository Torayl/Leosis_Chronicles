package characters;

import abilities.*;

public final class Fireborn extends Hero {

	public Fireborn(String n, int lvl, int max_hp, int atk, int mag, int def, int spd) {
		super(n, lvl, max_hp, atk, mag, def, spd);
		learn_ability(new Blessing());
	}
}