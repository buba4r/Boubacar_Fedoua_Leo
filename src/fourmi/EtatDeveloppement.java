package fourmi;

import fourmi.etat.DureeVie;

public abstract class EtatDeveloppement {
  protected Fourmi fourmi;
  protected DureeVie dureeDeVie;

  protected EtatDeveloppement(Fourmi fourmi) {
    this.fourmi = fourmi;
  }

  public void setDureeDeVie(double d) {
    dureeDeVie = new DureeVie(d);
  }

  public Fourmi getFourmi() {
    return fourmi;
  }

  public abstract void evolution();

  public abstract void action();

  public abstract boolean manger();

}