package proie;

import fourmi.etat.DureeVie;

public abstract class Etat {
  Proie proie;
  protected DureeVie dureeDeVie;

  protected Etat(Proie proie) {
    this.proie = proie;
  }

  public void setDureeDeVie(double d) {
    dureeDeVie = new DureeVie(d);
  }

  public abstract void evolution();
}
