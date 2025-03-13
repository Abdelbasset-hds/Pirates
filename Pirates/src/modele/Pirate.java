package modele;

public class Pirate {
	
	private String nom;
    private int pointVie = 5;
    private int popularite;
    private Carte[] main;
    private int compteur = 0;
    private Carte[] zonePopularite; // Nouveau : zone de popularité
    private int compteurPopularite = 0; // Nouveau : compteur pour la zone de popularité

    public Pirate(String nom) {
        this.nom = nom;
        this.main = new Carte[5];
        this.zonePopularite = new Carte[20]; // Taille maximale de la zone de popularité
    }
	
    public void ajouterCartePopularite(Carte carte) {
        if (compteurPopularite < zonePopularite.length) {
            zonePopularite[compteurPopularite] = carte;
            compteurPopularite++;
        } else {
            System.out.println("La zone de popularité est pleine, impossible d'ajouter une nouvelle carte.");
        }
    }
	
	public String getNom() {
		return nom;
	}
	
	public Carte[] getZonePopularite() {
        Carte[] cartesActuelles = new Carte[compteurPopularite];
        System.arraycopy(zonePopularite, 0, cartesActuelles, 0, compteurPopularite);
        return cartesActuelles;
    }
	
	public int getVie() {
		return pointVie;
	}
	
	public int getPopularite() {
		return popularite;
	}
	

	public Carte getCarte(int index) {
        if (index >= 0 && index < main.length) {
            return main[index];
        } else {
            throw new IndexOutOfBoundsException("Index invalide pour la main du joueur.");
        }
    }
	
	public Carte[] getMain() {
	    Carte[] cartesActuelles = new Carte[compteur]; // Créer un tableau de la taille des cartes possédées
	    for (int i = 0; i < compteur; i++) {
	        cartesActuelles[i] = main[i]; // Copier uniquement les cartes valides
	    }
	    return cartesActuelles;
	}
	
	public int getNombreCartes() {
        return main.length;
    }
	
	public boolean aGagne() {
		return popularite >= 5;
	}
	
	public void ajouterCarte(Carte carte) {
        if (compteur < main.length) {
            main[compteur] = carte;
            compteur++;
        }}
	
	public Carte trouverCarte(int index) {
		if (index >= 0 && index < compteur) {
			return main[index];
		}
		return null;
	}
	
	public void effetAttaque(int cout) {
		pointVie -= cout;
		if(pointVie<0) {
			pointVie=0;
		}
		
	}
	
	public void effetPopularite(int popularite) {
		this.popularite += popularite;
	}
	
	public CartePopularite[] getCartePopularite() {
        int count = 0;
        for (Carte carte : main) {
            if (carte instanceof CartePopularite) {
                count++;
            }
        }

        CartePopularite[] cartesPopularite = new CartePopularite[count];
        int index = 0;
        for (Carte carte : main) {
            if (carte instanceof CartePopularite) {
                cartesPopularite[index++] = (CartePopularite) carte;
            }
        }

        return cartesPopularite;
    }
	
	
	public void retirerCarte(Carte carte) {
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
