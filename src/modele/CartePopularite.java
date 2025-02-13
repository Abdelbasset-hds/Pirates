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
	
	public static CartePopularite[] CARTES_DISPONIBLES = {
	
	new CartePopularite("Discours Inspirant",1,0),
	new CartePopularite("Main de Fer",2,-1),
	new CartePopularite("Révolte organisée",1,0),
    new CartePopularite("Coup de sabre",0,-2),
	new CartePopularite("Abordage Réussi",2,0),
	
	};
	
	private static final Random RANDOM = new Random();
	
	public static CartePopularite piocher() {
        int index = RANDOM.nextInt(CARTES_DISPONIBLES.length);
        return CARTES_DISPONIBLES[index];
    }
	

}
