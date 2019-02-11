package automobile;

public class UtilisationVer1 {

	public static void main(String[] args) {

		System.out.println("######## TESTS DES COMPTEURS ########");
		UtilisationVer1.testCompteur();
		System.out.println("\n\n######## TESTS DES VEHICULES ########");
		UtilisationVer1.testVehicule();

		System.out.println("\n\n######## TESTS DU GARAGE Collection: List ########");
		UtilisationVer1.testGarage1();
		System.out.println("\n\n######## TESTS DU GARAGE Collection: List Mappings ########");
		UtilisationVer1.testMappings1();

		System.out.println("\n\n######## TESTS DU GARAGE Collection: Set Comparable########");
		UtilisationVer1.testGarage2();
		System.out.println("\n\n######## TESTS DU GARAGE Collection: Set CompteurComparator########");
		UtilisationVer1.testGarage2Bis();

		System.out.println("\n\n######## TESTS DU GARAGE Collection: Set Mappings ########");
		UtilisationVer1.testMappings2();
	}

	public static void testCompteur() {
		Compteur compteur = new Compteur();
		System.out.println(compteur);
		compteur.add(200);
		System.out.println(compteur);
		compteur.add(300);
		System.out.println(compteur);
		compteur.resetPartiel();
		System.out.println(compteur);
		compteur.add(150);
		System.out.println(compteur);
	}

