package modele;

public class Pirate {
	
	private String nom;
	private int pointVie = 5;
	private int popularite;
	private Carte [] main;
	private int conteur = 0;
	
	public Pirate(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getPopularite() {
		return popularite;
	}
	
	public void ajouterCarte(Carte carte) {
		main[conteur]=carte;
		conteur = 0;
	}
	
	public boolean aGagne() {
		return popularite >= 5;
	}
	
	public void jouerCarte(CartePopularite carte) {
		popularite += carte.getValeur();
		System.out.println(nom + " jour une carte de popularite de valeur " + carte.getValeur());
	}

}
