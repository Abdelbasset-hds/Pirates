package controleur;

import modele.Pirate;
import modele.CartePopularite;

public class jeuPirates {

	public static void main(String[] args) {
		Pirate jack = new Pirate("Jack le Borgne");
        Pirate bill = new Pirate("Bill Jambe-de-Bois");

        CartePopularite carte1 = new CartePopularite("Discours Inspirant", 1);
        CartePopularite carte2 = new CartePopularite("Main de Fer", 2);

        jack.jouerCarte(carte1);
        bill.jouerCarte(carte2);

        if (jack.aGagne()) {
            System.out.println(jack.getNom() + " est le nouveau capitaine !");
        } else if (bill.aGagne()) {
            System.out.println(bill.getNom() + " est le nouveau capitaine !");
        }

	}

}
