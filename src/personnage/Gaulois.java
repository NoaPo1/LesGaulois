package personnage;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void setEffetPotion(int effetPotion) {
		this.effetPotion = effetPotion;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<" + texte + ">");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		this.force = this.force * this.effetPotion;
		romain.recevoirCoup(force / 3);
	}
	
	public void boirPotion(int potion) {
		this.parler("Merci Druide, je sens que ma force est " +potion+ " fois décuplée. »");
		this.setEffetPotion(potion);
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("asterix", 8);
		Gaulois obélix = new Gaulois("Obélix",10);
		Romain DUDU = new Romain("DUDU", 7);
		Druide Pano = new Druide("Pano",5,10);
		asterix.parler("bonjour");
		Pano.boost(asterix);
		Pano.boost(obélix);
		asterix.frapper(DUDU);
	}

}
