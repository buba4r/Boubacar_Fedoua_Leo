package fourmilliere;

import java.awt.Point;
import java.util.ArrayList;

import fourmi.Fourmi;
import territoire.Territoire;
import visiteur.IVisitableFourmiliere;
import visiteur.IVisiteurFourmiliere;

public class Fourmiliere implements IVisitableFourmiliere {

  Stock stockNourriture;
  Point point;
  int nbLarves;
  int nbNymphes;
  int nbOeufs;
  int nbOuvriers;
  int nbSoldats;
  int nbMorts;
  ArrayList<Fourmi> fourmis;
  Territoire territoire;

  public Fourmiliere(Point point, Territoire territoire) {
    this.territoire = territoire;
    nbMorts = 0;
    nbLarves = 0;
    nbNymphes = 0;
    nbOuvriers = 0;
    nbSoldats = 0;
    nbOeufs = 0;
    fourmis = new ArrayList<Fourmi>();
    this.point = point;
    stockNourriture = new Stock();
  }

  public int getPopulation() {
    return fourmis.size();
  }

  @Override
  public void applique(IVisiteurFourmiliere visiteur) {
    // TODO Auto-generated method stub
    visiteur.agitSur(this);

  }

  public Fourmi naissanceFourmi() {
    Fourmi nouvelleFourmi = new Fourmi(this);
    fourmis.add(nouvelleFourmi);
    return nouvelleFourmi;

  }

  public ArrayList<Fourmi> getFourmis() {
    return fourmis;
  }

  public void arriveeFourmi(Fourmi fourmi) {
    fourmis.add(fourmi);
  }

  public Point getPoint() {
    return point;
  }

  public void addOeuf() {
    nbOeufs++;
  }

  public void addNymphe() {
    nbNymphes++;
  }

  public void addSoldat() {
    nbSoldats++;
  }

  public void addLarve() {
    nbLarves++;
  }

  public void addOuvrier() {
    nbOuvriers++;
  }

  public void supprOeuf() {
    nbOeufs--;
  }

  public void supprNymphe() {
    nbNymphes--;
  }

  public void supprSoldat() {
    nbSoldats--;
  }

  public void supprLarve() {
    nbLarves--;
  }

  public void supprOuvrier() {
    nbOuvriers--;
  }

  public int getOeufs() {
    return nbOeufs;
  }

  public int getLarves() {
    return nbLarves;
  }

  public int getNymphes() {
    return nbNymphes;
  }

  public int getOuvriers() {
    return nbOuvriers;
  }

  public int getSoldats() {
    return nbSoldats;
  }

  public Stock getStock() {
    return stockNourriture;
  }

  public Territoire getTerritoire() {
    // TODO Auto-generated method stub
    return territoire;
  }

}
