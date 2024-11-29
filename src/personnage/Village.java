package personnage;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
    private int nbVillageois;

	
    public Village(String nom, int nbVillageoisMaximum) {
        this.nom = nom;
        this.villageois = new Gaulois[nbVillageoisMaximum];
        this.nbVillageois = 0;
    }
	
	
	public String getNom() {
	return nom;
	}
	

	public void setChef(Chef chef) {
		this.chef = chef;
	}

    public void ajouterHabitant(Gaulois gaulois) {
        if (nbVillageois < villageois.length) {
            villageois[nbVillageois] = gaulois;
            nbVillageois++;
        } else {
            System.out.println("Le village est déjà plein !");
        }
    }
    
    public Gaulois trouverHabitant(int numero) {
        if (numero >= 0 && numero < nbVillageois) {
            return villageois[numero];
        } else {
            throw new IndexOutOfBoundsException("Numéro d'habitant invalide.");
        }
    }
    
    public void afficherVillageois() {
        System.out.println("Chef du village : " + (chef != null ? chef.getNom() : "Aucun"));
        System.out.println("Liste des villageois :");
        for (int i = 0; i < nbVillageois; i++) {
            System.out.println("- " + villageois[i].getNom());
        }
    }

}
