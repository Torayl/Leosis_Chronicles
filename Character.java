package characters;

public abstract class Character {
	String name;
	
	public Character() {
		this("NO_NAME");
	}
	
	public Character(String n) {
		name = n;
	}
	
	public String get_name() {
		return name;
	}
	
	public String toString() {
		return name;
	}
}