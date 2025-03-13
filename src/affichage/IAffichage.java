package affichage;


public interface IAffichage {
    void afficherAccueil();
    void afficherDebutJeu(String nomJoueur1, String nomJoueur2);
    void afficherEtatJeu(String[] joueur1, String[] joueur2, String[][] zonePopularite1, String[][] zonePopularite2, String[] zoneAttaque);
    void afficherTourActuel(String nomJoueur);
    void afficherCartePiochee(String[] carte);
    void afficherCarteMain(String[] carte, int index);
    int obtenirChoixCarte();
    void afficherErreurChoix();
    void afficherVainqueur(String nom);
}

