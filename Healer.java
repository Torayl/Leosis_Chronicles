package characters;

import java.util.ArrayList;
import java.util.Random;

import abilities.*;

public final class Healer extends Hero {

	public Healer(String n, int lvl, int max_hp, int atk, int mag, int def, int spd) {
		super(n, lvl, max_hp, atk, mag, def, spd);
		learn_ability(new Blessing());
	}
	
	@Override
	public final boolean heal(FightableCharacter fc) {
		if (fc.health_points < fc.max_health_points) {
			Random r = new Random();
			int heal = (int) (magic * 2 * (1 + r.nextFloat() / 4));
			if (heal > fc.max_health_points - fc.health_points)
				heal = fc.max_health_points - fc.health_points;
			System.out.println(name + " heals " + fc.name + ".\n"
					+ fc.name + " recovers " + heal + "HP.\n");
			fc.recover(heal);
			return true;
		} else {
			System.out.println(fc.name + "is full.\n");
			return false;
		}
	}
}