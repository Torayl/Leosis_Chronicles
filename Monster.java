package characters;

import items.*;

public abstract class Monster extends FightableCharacter {
	protected int given_xp;
	protected int given_gold;
	protected Item[] given_items;
	
	public Monster(String n, int max_hp, int max_mp, int atk, int mag, int def, int spd, int given_xp, int given_gold, Item[] given_items) {
		super(n, max_hp, max_mp, atk, mag, def, spd);
		this.given_xp = given_xp;
		this.given_gold = given_gold;
		this.given_items = given_items;
	}

	public void die() {
		super.die();
		/* DROP */
	}
}