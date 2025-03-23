package modele;
import java.util.Random;

public class CartePopularite extends Carte{
	
	private int valeur_popularite;

	
	public CartePopularite(String nom,String description,int valeur_popularite,int cout) {
		super(nom,description,Cardtype.POPULARITE,cout);
		this.valeur_popularite = valeur_popularite;
		
	}
	
	
	
	public int getValeurPopularite() {
		return valeur_popularite;
	}
	
	@Override
	public void jouerCarte(Pirate actif,Pirate cible) {
		actif.effetAttaque(getCout());
		actif.effetPopularite(valeur_popularite);
	};
	

}
