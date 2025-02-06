package modele;

public class CartePopularite extends Carte{
	
	private int valeur;
	
	public CartePopularite(String nom,int valeur) {
		super(nom);
		this.valeur = valeur;
	}
	
	public int getValeur() {
		return valeur;
	}

}
