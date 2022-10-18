package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] tabEquipement = new Equipement[2];
	private int nbEquipement = 0;
	private String texte;
	
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
	
	//ma fonction
//	public void recevoirCoup(int forceCoup) {
//		assert forceCoup>=0;
//		// forceCoup doit être positif
//		
//		int forceInitiale=force;
//		force -= forceCoup;
//		if (force>0) {
//			parler("Aie");
//		} else {
//			parler("J'abandonne..");
//		}
//		assert forceInitiale>force;
//		// la force du romain doit diminuée sinon erreur
//	}
	
	
//---------------------------- TP3
	 public Equipement[] recevoirCoup(int forceCoup) { 
		 Equipement[] equipementEjecte = null; 
		 // précondition 
		 assert force > 0; 
		 int oldForce = force; 
		 forceCoup = CalculResistanceEquipement(forceCoup); 
		 force -= forceCoup; 
		 //  if (force > 0) { 
		 //  parler("Aïe"); 
		 //  } else { 
		 //  equipementEjecte = ejecterEquipement(); 
		 //  parler("J'abandonne..."); 
		 //  } 
		 switch (force) { 
			 case 0: 
				 parler("Aïe");
			 default: 
				 equipementEjecte = ejecterEquipement(); 
				 parler("J'abandonne..."); 
				 break; 
		  } 
		 // post condition la force à diminuer 
		 assert force < oldForce; 
		 return equipementEjecte; 
		 
	} 
	 
	 

	 private int CalculResistanceEquipement(int forceCoup) { 
		 texte = "Ma force est  de " + this.force + ", et la force du coup est de " + forceCoup; 
		 int resistanceEquipement = 0; 
		 if (!(nbEquipement == 0)) { 
			 texte += "\nMais heureusement, grace à mon équipement sa force est diminué de "; 
			 
			 for (int i = 0; i < nbEquipement;) { 
				 
				 if ((tabEquipement[i] != null && tabEquipement[i].equals(Equipement.BOUCLIER)) == true) { 
					 resistanceEquipement += 8; 
				 } 
				 else { 
					 System.out.println("Equipement casque"); 
					 resistanceEquipement += 5; 
				 } 
				 i++; 
				 
			 } 
			 texte =+ resistanceEquipement + "!"; 
		 } 
		 parler(texte); 
		 forceCoup -= resistanceEquipement; 
		 return forceCoup; 
	} 
	
	 


	 private Equipement[] ejecterEquipement() { 
		 Equipement[] equipementEjecte = new Equipement[nbEquipement]; 
		 System.out.println("L'équipement  de  "  +  nom.toString()  +  " s'envole sous la force du coup."); 
		 //TODO 
		 int nbEquipementEjecte = 0; 
		 for (int i = 0; i < nbEquipement; i++) { 
	
			 if (tabEquipement[i] == null) { 
				 continue; 
			 } 
			 else { 
				 equipementEjecte[nbEquipementEjecte]  = 
						 tabEquipement[i]; 
				 nbEquipementEjecte++; 
				 tabEquipement[i] = null; 
			 }
		  } 
		  return equipementEjecte; 
	}
	
	//---------------------------------- fin TP3

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
		default :
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
