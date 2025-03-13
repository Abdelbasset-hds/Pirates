package controleur;

import modele.*;
import affichage.AffichageConsole;

public class Controleur {
    private Regle modele;
    private AffichageConsole vue;

    public Controleur(Regle modele, AffichageConsole vue) {
        this.modele = modele;
        this.vue = vue;
    }

    public void lancerJeu() {
        vue.afficherAccueil();

        // Initialisation des joueurs avec des noms fixes
        modele.initialiserJoueurs();
        vue.afficherDebutJeu(modele.getActuel().getNom(), modele.getAdversaire().getNom());

        while (!modele.estTerminee()) {
            // Afficher l'état du jeu
            vue.afficherEtatJeu(
                creerEtatJoueurDTO(modele.getActuel()),
                creerEtatJoueurDTO(modele.getAdversaire()),
                creerZonePopulariteDTO(modele.getActuel()),
                creerZonePopulariteDTO(modele.getAdversaire()),
                creerZoneAttaqueDTO() // Afficher la zone d'attaque
            );

            // Afficher le tour actuel
            vue.afficherTourActuel(modele.getActuel().getNom());

            // Piocher une carte et l'afficher
            Carte cartePiochee = modele.piocher();
            modele.getActuel().ajouterCarte(cartePiochee);
            vue.afficherCartePiochee(creerCarteDTO(cartePiochee));

            // Afficher la main du joueur actuel
            String[][] mainDTO = creerMainDTO(modele.getActuel());
            for (int i = 0; i < mainDTO.length; i++) {
                vue.afficherCarteMain(mainDTO[i], i + 1);
            }

            // Demander le choix de la carte à jouer
            int choixCarte = vue.obtenirChoixCarte();
            while (choixCarte < 1 || choixCarte > 5) {
                vue.afficherErreurChoix();
                choixCarte = vue.obtenirChoixCarte();
            }

            // Jouer la carte choisie
            modele.jouerCarte(modele.getActuel(), modele.getAdversaire(), choixCarte - 1); // Index 0-based
            modele.changerDeJoueur();
        }

        // Afficher le vainqueur
        vue.afficherVainqueur(modele.getGagnant().getNom());
    }

    private String[] creerEtatJoueurDTO(Pirate joueur) {
        return new String[]{joueur.getNom(), String.valueOf(joueur.getVie()), String.valueOf(joueur.getPopularite())};
    }

    private String[][] creerCartesPopulariteDTO(Pirate joueur) {
        CartePopularite[] cartes = joueur.getCartePopularite();
        String[][] cartesDTO = new String[cartes.length][3];
        for (int i = 0; i < cartes.length; i++) {
            cartesDTO[i] = new String[]{cartes[i].getNom(), cartes[i].getDescription(), String.valueOf(cartes[i].getValeurPopularite())};
        }
        return cartesDTO;
    }

    private String[][] creerMainDTO(Pirate joueur) {
        Carte[] main = joueur.getMain();
        String[][] mainDTO = new String[main.length][5]; // 5 colonnes : type, nom, description, détails spécifiques, coût

        for (int i = 0; i < main.length; i++) {
            if (main[i] != null) {
                String[] detailsCarte = new String[5];
                detailsCarte[0] = (main[i] instanceof CartePopularite) ? "Carte de Popularité" : "Carte d'Attaque"; // Type de carte
                detailsCarte[1] = main[i].getNom(); // Nom de la carte
                detailsCarte[2] = main[i].getDescription(); // Description de la carte

                // Ajouter des détails spécifiques en fonction du type de carte
                if (main[i] instanceof CartePopularite) {
                    CartePopularite cartePop = (CartePopularite) main[i];
                    detailsCarte[3] = "Popularité : +" + cartePop.getValeurPopularite(); // Valeur de popularité
                    detailsCarte[4] = "Coût : " + cartePop.getCout(); // Coût de la carte
                } else if (main[i] instanceof CarteAttaque) {
                    CarteAttaque carteAttaque = (CarteAttaque) main[i];
                    detailsCarte[3] = "Dégâts : " + carteAttaque.getDegat(); // Dégâts de la carte
                    detailsCarte[4] = "Coût : " + carteAttaque.getCout(); // Coût de la carte (toujours 0)
                }

                mainDTO[i] = detailsCarte;
            }
        }
        return mainDTO;
    }

    private String[] creerCarteDTO(Carte carte) {
        if (carte == null) {
            return new String[]{"Aucune carte", "", "0"};
        }
        return new String[]{carte.getNom(), carte.getDescription(), "Effet inconnu"};
    }
    
    private String[][] creerZonePopulariteDTO(Pirate joueur) {
        Carte[] zonePopularite = joueur.getZonePopularite();
        String[][] zoneDTO = new String[zonePopularite.length][3];
        for (int i = 0; i < zonePopularite.length; i++) {
            if (zonePopularite[i] != null) {
                zoneDTO[i] = new String[]{
                    zonePopularite[i].getNom(),
                    zonePopularite[i].getDescription(),
                    String.valueOf(((CartePopularite) zonePopularite[i]).getValeurPopularite())
                };
            }
        }
        return zoneDTO;
    }
    private String[] creerZoneAttaqueDTO() {
        if (modele.getZoneAttaque() != null) {
            Carte carte = modele.getZoneAttaque();
            return new String[]{carte.getNom(), carte.getDescription(), String.valueOf(((CarteAttaque) carte).getDegat())};
        } else {
            return new String[]{"Aucune carte", "", "0"};
        }
    }
}
