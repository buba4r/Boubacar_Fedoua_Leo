package visiteur;

import fourmilliere.Fourmiliere;

public class RapportFourmiliere implements IVisiteurFourmiliere {

  @Override
  public void agitSur(Fourmiliere fourmiliere) {
    // TODO Auto-generated method stub
    System.out.println("-----------------------------");
    System.out.println("Etat du stock : " + fourmiliere.getStock().getComsommable().size());
    System.out.println("Nombre de fourmis : " + fourmiliere.getPopulation());
    System.out.println("Nombre d'oeufs : " + fourmiliere.getOeufs());
    System.out.println("Nombre de larves : " + fourmiliere.getLarves());
    System.out.println("Nombre de nymphes : " + fourmiliere.getNymphes());
    System.out.println("Nombre d'ouvriers : " + fourmiliere.getOuvriers());
    System.out.println("Nombre de soldats : " + fourmiliere.getSoldats());

  }

}
