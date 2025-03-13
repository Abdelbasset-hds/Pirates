package modele;
import controleur.GestionCarte;

public class Pirate {
	
	private String nom;
	private Pirate adversaire;
	private int pointVie = 5;
	private int popularite;
	private Carte [] main;
	private int compteur = 0;
	
	public Pirate(String nom) {
		this.nom = nom;
		this.main = new CartePopularite[5];
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getPopularite() {
		return popularite;
	}
	
	public void setAdversaire(Pirate adversaire) {
		this.adversaire = adversaire;
	}
	
	public void detaille() {
		System.out.println("- PointVie : " + pointVie +"  - Popularité : " + popularite);
	}
	
	public void afficherMain() {
		for(int i=0;i<compteur;i++) {
			System.out.println("- carte "+(i+1)+" : "+main[i].getNom());
		}
	}

	public boolean aGagne() {
		return popularite >= 5;
	}
	
	public void ajouterCarte() {
        if (compteur < main.length) {
            main[compteur] = GestionCarte.piocher();
            System.out.println(nom + " pioche une carte : " + main[compteur].getNom());
            compteur++;
        } else {
            System.out.println(nom + " a déjà une main complète !");
        }
    }
	
	public Carte trouverCarte(String cartejouer) {
		for(int i=0;i<compteur;i++) {
			if(main[i] != null && main[i].getNom().equalsIgnoreCase(cartejouer)){
				return main[i];
			}
		}
		return null;
	}
	
	public void reduireVie(int pointVie) {
		pointVie -= cartePopul.getValeurVie();
	}
	
	public void jouerCarte(String cartejouer) {
		Carte carte = trouverCarte(cartejouer);
		if(carte != null && carte instanceof CartePopularite) {
			CartePopularite cartePopul = (CartePopularite) carte;
		    popularite += cartePopul.getValeurPopularite();
		    adversaire.reduireVie(cartePopul.getValeurVie());
		    
			
		System.out.println(nom + " joue une carte de popularite de valeur popularite " + cartePopul.getValeurPopularite() + " et de valeur vie : "+ cartePopul.getValeurVie());
		retirerCarte(cartePopul);
		}
		else {
			System.out.println(nom + " ne poccede pas de cette carte");
		}
		
		}
	
	private void retirerCarte(Carte carte) {
	    for (int i = 0; i < compteur; i++) {
	        if (main[i] == carte) {
	            for (int j = i; j < compteur - 1; j++) {
	                main[j] = main[j + 1];
	            }
	            main[compteur - 1] = null; 
	            compteur--;
	            break;
	        }
	    }
	}

}
