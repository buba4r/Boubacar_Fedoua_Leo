package proie.etat;

import proie.Etat;
import proie.Proie;

public class MortProie extends Etat {
  boolean consommable;
  Proie proie;
  private final int VIE_MORTPROIE = 2;

  public MortProie(Proie proie) {
    super(proie);
    this.proie = proie;
    this.setDureeDeVie(VIE_MORTPROIE);
    consommable = true;
    // TODO Auto-generated constructor stub
  }

  @Override
  public void evolution() {
    // TODO Auto-generated method stub
    if (dureeDeVie.decrementer()) {
      consommable = false;
    }

  }

  public boolean isConsommable() {
    return consommable;
  }

}
