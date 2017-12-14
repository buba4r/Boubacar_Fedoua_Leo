package territoire;

import java.awt.Point;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import drawing.Oval;
import fourmi.Fourmi;
import fourmi.combat.Combattant;
import observeur.Observable;
import observeur.Observeur;
import proie.Proie;

public class Case implements Observable, Combattant {

  private boolean yaCombat;

  Oval oval;
  private Point point;
  // private Fourmiliere fourmilierePresente;
  Observeur observeur;
  private CopyOnWriteArrayList<Fourmi> fourmisPresentes;
  private CopyOnWriteArrayList<Proie> proiesPresentes;
  private ArrayList<Combattant> listeCombattant;

  public Case(Point p) {

    oval = null;
    point = p;
    fourmisPresentes = new CopyOnWriteArrayList<Fourmi>();
    proiesPresentes = new CopyOnWriteArrayList<Proie>();
    // this.point = point;
    listeCombattant = new ArrayList<Combattant>();
  }

  public boolean arriveeFourmi(Fourmi fourmi) {
    if (!fourmisPresentes.contains(fourmi)) {
      fourmisPresentes.add(fourmi);
      oval = observeur.actualiser(this, oval);
      return true;
    }
    return false;
  }

  public boolean departFourmi(Fourmi fourmi) {
    if (fourmisPresentes.contains(fourmi)) {
      fourmisPresentes.remove(fourmi);
      oval = observeur.actualiser(this, oval);
      return true;
    }
    return false;
  }

  public boolean arriveeProie(Proie proie) {
    if (!proiesPresentes.contains(proie)) {
      proiesPresentes.add(proie);
      oval = observeur.actualiser(this, oval);
      return true;
    }
    return false;
  }

  public boolean departProie(Proie proie) {
    if (proiesPresentes.contains(proie)) {
      proiesPresentes.remove(proie);
      oval = observeur.actualiser(this, oval);
      return true;
    }
    return false;
  }

  public boolean containsProie() {
    return !proiesPresentes.isEmpty();
  }

  public boolean containsFourmi() {
    return !fourmisPresentes.isEmpty();
  }

  @Override
  public void ajouterObserveur(Observeur o) {
    // TODO Auto-generated method stub
    observeur = o;

  }

  @Override
  public void supprimerObserveur(Observeur o) {
    // TODO Auto-generated method stub
    observeur = null;

  }

  @Override
  public void notifierObserveurs() {
    // TODO Auto-generated method stub
    observeur.notify();
  }

  public Point getPoint() {
    // TODO Auto-generated method stub
    return point;
  }

  public boolean isYaCombat() {
    return yaCombat;
  }

  public void setYaCombat(boolean yaCombat) {
    this.yaCombat = yaCombat;
  }

  public ArrayList<Combattant> getListeCombattant() {
    return listeCombattant;
  }

  public void setListeCombattant(ArrayList<Combattant> listeCombattant) {
    this.listeCombattant = listeCombattant;
  }

  public int PositionCombattant(Combattant soldat) {
    while (this.listeCombattant.size() > 1) {
      return 1;
    }
    synchronized (this.listeCombattant) {
      this.listeCombattant.add(soldat);
      return 0;
    }
  }

  public void DeletePositionCombattant(Combattant soldat) {
    synchronized (this.listeCombattant) {
      this.listeCombattant.remove(soldat);
    }
  }

  public boolean isCombat() {
    if (this.listeCombattant.size() == 2) {
      if (this.listeCombattant.get(0) == this.listeCombattant.get(1))
        return false;
      else
        return true;
    } else if (this.listeCombattant.size() > 2) {
      System.out.println("trop de combattant sur une case");
      return false;
    } else
      return false;
  }

  @Override
  public void PerduCombat() {
    // TODO Auto-generated method stub

  }

  /*
   * public void detruireFourmiliere() { this.fourmilierePresente= null ; }
   * 
   * public boolean containsFourmiliere() { if (fourmilierePresente == null) {
   * return false;} return true; }
   */
}
