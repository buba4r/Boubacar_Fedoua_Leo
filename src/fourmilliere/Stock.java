package fourmilliere;

import java.util.ArrayList;
import java.util.Iterator;

import proie.Proie;
import proie.etat.MortProie;

public class Stock {
  private ArrayList<Proie> consommable;
  private ArrayList<Proie> nonConsommable;

  public Stock() {
    consommable = new ArrayList<Proie>();
    nonConsommable = new ArrayList<Proie>();
  }

  public ArrayList<Proie> getComsommable() {
    return consommable;
  }

  public ArrayList<Proie> getNonComsommable() {
    return nonConsommable;
  }

  public Proie retirerProieConsommable() {
    Proie p;
    Iterator<Proie> it;
    it = consommable.iterator();
    if (it.hasNext()) {
      p = it.next();
      consommable.remove(p);
      return p;
    }
    return null;
  }

  public Proie retirerProieNonConsommable() {
    Proie p;
    Iterator<Proie> it;
    it = nonConsommable.iterator();
    if (it.hasNext()) {
      p = it.next();
      nonConsommable.remove(p);
      return p;
    }
    return null;
  }

  public boolean deposerConsommable(Proie p) {
    if (((MortProie) p.getEtat()).isConsommable()) {
      consommable.add(p);
      return true;

    }
    return false;
  }

}
