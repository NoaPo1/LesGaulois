package personnage;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
    private int nbEquipement;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
	    this.nbEquipement = 0;
	    assert isInvariantVerified();
		
	}
	
    private boolean isInvariantVerified() {
        return force > 0;
    }


	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<" + texte + ">");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		assert isInvariantVerified();
		if (force > 0) {
			parler("aaaa");
		} else {
			parler("J'abandonne...");
		}
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
            case 2:
                System.out.println("Le soldat " + nom + " est déjà bien protégé !");
                break;
            case 1:
                if (equipements[0] == equipement) {
                    System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
                } else {
                    equipements[nbEquipement++] = equipement;
                    System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
                }
                break;
            case 0:
                equipements[nbEquipement++] = equipement;
                System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
                break;
            default:
                throw new IllegalStateException("Nombre d'équipements invalide : " + nbEquipement);
        }
    }
}
	

