package modele;

public class Pirate {
	
	private String nom;
	private int pointVie = 5;
	private int popularite;
	private Carte [] main;
	private int compteur = 0;
	
	public Pirate(String nom) {
		this.nom = nom;
		this.main = new CartePopularite[5];
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getPopularite() {
		return popularite;
	}

	public boolean aGagne() {
		return popularite >= 5;
	}
	
	public void ajouterCarte() {
        if (compteur < main.length) {
            main[compteur] = CartePopularite.piocher();
            System.out.println(nom + " pioche une carte : " + main[compteur].getNom());
            compteur++;
        } else {
            System.out.println(nom + " a déjà une main complète !");
        }
    }
	
	public void jouerCarte(CartePopularite carte) {
		popularite += carte.getValeurPopularite();
		pointVie -= carte.getValeurVie();
		System.out.println(nom + " jour une carte de popularite de valeur popularite " + carte.getValeurPopularite() + " et de valeur vie : "+ carte.getValeurVie());
	}

}
