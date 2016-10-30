package game;

import java.util.ArrayList;

import abilities.*;
import characters.*;

public class Game {
	public static void main(String[] args) {
		ArrayList<Hero> team = new ArrayList<Hero>();
		Fireborn leosis = new Fireborn("Leosis", 1, 50, 10, 2, 8, 5);
		team.add(new Fireborn("Leosis", 1, 50, 10, 2, 8, 5));
		System.out.println(leosis);
		leosis.earn_xp(4000);
		System.out.println(leosis);
		leosis.learn_ability(new Blessing());
		leosis.use_ability(leosis);
	}
}