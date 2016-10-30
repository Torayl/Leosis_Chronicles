package characters;

public abstract class Hero extends FightableCharacter {
	protected int level;
	protected int xp;
	protected int xp_required;
	public static final int LEVEL_MAX = 30;
	
	/*public Hero(Hero h) {
		super(h.name, h.abilities, h.max_health_points, h.attack, h.magic, h.defense, h.speed);
		level = h.level;
		xp = h.xp;
		xp_required = h.xp_required;
	}*/
	
	public Hero(String n,int lvl, int max_hp, int atk, int mag, int def, int spd) {
		super(n, max_hp, atk, mag, def, spd);
		level = lvl;
		xp = 0;
		xp_required = (level * 10) ^ 2;
	}
	
	public void earn_xp(int xp) {
		while (this.xp + xp > xp_required) {
			level_up();
			xp -= xp_required - this.xp;
		}
		this.xp += xp;
	}
	
	public void level_up() {
		if (level < LEVEL_MAX) {
			++level;
			xp = 0;
			xp_required = (level * 10) ^ 2;
		}
	}
	
	@Override
	public String toString() {
		return name + " Lvl." + level + " " + health_points + "/" + max_health_points + "HP\n" +
				"Attack: " + attack + " | " + "Magic: " + magic + "\n" +
				"Defense: " + defense + " | " + "Speed: " + speed;
	}
}