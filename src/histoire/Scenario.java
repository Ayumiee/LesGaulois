package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;

public class Scenario {

	public static void main(String[] args) {
		Druide panoramix = new Druide ("Panoramix",5,10,1);
		Gaulois obelix = new Gaulois("Obelix", 8);
		Gaulois asterix = new Gaulois("Asterix", 8);
		Romain minus = new Romain("Minus", 6);
		panoramix.parler("Je vais aller preparer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Beleanos, ce n'est pas juste!");
		panoramix.booster(asterix);
		asterix.parler("Bonjour");
		minus.parler("UN GAU..UN GAUGAU...");
		for (int i=0;i<3;i++) {
			asterix.frapper(minus);
		}

	}
	
}