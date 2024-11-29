package personnage;
import java.util.Random; 
public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		this.forcePotion = 1 ;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " � "
				+ effetPotionMax + ".");
	}
	
	public int preparerPotion() {
		Random potion = new Random();
		int potioneffect = potion.nextInt(this.effetPotionMax);
		potioneffect += 1 ;
		if (potioneffect > 7) {
			this.parler("J'ai préparé\r\n"
					+ "une super potion de force " + potioneffect);
			return potioneffect;
		}
		else {
			this.parler(" Je n'ai pas trouvé tous les ingrédients, ma potion est\r\n"
					+ "seulement de force "+ potioneffect);
			return potioneffect;
		}
		
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "< " + texte + ">");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void boost(Gaulois npc) {
		int bosst = this.preparerPotion();
		if ("Obélix".equals(npc.getNom()))
			this.parler("« Non, Obélix !... Tu n'auras pas de potion magique !");
		else
			npc.boirPotion(bosst);
		
		
	}

}
