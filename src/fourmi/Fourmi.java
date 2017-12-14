package fourmi;

import fourmilliere.Fourmiliere;
import territoire.Territoire;

import java.awt.Point;

import fourmi.etat.Oeuf;

public class Fourmi {

  Appetit appetit;
  Fourmiliere fourmiliere;
  private EtatDeveloppement etat;
  private boolean aNettoye;
  Point point = new Point();
  Territoire territoire;

  private double poids;

  public Fourmi(Fourmiliere fourmiliere) {

    this.fourmiliere = fourmiliere;
    territoire = fourmiliere.getTerritoire();

    etat = new Oeuf(this);

    aNettoye = true;

    poids = 0;
    appetit = new Appetit(this);

    point = fourmiliere.getPoint();
  }

  public boolean isaNettoye() {
    return aNettoye;
  }

  public void setaNettoye(boolean aNettoye) {
    this.aNettoye = aNettoye;
  }

  public double getPoids() {
    return poids;
  }

  public void setPoids(double poids) {
    this.poids = poids;
  }

  public boolean nettoie() {
    return aNettoye = true;
  }

  public Appetit getAppetit() {
    return appetit;
  }

  public void setAppetit(Appetit appetit) {
    this.appetit = appetit;
  }

  // a besoin de manger
  public double manger(double poids) {
    return appetit.manger(poids);
  }

  public void transformation(EtatDeveloppement nouvelleEtat) {
    etat = nouvelleEtat;
  }

  public Fourmiliere getFourmiliere() {
    return fourmiliere;
  }

  public EtatDeveloppement getEtatDeveloppement() {
    return etat;
  }

  public void action() {
    etat.action();
  }

  public Point getPoint() {
    return point;
  }

  public Territoire getTerritoire() {
    // TODO Auto-generated method stub
    return territoire;
  }

  public void setPoint(int x, int y) {
    // TODO Auto-generated method stub
    point = new Point(x, y);

  }

}