	public static void testVehicule() {
		Vehicule vehicule1 = new Vehicule(5.3);
		Vehicule vehicule2 = new Vehicule(8.7);
		System.out.println(vehicule1);

		double distanceParcourue = vehicule1.rouler(100);
		System.out.println("Le vehicule " + vehicule1.getNoImmatriculation() + " a parcouru " +
				((int)( distanceParcourue* 100.0)) / 100.0 + "kms");
		System.out.println(vehicule1);

		distanceParcourue = vehicule1.rouler(300);
		System.out.println("Le vehicule " + vehicule1.getNoImmatriculation() + " a parcouru " +
				((int)( distanceParcourue* 100.0)) / 100.0 + "kms");
		System.out.println(vehicule1);

		distanceParcourue = vehicule1.rouler(700);
		System.out.println("Le vehicule " + vehicule1.getNoImmatriculation() + " a parcouru " +
				((int)( distanceParcourue* 100.0)) / 100.0 + "kms");
		System.out.println(vehicule1);

		distanceParcourue = vehicule1.rouler(200);
		System.out.println("Le vehicule " + vehicule1.getNoImmatriculation() + " a parcouru " +
				((int)( distanceParcourue* 100.0)) / 100.0 + "kms");
		System.out.println(vehicule1);

		vehicule1.rouler(540);
		System.out.println(vehicule1);
		vehicule1.faireLePlein();
		System.out.println(vehicule1);
		vehicule1.rouler(260);
		System.out.println(vehicule1);

		try {
			vehicule1.mettreDeLessence(6);
		} catch (CapaciteDepasseeException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(vehicule1);

		try {
			vehicule1.mettreDeLessence(16);
		} catch (CapaciteDepasseeException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(vehicule1);


		System.out.println(vehicule2);
		System.out.println(vehicule1.compareTo(vehicule1));
		System.out.println(vehicule1.compareTo(vehicule2));

	}


	public static void testMappings1() {
		Garage1 garage = new Garage1();

		garage.add(new Vehicule(5.7));
		garage.add(new Vehicule(6.2));
		garage.add(new Vehicule(8.5));
		garage.add(new Vehicule(5.9));
		garage.add(new Vehicule(4.5));
		System.out.println(garage);

		for(Vehicule vehicule : garage) {
			vehicule.faireLePlein();
			vehicule.rouler(Math.random() * 3000);
		}
		System.out.println(garage);

		for(Vehicule vehicule : garage) {
			try {
				vehicule.mettreDeLessence((int) (Math.random() * 100));
			} catch (CapaciteDepasseeException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println(garage);

		garage.resetPartielAll();
		System.out.println("\n remise à 0 des compteurs partiels de tous les véhiculess!");
		System.out.println(garage);

		garage.faireLePleinAll();
		System.out.println("\n faire le plein de tous les véhicules s'il reste moins de 10 litres !");
		System.out.println(garage);
	}


	public static void testMappings2() {
		Garage2 garage = new Garage2();

		garage.add(new Vehicule(5.7));
		garage.add(new Vehicule(6.2));
		garage.add(new Vehicule(8.5));
		garage.add(new Vehicule(5.9));
		garage.add(new Vehicule(4.5));
		System.out.println(garage);

		for(Vehicule vehicule : garage) {
			vehicule.faireLePlein();
			vehicule.rouler(Math.random() * 3000);
		}
		System.out.println(garage);

		for(Vehicule vehicule : garage) {
			try {
				vehicule.mettreDeLessence((int) (Math.random() * 100));
			} catch (CapaciteDepasseeException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println(garage);

		garage.resetPartielAll();
		System.out.println("\n remise à 0 des compteurs partiels de tous les véhiculess!");
		System.out.println(garage);

		garage.faireLePleinAll();
		System.out.println("\n faire le plein de tous les véhicules s'il reste moins de 10 litres !");
		System.out.println(garage);
	}

	public static void testGarage1() {
		Garage1 garage = new Garage1();

		garage.add(new Vehicule(5.7));
		garage.add(new Vehicule(6.2));
		garage.add(new Vehicule(8.5));
		garage.add(new Vehicule(5.9));
		garage.add(new Vehicule(4.5));
		System.out.println(garage);

		for(Vehicule vehicule : garage) {
			vehicule.faireLePlein();
			vehicule.rouler(Math.random() * 1000);
		}
		System.out.println(garage);

		for(Vehicule vehicule : garage) {
			try {
				vehicule.mettreDeLessence((int) (Math.random() * 100));
			} catch (CapaciteDepasseeException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println(garage);

		UtilisationVer1.tri1(garage);
	}

	// Garage Comparable
	public static void testGarage2() {
		Garage2 garage = new Garage2();

		garage.add(new Vehicule(5.7));
		garage.add(new Vehicule(6.2));
		garage.add(new Vehicule(8.5));
		garage.add(new Vehicule(5.9));
		garage.add(new Vehicule(4.5));
		System.out.println(garage);

		for(Vehicule vehicule : garage) {
			vehicule.faireLePlein();
			vehicule.rouler(Math.random() * 1000);
		}
		System.out.println(garage);


		for(Vehicule vehicule : garage) {
			try {
				vehicule.mettreDeLessence((int) (Math.random() * 100));
			} catch (CapaciteDepasseeException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println(garage);

		UtilisationVer1.tri2(garage);
	}


/**
	 * Garage CompteurComparateur
	 * ATTENTION: il faut d'abord instancier un garage Comparable
	 * l'on référence ensuite par un garage CompteurComparable
	 * en effet, les véhicules ayant tous un compteur à 0 lors de leur instanciation ne seraient pas ajoutés
	 * à un garage CompteurComparable, car un Set est sans doublon par rapport au critère de comparaison
	 */

	public static void testGarage2Bis() {
		Garage2 garageTemp = new Garage2();

		garageTemp.add(new Vehicule(5.7));
		garageTemp.add(new Vehicule(6.2));
		garageTemp.add(new Vehicule(8.5));
		garageTemp.add(new Vehicule(5.9));
		garageTemp.add(new Vehicule(4.5));

		Garage2 garage = new Garage2(new Vehicule.CompteurComparator());
		garage = garageTemp;

		for(Vehicule vehicule : garage) {
			vehicule.faireLePlein();
			vehicule.rouler(Math.random() * 1000);
		}
		System.out.println(garage);


		for(Vehicule vehicule : garage) {
			try {
				vehicule.mettreDeLessence((int) (Math.random() * 100));
			} catch (CapaciteDepasseeException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println(garage);

		UtilisationVer1.tri2(garage);
	}


	private static void tri1(Garage1 garage) {
		System.out.println("\n\n##Tri selon le no immatriculation ##");
		garage.triNoImmatriculion();
		System.out.println(garage);
		garage.triNoImmatriculion();

		System.out.println("\n\n##Tri selon le compteur km totalisateur ##");
		garage.triCompteur();
		System.out.println(garage);
		garage.triCompteur();

		System.out.println("\n\n##Tri selon le no immatriculation ##");
		garage.triNoImmatriculion();
		System.out.println(garage);
	}

	private static void tri2(Garage2 garage) {
		System.out.println("\n\n##Tri selon le no immatriculation ##");
		garage.triNoImmatriculion();
		System.out.println(garage);
		garage.triNoImmatriculion();

		System.out.println("\n\n##Tri selon le compteur km totalisateur ##");
		garage.triCompteur();
		System.out.println(garage);
		garage.triCompteur();

		System.out.println("\n\n##Tri selon le no immatriculation ##");
		garage.triNoImmatriculion();
		System.out.println(garage);
	}
}
