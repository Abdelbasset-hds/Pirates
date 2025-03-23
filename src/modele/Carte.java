package modele;

public abstract class Carte {
	
	protected String nom;
	private String description;
	private Cardtype type;
	private int cout; 
	
	public Carte(String nom,String description,Cardtype type,int cout) {
		this.nom = nom;
		this.description = description;
		this.type = type;
		this.cout = cout;
	}
	
	public int getCout() {
		return cout;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Cardtype getType() {
		return type;
	}
	
	public abstract void jouerCarte(Pirate actif,Pirate cible);
	

}
