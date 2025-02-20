package modele;
import java.util.Random;

public class CartePopularite extends Carte{
	
	private int valeur_popularite;
	private int valeur_vie;
	
	public CartePopularite(String nom,int valeur_popularite,int valeur_vie) {
		super(nom);
		this.valeur_popularite = valeur_popularite;
		this.valeur_vie = valeur_vie;
	}
	
	public int getValeurVie() {
		return valeur_vie;
	}
	
	public int getValeurPopularite() {
		return valeur_popularite;
	}
	
	
	

}
