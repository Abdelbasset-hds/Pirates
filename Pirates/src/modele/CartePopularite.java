package modele;
import java.util.Random;

public class CartePopularite extends Carte{
	
	private int valeur_popularite;
	private int cout;
	
	public CartePopularite(String nom,String description,int valeur_popularite,int cout) {
		super(nom,description,Cardtype.POPULARITE);
		this.valeur_popularite = valeur_popularite;
		this.cout = cout;
	}
	
	public int getCout() {
		return cout;
	}
	
	public int getValeurPopularite() {
		return valeur_popularite;
	}
	
	@Override
	public void jouerCarte(Pirate actif,Pirate cible) {
		actif.effetAttaque(cout);
		actif.effetPopularite(valeur_popularite);
	};
	

}
