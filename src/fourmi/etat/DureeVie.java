package fourmi.etat;

public class DureeVie {
  double tempVie;

  public DureeVie(double tempsVie) {
    this.tempVie = tempsVie;
  }

  public boolean decrementer() {
    tempVie--;
    if (tempVie <= 0) {
      return true;
    }
    return false;
  }

}
