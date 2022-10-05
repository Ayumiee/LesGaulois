package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	public int forcePotion=1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax, int forcePotion) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		this.forcePotion = forcePotion;
		parler("Bonjour, je suis le Druide " + nom + " et ma potion peut aller d'une force " + 
		effetPotionMin + " à " + effetPotionMax +"." );
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "< "+ texte + " >");
	}	

	private String prendreParole() {
		return "Le druide " + nom + ":" ;
	}
	
	public void preparerPotion() {
		Random random = new Random();
		forcePotion = random.nextInt(effetPotionMin,effetPotionMax+1);
		if (forcePotion>(int)((effetPotionMin+effetPotionMax)/2)) {
			parler("J'ai préparé une super potion de force " + forcePotion);
			} 
		else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force "
					+ forcePotion);	
			}
		
		}
	
	public void booster(Gaulois gaulois) {
		if (this.nom != "Obélix") {
			gaulois.boirePotion(forcePotion);
		}
		else {
			parler("Non, Obélix !... Tu n'auras pas de potion magique!");
		}
		
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",5,10,1);
		panoramix.preparerPotion();
		Gaulois asterix = new Gaulois("Asterix",8);
		panoramix.booster(asterix);
	}
	
	}
