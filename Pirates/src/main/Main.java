package main;

import controleur.Controleur;
import modele.Regle;
import affichage.AffichageConsole;

public class Main {
    public static void main(String[] args) {
        Regle modele = new Regle();
        AffichageConsole vue = new AffichageConsole();
        Controleur controleur = new Controleur(modele, vue);
        controleur.lancerJeu();
    }
}
