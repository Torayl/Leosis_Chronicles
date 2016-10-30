package abilities;

import java.util.Random;

import characters.FightableCharacter;

public final class Heal implements Effect {
	private FightableCharacter user, target;
	
	public Heal(FightableCharacter u, FightableCharacter t) {
		user = u;
		target = t;
	}
	
	@Override
	public boolean use() {
		if (target.get_health_points() < target.get_max_health_points()) {
			Random r = new Random();
			int heal = (int) (user.get_magic() * 2 * (1 + r.nextFloat() / 4));
			if (heal > target.get_max_health_points() - target.get_health_points())
				heal = target.get_max_health_points() - target.get_health_points();
			System.out.println(user.get_name() + " heals " + target.get_name() + ".\n"
					+ target.get_name() + " recovers " + heal + "HP.\n");
			target.recover(heal);
			return true;
		} else {
			System.out.println(target.get_name() + "is full.\n");
			return false;
		}
	}
}
