package modele;

public class CarteAttaque extends Carte {
    private int degat;
    // Ajout du paramètre cout

    public CarteAttaque(String nom, String description, int degat,int cout) {
        super(nom, description, Cardtype.ATTACK,cout);
        this.degat = degat;
        // Initialisation du cout
    }

    public int getDegat() {
        return degat;
    }

    

    @Override
    public void jouerCarte(Pirate actif, Pirate cible) {
        cible.effetAttaque(degat);
    }
}