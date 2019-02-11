package automobile;

/*les valeurs des enrigistrement au momen de création = 0
l'enrigistrement partiel peut être mis à zero
                         lorsqu'il atteint maximumSpeed -> mis à zero
our modifier les valeurs il faut mettre des Km
* */

public class Compteur {

    private double totalisateur;
    private double partiel;

    static final double maximumDistance = 1000;

    public Compteur() {
        this.totalisateur = 0;
        this.partiel = 0;
    }

    public double getTotalisateur() {
        return totalisateur;
    }

    public double getPartiel() {
        return partiel;
    }

    public void setPartiel(double partiel) {
        if (partiel <= Compteur.maximumDistance) {
            this.partiel = partiel;
        }
    }
    
    public void resetPartiel(){
        this.partiel = 0;
    }
    
    public void add(double increment){
        this.totalisateur += increment;
        partiel = (partiel + increment) % Compteur.maximumDistance;
    }

    @Override
    public String toString(){
        int totalisateur = (int)Math.round(this.totalisateur);
        int partiel = (int)Math.round(this.partiel);
        return "Compteur = [ Totalisateur = "+ totalisateur + " | Partiel = " + partiel + " ]";
    }
}
