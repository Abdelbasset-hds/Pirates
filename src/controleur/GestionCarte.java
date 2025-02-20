package controleur;

import java.util.Random;

import modele.CartePopularite;

public class GestionCarte {

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
