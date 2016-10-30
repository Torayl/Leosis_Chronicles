package characters;

import java.util.ArrayList;

import items.Item;

public class Team {
	private ArrayList<Hero> heroes;
	private ArrayList<Item> inventory;
	private int gold;
	private int defeated_monsters;
	private int gold_looted;
	
	public Team(ArrayList<Hero> h) {
		heroes = h;
		inventory = new ArrayList<Item>();
		gold = 0;
		defeated_monsters = 0;
		gold_looted = 0;
	}
	
	public void add_hero(Hero h) {
		heroes.add(h);
	}
	
	public void remove_hero(Hero h) {
		if (heroes.contains(h))
			heroes.remove(h);
	}
	
	public Hero get_hero(int i) {
		return heroes.get(i);
	}
	
	public void add_xp(int xp) {
		for (Hero h : heroes)
			h.earn_xp(xp);
	}
	
	public void add_gold(int g) {
		gold += g;
		gold_looted += g;
	}
	
	public void remove_gold(int g) {
		if (gold - g >= 0)
			gold -= g;
	}
	
	public int get_gold() {
		return gold;
	}
	
	public int nb_heros_vivants() {
		int i = 0;
		for (Hero h : heroes)
			if (!h.isDead())
				++i;
		return i;
	}
	
	public String stats() {
		return "Defeated monsters: " + defeated_monsters + "\n" +
				"Gold looted: " + gold_looted;
	}
	
	public String toString() {
		String s = "";
		for (Hero h : heroes)
			s += h;
		return s;
	}
}