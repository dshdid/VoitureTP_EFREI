package automobile;

import java.util.*;

public class Garage1 implements Iterable <Vehicule>, Map<Vehicule>{

    private List<Vehicule> garage;

    public Garage1()
    {
        this.garage = new ArrayList<>();
    }

    public boolean add(Vehicule vehicule){
        return garage.add(vehicule);
    }

    @Override
    public Iterator<Vehicule> iterator() {
        return garage.iterator();
    }

    @Override
    public String toString() {

        return garage.toString();
    }

    public void triNoImmatriculion() {
        Collections.sort(garage);
    }

    public void triCompteur() {
        Collections.sort(garage, new Vehicule.CompteurComparator());
    }

    @Override
    public void map(Fonction<Vehicule> f) {
        for(Vehicule vehicule: garage){
            f.applyIt(vehicule);
        }
    }

    public void resetPartielAll() {
        Fonction <Vehicule> resetPartiel = new Vehicule.ResetPartiel();
        this.map(resetPartiel);
    }

    public void faireLePleinAll() {
        Fonction <Vehicule> faireLePlein = new Vehicule.FaireLePlein();
        this.map(faireLePlein);
    }
}
