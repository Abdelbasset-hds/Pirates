package modele;

public class CarteAttaque extends Carte {
    private int degat;
    private int cout; // Ajout du paramètre cout

    public CarteAttaque(String nom, String description, int degat, int cout) {
        super(nom, description, Cardtype.ATTACK);
        this.degat = degat;
        this.cout = cout; // Initialisation du cout
    }

    public int getDegat() {
        return degat;
    }

    public int getCout() {
        return cout; // Getter pour le cout
    }

    @Override
    public void jouerCarte(Pirate actif, Pirate cible) {
        cible.effetAttaque(degat);
    }
}