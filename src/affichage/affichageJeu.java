package affichage;
import modele.Pirate;
import java.util.Scanner;

public class affichageJeu {

	public static void main(String[] args) {
		Pirate jack = new Pirate("Jack le Borgne");
        Pirate bill = new Pirate("Bill Jambe-de-Bois");

        for (int i = 0; i < 4; i++) {
            jack.ajouterCarte();
        }
        for (int i = 0; i < 4; i++) {
            bill.ajouterCarte();
        }
        
        Scanner scanner =new Scanner(System.in);
        
        while (true) {
        jack.ajouterCarte();
        jack.afficherMain();
        String cartejouer1 = scanner.nextLine();
        jack.jouerCarte(cartejouer1);
        bill.detaille();
        
        bill.ajouterCarte();
        jack.afficherMain();
        String cartejouer2 = scanner.nextLine();
        bill.jouerCarte(cartejouer2);
        jack.detaille();

        if (jack.aGagne()) {
            System.out.println(jack.getNom() + " est le nouveau capitaine !");
        } else if (bill.aGagne()) {
            System.out.println(bill.getNom() + " est le nouveau capitaine !");
        }
        
        }

	}

}
