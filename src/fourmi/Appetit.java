package fourmi;

import fourmi.Fourmi;

public class Appetit {

  double faim;

  Fourmi fourmi;

  public double getFaim() {
    return faim;
  }

  public void setFaim(double Faim) {
    this.faim = Faim;
  }

  public Appetit(Fourmi fourmi) {
    this.fourmi = fourmi;
    faim = 1 / 3 * fourmi.getPoids();
  }

  public double manger(double poids) {
    return faim -= poids;
  }

  public void nouvelleJournee() {
    faim = 1 / 3 * fourmi.getPoids();
  }

}