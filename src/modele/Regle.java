package modele;
import java.util.Random;


public class Regle {
        private static final Random RANDOM = new Random(); 
        private Pirate pirate1;
        private Pirate pirate2;
        private Pirate Actuel;
        private Pirate adversaire;
        private Carte zoneAttaque;

        private static final Carte[] CARTES_DISPONIBLES = {
            new CartePopularite("Discours Inspirant", "Boost de popularité", 1, 0),
            new CartePopularite("Main de Fer", "Leadership imposant", 2, 1),
            new CartePopularite("Révolte organisée", "Soutien du peuple", 1, 0),
            new CartePopularite("Abordage Réussi", "Gain de respect", 2, 0),
            new CarteAttaque("Coup de Canon", "Dégâts puissants", 3, 0),
            new CarteAttaque("Sabre Tranchant", "Attaque rapide", 2, 0)
        };

        private static final int COPIES_PAR_CARTE = 4;
        private static Carte[] paquet = new Carte[CARTES_DISPONIBLES.length * COPIES_PAR_CARTE];
        private static int indexPioche = 0; 

        // Remplissage et mélange du paquet au début du jeu
        static {
            initialiserPaquet();
            melangerPaquet();
        }

        private static void initialiserPaquet() {
            int index = 0;
            for (Carte carte : CARTES_DISPONIBLES) {
                for (int i = 0; i < COPIES_PAR_CARTE; i++) {
                    paquet[index++] = carte;
                }
            }
        }

        private static void melangerPaquet() {
            for (int i = paquet.length - 1; i > 0; i--) {
                int j = RANDOM.nextInt(i + 1);
                Carte temp = paquet[i];
                paquet[i] = paquet[j];
                paquet[j] = temp;
            }
        }

        public static Carte piocher() {
            if (indexPioche >= paquet.length) {
                System.out.println("Toutes les cartes ont été piochées, on remélange !");
                melangerPaquet();
                indexPioche = 0;
            }
            return paquet[indexPioche++];
        }


    public Pirate getPirate1() {
        return pirate1;
    }

    public Pirate getPirate2() {
        return pirate2;
    }

    public Pirate getActuel() {
        return Actuel;
    }

    public Pirate getAdversaire() {
        return adversaire;
    }

    public Carte getZoneAttaque() {
        return zoneAttaque;
    }

    /** Initialise les joueurs avec leurs noms et distribue les cartes initiales. */
    public void initialiserJoueurs() {
        String[] nomsPirates = {"Jack le Borgne    ", "Bill Jambe-de-Bois"};

        if (RANDOM.nextBoolean()) {
            pirate1 = new Pirate(nomsPirates[0]);
            pirate2 = new Pirate(nomsPirates[1]);
        } else {
            pirate1 = new Pirate(nomsPirates[1]);
            pirate2 = new Pirate(nomsPirates[0]);
        }

        // Choisir un joueur actuel au hasard
        if (RANDOM.nextBoolean()) {
            Actuel = pirate1;
            adversaire = pirate2;
        } else {
            Actuel = pirate2;
            adversaire = pirate1;
        }

        distribuerCartesInitiales();
    }


    /** Distribue 4 cartes Ã  chaque joueur au dÃ©but du jeu */
    private void distribuerCartesInitiales() {
        for (int i = 0; i < 4; i++) {
            pirate1.ajouterCarte(piocher());
            pirate2.ajouterCarte(piocher());
        }
    }
    
    public void jouerCarte(Pirate actif, Pirate adversaire, int index) {
        Carte carte = actif.getMain()[index]; // RÃ©cupÃ©rer la carte depuis la main

        if (carte != null) {
            if (carte instanceof CartePopularite) {
                // Si c'est une carte de popularitÃ©, l'ajouter Ã  la zone de popularitÃ©
                actif.ajouterCartePopularite(carte);
                carte.jouerCarte(actif, adversaire); // Appliquer l'effet de la carte
                zoneAttaque = null; // Vider la zone d'attaque
            } else if (carte instanceof CarteAttaque) {
                // Si c'est une carte d'attaque, l'ajouter Ã  la zone d'attaque
                zoneAttaque = carte;
                carte.jouerCarte(actif, adversaire); // Appliquer l'effet de la carte
            }

            // Retirer la carte de la main du joueur
            actif.retirerCarte(carte);
        } else {
            System.out.println(actif.getNom() + " ne possÃ¨de pas cette carte.");
        }
    }

    
    public void changerDeJoueur() {
        Pirate temp = Actuel;
        Actuel = adversaire;
        adversaire = temp;

        // Vider la zone d'attaque si le nouveau joueur actuel choisit une carte de popularitÃ©
        if (zoneAttaque != null && Actuel.getMain()[0] instanceof CartePopularite) {
            zoneAttaque = null;
        }
    }
    
    /** VÃ©rifie si le jeu est terminÃ©. */
    public boolean estTerminee() {
        return pirate1.aGagne() || pirate2.aGagne() || pirate1.getVie() <= 0 || pirate2.getVie() <= 0;
    }

    /** Renvoie le gagnant du jeu si la partie est terminÃ©e. */
    public Pirate getGagnant() {
        if (pirate1.aGagne()) {
            return pirate1;
        } else if (pirate2.aGagne()) {
            return pirate2;
        }
        if (pirate1.getVie() <= 0) {
            return pirate2;
        } else if (pirate2.getVie() <= 0) {
            return pirate1;
        }
        return null;
    }
}
