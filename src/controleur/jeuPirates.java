package controleur;

import modele.Pirate;
import modele.CartePopularite;

public class jeuPirates {

	public static void main(String[] args) {
		Pirate jack = new Pirate("Jack le Borgne");
        Pirate bill = new Pirate("Bill Jambe-de-Bois");

        for (int i = 0; i < 4; i++) {
            jack.ajouterCarte();
            bill.ajouterCarte();
        }
        
        jack.ajouterCarte();
    
        

        if (jack.aGagne()) {
            System.out.println(jack.getNom() + " est le nouveau capitaine !");
        } else if (bill.aGagne()) {
            System.out.println(bill.getNom() + " est le nouveau capitaine !");
        }

	}

}
