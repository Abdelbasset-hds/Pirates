package affichage;

import java.util.Scanner;

public class AffichageConsole implements IAffichage {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void afficherAccueil() {
        System.out.println("----------- Bienvenue a bord du l'egendaire navire pirate : LE SANGUINAIRE ! -------------");
        System.out.println("Deux redoutables flibustiers, Jack le Borgne et Bill Jambe-de-Bois, s'affrontent...");
        System.out.println("Ils convoitent tous deux le poste de capitaine, mais un seul pourra commander l'equipage !");
        System.out.println("Les regles sont simples : Popularite ou Domination ? Qui saura convaincre l'equipage ?");
        System.out.println("-------------- Preparez-vous pour une bataille sans merci ! --------------");
    }


    @Override
    public void afficherDebutJeu(String nomJoueur1, String nomJoueur2) {
        System.out.println("-------------------- Le duel des capitaines commence ! ----------------------------------------");
        System.out.println("                          "+ nomJoueur1 + " contre " + nomJoueur2 );
        System.out.println("-----------------------------------------------------------------------------------------------");
    }


    @Override
    public void afficherEtatJeu(String[] joueur1, String[] joueur2, String[][] zonePopularite1, String[][] zonePopularite2, String[] zoneAttaque) {
        System.out.println("\n---------------- etat actuel du duel ----------------------");
        
        // Affichage des joueurs
        System.out.println("Pirate " + joueur1[0] + "     | vie : " + joueur1[1] + " PV | a " + joueur1[2] + " Popularite");
        System.out.println("Pirate " + joueur2[0] + "     | vie  " + joueur2[1] + " PV | a " + joueur2[2] + " Popularite");
        
        System.out.println("---------------------------------------- etat ----------------------------------------------- \n");

        // Affichage des zones de popularité
        System.out.println("------------------ Zone de Popularite de " + joueur1[0] + " :----------------------------------");
        afficherCartes(zonePopularite1);
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("------------------ Zone de Popularite de " + joueur2[0] + " :----------------------------------");
        afficherCartes(zonePopularite2);
        System.out.println("-----------------------------------------------------------------------------------------------" );
        // Affichage de la zone d'attaque
        System.out.println("------------------ Zone d'Attaque Actuelle :----------------------------------------------------");
        if (zoneAttaque != null && zoneAttaque.length > 0 && !zoneAttaque[0].equals("Aucune carte")) {
            System.out.println("-" + zoneAttaque[0] + " : " + zoneAttaque[1] + " Degat : " + zoneAttaque[2] );
        } else {
            System.out.println("- Aucun coup n'est en preparation...");
        }

        System.out.println("=================================================================================================\n");
    }
    
    private void afficherCartes(String[][] cartes) {
        if (cartes != null && cartes.length > 0) {
            for (String[] carte : cartes) {
                System.out.println("- " + carte[0] + " : " + carte[1] + " (Effet : " + carte[2] + ")");
            }
        } else {
            System.out.println("- Aucune carte disponible.");
        }
    }


    @Override
    public void afficherTourActuel(String nomJoueur) {
        System.out.println(" C'est au tour de " + nomJoueur + " de jouer !");
    }


    @Override
    public void afficherCartePiochee(String[] carte) {
        System.out.println("---------------------- Une nouvelle carte a ete piochee...------------------------------------");
        System.out.println(carte[0] + " - " + carte[1]);
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("Une opportunite... ou un piege ? ");
    }


    @Override
    public void afficherCarteMain(String[] carte, int index) {
        if (carte != null) {
            // Construire la ligne d'affichage en fonction du type de carte
            String ligneCarte = index + " - " + carte[0] + " | " + carte[1] + " | " + carte[2];

            if (carte.length > 3 && carte[3] != null && !carte[3].isEmpty()) {
                ligneCarte += " | " + carte[3]; // Popularité ou Dégâts
            }
            if (carte.length > 4 && carte[4] != null && !carte[4].isEmpty() && !carte[4].equals("Cost : 0")) {
                ligneCarte += " | " + carte[4]; // Coût (ignoré si c'est une carte d'attaque)
            }

            System.out.println(ligneCarte); // Afficher la ligne formatée
        }
    }
    
    @Override
    public int obtenirChoixCarte() {
        System.out.print("\n C'est l'heure du choix... Quelle carte vas-tu jouer ? (1-5) : ");
        return scanner.nextInt();
    }


    @Override
    public void afficherErreurChoix() {
        System.out.println(" Mauvais choix, moussaillon ! Essaie encore avant de finir à la planche ! ");
    }


    @Override
    public void afficherVainqueur(String nom) {
        System.out.println(nom + " a conquis l'equipage et devient le nouveau CAPITAINE du Sanguinaire !");
        System.out.println("Les tonneaux de rhum s’ouvrent, l'equipage acclame son chef !");
        System.out.println("Mais la mer est perfide... Cette victoire ne sera peut-etre pas eternelle !");
    }

}
