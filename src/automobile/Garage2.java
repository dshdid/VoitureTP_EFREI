package automobile;

import java.util.*;

public class Garage2 implements Iterable<Vehicule>, Map<Vehicule>{



    private Set<Vehicule> garage;
    private Class garage_Comparable;

    public Garage2() {
        garage = new TreeSet<>();
        garage_Comparable = Comparable.class;
    }

    public Garage2(Vehicule.CompteurComparator compteurComparator) {
        garage = new TreeSet<Vehicule>(compteurComparator);
        garage_Comparable = compteurComparator.getClass();
    }

    @Override
    public String toString() {
        return garage.toString();
    }

    public boolean add(Vehicule vehicule) {
        return garage.add(vehicule);
    }

    @Override
    public Iterator<Vehicule> iterator() {
        return garage.iterator();
    }

    public void triNoImmatriculion() {

        Set<Vehicule> vehicules = new TreeSet<>();
        garage_Comparable = Comparable.class;
        vehicules.addAll(garage);
        garage = vehicules;
    }

    public void triCompteur() {

        Comparator<Vehicule> comparator = new Vehicule.CompteurComparator();
        Set<Vehicule> vehicules = new TreeSet<Vehicule>(comparator);
        garage_Comparable = comparator.getClass();
        vehicules.addAll(garage);
        garage= vehicules;
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
        this.map( faireLePlein);
    }
}
