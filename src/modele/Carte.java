package modele;

public abstract class Carte {
	
	protected String nom;
	
	public Carte(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}

}
