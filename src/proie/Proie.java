package proie;

import java.awt.Point;
import java.util.Random;

import territoire.Territoire;

public class Proie {

  double poid;
  Territoire territoire;
  Etat etat;
  Point point;

  public Proie(Territoire territoire, double poid) {
    this.poid = poid;
    this.territoire = territoire;
    Random rand = new Random();
    point = new Point(rand.nextInt(territoire.getX()), rand.nextInt(territoire.getY()));

  }

  public void placerProie() {
    territoire.getCase(point).arriveeProie(this);

  }

  public boolean Vivant() {
    return true;
  }

  public boolean Consommables() {
    return true;
  }

  public double getPoid() {
    return poid;
  }

  public void setPoid(double poid) {
    this.poid = poid;
  }

  public Territoire getTerritoire() {
    return territoire;
  }

  public void setTerritoire(Territoire territoire) {
    this.territoire = territoire;
  }

  public Etat getEtat() {
    return etat;
  }

  public void setEtat(Etat etat) {
    this.etat = etat;
  }

  public Point getPoint() {
    return point;
  }

}
