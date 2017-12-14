package observeur;

public interface Observable {
  public void ajouterObserveur(Observeur o);

  // Methode permettant de supprimer (resilier) un observateur.
  public void supprimerObserveur(Observeur o);

  // Methode qui permet d'avertir tous les observateurs lors d'un changement
  // d'etat.
  public void notifierObserveurs();
}
