package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] tabEquipement = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert force>=0;
	}

	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "< "+ texte + " >");
	}	

	private String prendreParole() {
		return "Le romain " + nom + ":" ;
	}
	
	public void recevoirCoup(int forceCoup) {
		assert forceCoup>=0;
		// forceCoup doit être positif
		
		int forceInitiale=force;
		force -= forceCoup;
		if (force>0) {
			parler("Aie");
		} else {
			parler("J'abandonne..");
		}
		assert forceInitiale>force;
		// la force du romain doit diminuée sinon erreur
		
	}
	public void ajoutEquipement(Equipement equip) {
		tabEquipement[nbEquipement]=equip;
		nbEquipement++;
		System.out.println("Le soldat "+getNom()+" s'équipe avec un "+equip);
	}
	
	
	public void sEquiper (Equipement equip) {
		switch (nbEquipement) {
		case 2 :
			System.out.println("Le soldat "+getNom()+" est déjà bien protégé !");
		case 1 :
			if (tabEquipement[0]==equip){
				System.out.println("Le soldat "+getNom()+" possède déjà un"+equip);
			}
			else {
				ajoutEquipement(equip);
			}
		case 0 :
			ajoutEquipement(equip);
	}
	}
	
	public static void main(String[] args) {
		
		Romain Minus = new Romain("Minus", 6);
		System.out.println(Equipement.CASQUE);
		for (int i=0;i<2;i++) {
		Minus.sEquiper(Equipement.CASQUE);
	}
		Minus.sEquiper(Equipement.BOUCLIER);
		Minus.sEquiper(Equipement.CASQUE);
	
	
}
}
