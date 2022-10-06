package personnages;

import personnages.Chef;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois[] villageois;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois]=gaulois;
		nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int numVillageois) {
		return villageois[numVillageois-1];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "+chef.getNom()+" vivent les légendaires gaulois :");
		int i;
		for(i=0;i<nbVillageois;i++) {
			System.out.println(villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irreductible",30);
		
//		Gaulois gaulois = village.trouverHabitant(30);
		
//		Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 30
//		at personnages.Village.trouverHabitant(Village.java:29)
//		at personnages.Village.main(Village.java:34)
		
		Chef abraracourcix = new Chef("Abraracourcix", 6 , village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois ("Asterix",8);
		village.ajouterHabitant(asterix);
		Gaulois obelix = new Gaulois ("Obelix",10);
		village.ajouterHabitant(obelix);
		
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		
//		Affiche l'habitant 1
		
		village.afficherVillageois();
		
	}
	
	
}


