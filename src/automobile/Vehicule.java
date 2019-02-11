package automobile;

/*jauge est mis à zero quand reservoir est à la capacité
* */

import java.util.Comparator;

public class Vehicule implements Comparable<Vehicule> {

    static private int registre = 0;
    private int numeroImmatriculation;
    private Compteur compteurKm;
    private static final double capacite = 50;
    private double jauge;
    private double consommation;

    public Vehicule(double consommation) {
        numeroImmatriculation = registre;
        Vehicule.registre++;
        compteurKm = new Compteur();
        this.consommation = consommation;
        jauge = 0;
    }

    public int getNoImmatriculation() {
        return numeroImmatriculation;
    }

    public double getJauge() {
        return jauge;
    }

    public Compteur getCompteur(){
        return compteurKm;
    }

    public void mettreDeLessence(double volume) throws CapaciteDepasseeException
    {
        if(jauge + volume >= capacite)
        {
            throw new CapaciteDepasseeException("Votre resevoir a une capacité insuffisante pour mettre "+volume+" d'essence");
        }
        else {
            jauge += volume;
        }

    }

    public void faireLePlein(){
        jauge = capacite;
    }

    public double rouler(double distance){

        double carburantNec = (consommation * distance / 100);
        if(jauge > carburantNec){
            compteurKm.add(distance);
            jauge -= carburantNec;
            return distance;
        }else{
            int Kmparcouru = (int) (jauge / consommation * 100);
            compteurKm.add(Kmparcouru);
            faireLePlein();
            return Kmparcouru;
        }

    }

    @Override
    public String toString() {
        return "Vehicule "+ numeroImmatriculation +" : "+ compteurKm.toString() +
                "; jauge = " + ((int)(jauge * 100.0)) / 100.0 + "\n";
    }


    @Override
    public int compareTo(Vehicule v) {
        return Integer.compare(this.numeroImmatriculation, v.numeroImmatriculation);
    }

    static class CompteurComparator implements Comparator<Vehicule> {

        @Override
        public int compare(Vehicule v1, Vehicule v2) {
            return (int) (v1.getCompteur().getTotalisateur() - v2.getCompteur().getTotalisateur());
        }
    }

    static class ResetPartiel implements Fonction<Vehicule>{

        @Override
        public void applyIt(Vehicule vehicule) {
            vehicule.getCompteur().resetPartiel();
        }
    }

    static class FaireLePlein implements Fonction<Vehicule>{

        @Override
        public void applyIt(Vehicule vehicule) {
            if (vehicule.getJauge() < 10)
                vehicule.faireLePlein();
        }
    }
}
