package fight;

import java.util.Scanner;

import characters.Hero;
import characters.Monster;
import characters.Team;

public abstract class Fight {
	protected Team heroes;
	protected Monster[] enemies;
	
	public void fight() {
		Scanner sc = new Scanner(System.in);
		int action;
		boolean fuite = false;
		int n;
		message_apparition();
		while (!fuite && enemies.length > 0 && heroes.nb_heros_vivants() > 0) {
			System.out.println(heroes +
					"Que voulez-vous faire ?\n" +
					"1.Attaquer 2.Special\n" +
					"3.Objets 4.Fuir\n");
			action = sc.nextInt();
			if (action == 1)
				attack();
			else if (action == 2)
				special();
			else if (action == 3)
				items();
			else if (action == 4)
				fuite = true;
			for (int i = 0; i < enemies.length; ++i)
				enemies[n].attack(heroes.get(0));
		}
		if (enemies.length == 0) {
			int xp = 0;
			for (int i = 0; i < enemies.length; ++i)
				xp += enemies[i].xp;
			System.out.println("L'equipe a gagné " + xp + " points d'experience.");
			heroes.add_xp(xp);
			System.out.println("Vous trouvez un coffre.\n"
					+ "Il contient " + g.argent + " Luvens");
			heroes.earn_gold(g);
		}
		else if (heroes.nb_heros_vivants() == 0) {
			System.out.println("L'equipe a perdu.");
			heroes.spend_gold(g);
		}
		else if (fuite == true)
			System.out.println("Vous avez fui le combat.");
		System.out.println("Fin du combat.");
		sc.close();
	}

	public void message_apparition() {
		for (int i = 0; i < enemies.length; ++i) {
			System.out.println(enemies[i]);
			if (enemies.length > 1 && i != enemies.length - 1)
				System.out.println(", ");
		}
		if (enemies.length > 1)
			System.out.println(" apparaissent.\n");
		else
			System.out.println(" apparait.\n");
	}

	public void attack() {
		Scanner sc = new Scanner(System.in);
		int action;
		System.out.println("Qui voulez-vous attaquer ?\n");
		for (int i = 0; i < enemies.length; ++i) {
			System.out.println(i + 1 + "." + enemies[i] + " ");
			if (i % 2 == 1)
				System.out.println();
		}
		action = sc.nextInt();
		heroes.get(0).attack(enemies[action - 1]);
		sc.close();
	}

	void special() {
		int action;
		System.out.println("Quelle competence voulez-vous utiliser ?");
		int n = 0;
		while (n < e.heros[i].nb_competences) {
			System.out.println(n + 1 + "." + e.heros[i].competence[n].nom);
			if (n % 2 == 0)
				cout << endl;
			n += 1;
		}
		cin >> action;
		t_competence competence;
		competence = e.heros[i].competence[action - 1];
		if (competence.effet == "Soin") {
			cout << "Qui voulez-vous soigner ?" << endl;
			afficher_etat(e);
			cin >> action;
			if (e.heros[action - 1].vie == e.heros[action - 1].vie_max)
				cout << e.heros[action - 1].nom << " est deja en pleine sante." << endl;
			else if (e.heros[action - 1].vie < e.heros[action - 1].vie_max) {
				unsigned int vie_recuperee_max;
				vie_recuperee_max = e.heros[action - 1].vie_max - e.heros[action - 1].vie;
				e.heros[action - 1].vie += competence.puissance;
				if (e.heros[action - 1].vie > e.heros[action - 1].vie_max) {
					cout << e.heros[action - 1].nom << " recupere " << vie_recuperee_max << " PV." << endl;
					e.heros[action - 1].vie = e.heros[action - 1].vie_max;
				}
				else
					cout << e.heros[action - 1].nom << " recupere " << competence.puissance << " PV." << endl;
			}
			cout << action << "." << e.heros[action - 1].nom << " : " << e.heros[action - 1].vie << "/" << e.heros[action - 1].vie_max << " PV" << endl;
		}
	}

	public void items() {
		Scanner sc = new Scanner(System.in);
		int action;
		System.out.println("Quel objet voulez-vous utiliser ?");
		heroes.inventory();
		action = sc.nextInt();
		Item i = heroes.inventaire.get(action - 1);
		if (i.effet() == "Soin") {
			System.out.println("Qui voulez-vous soigner ?\n +"
					+ heroes);
			action = sc.nextInt();
			if (e.heros[action - 1].vie == e.heros[action - 1].vie_max)
				cout << e.heros[action - 1].nom << " est déjà en pleine santé." << endl;
			else if (e.heros[action - 1].vie < e.heros[action - 1].vie_max) {
				unsigned int vie_recuperee_max;
				vie_recuperee_max = e.heros[action - 1].vie_max - e.heros[action - 1].vie;
				e.heros[action - 1].vie += objet.puissance;
				if (e.heros[action - 1].vie > e.heros[action - 1].vie_max) {
					cout << e.heros[action - 1].nom << " récupère " << vie_recuperee_max << " PV." << endl;
					e.heros[action - 1].vie = e.heros[action - 1].vie_max;
				}
				else
					cout << e.heros[action - 1].nom << " récupère " << objet.puissance << " PV." << endl;
			}
			cout << action << "." << e.heros[action - 1].nom << " : " << e.heros[action - 1].vie << "/" << e.heros[action - 1].vie_max << " PV" << endl;
		}
	}
}