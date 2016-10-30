package characters;

import java.util.ArrayList;

import abilities.*;

public abstract class FightableCharacter extends Character {
	ArrayList<Ability> abilities;
	protected int max_health_points;
	protected int health_points;
	protected int max_mana_points;
	protected int mana_points;
	protected int attack;
	protected int magic;
	protected int defense;
	protected int speed;
	protected boolean dead;
	
	public FightableCharacter() {
		this("NO_NAME", 0, 0, 0, 0, 0, 0);
	}
	
	public FightableCharacter(String n, int max_hp, int max_mp, int atk, int mag, int def, int spd) {
		super(n);
		abilities = new ArrayList<Ability>();
		max_health_points = max_hp;
		health_points = max_hp;
		max_mana_points = max_mp;
		mana_points = max_mp;
		attack = atk;
		magic = mag;
		defense = def;
		speed = spd;
		dead = false;
	}
	
	public ArrayList<Ability> get_abilities() {
		return abilities;
	}

	public int get_max_health_points() {
		return max_health_points;
	}

	public int get_health_points() {
		return health_points;
	}

	public int get_attack() {
		return attack;
	}

	public int get_magic() {
		return magic;
	}

	public int get_defense() {
		return defense;
	}

	public int get_speed() {
		return speed;
	}

	public void take_damages(int damages) {
		health_points -= damages;
		if (health_points <= 0)
			die();
	}
	
	public void attack(FightableCharacter c) {
		int dmgs = attack * 2 - defense * 2;
		System.out.println(name + " attacks " + c.name + ".\n"
				+ c.name + " loses " + dmgs + "HP.\n");
		c.take_damages(dmgs);
	}
	
	public void recover(int heal) {
		health_points += heal;
		if (health_points > max_health_points)
			health_points = max_health_points;
	}
	
	public boolean heal(FightableCharacter fc) {
		return false;
	}
	
	public void learn_ability(Ability a) {
		abilities.add(a);
	}
	
	public void use_ability(FightableCharacter fc) {
		for (int i = 0; i < abilities.size(); ++i)
			System.out.println(i + 1 + ". " + abilities.get(i));
	}
	
	public void die() {
		health_points = 0;
		System.out.println(name + " is dead.");
	}
	
	public boolean isDead() {
		return dead;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + health_points + "/" + max_health_points + "HP\n" +
				"Attack: " + attack + " | " + "Magic: " + magic + "\n" +
				"Defense: " + defense + " | " + "Speed: " + speed;
	}
}
