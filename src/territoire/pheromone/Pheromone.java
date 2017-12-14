package territoire.pheromone;

import fourmilliere.Fourmiliere;

public abstract class Pheromone {
  Fourmiliere fourmiliere;
  int duree = 24; // la durre d'action du pheromone en heure
  final int RAFFRAICHISSEMENT = 12;
  final int DISTANCE_MAX = 200;

  public void passageFourmi() {

    if (duree + RAFFRAICHISSEMENT < DISTANCE_MAX) {

      duree = duree + RAFFRAICHISSEMENT;
    }
  }

  public int getPuissance() {
    return duree;
  }

  public void decrementPheromone() {
    if (duree > 10) {
      this.duree -= 10;
    } else if (duree > 0) {
      this.duree--;
    }
  }

}
