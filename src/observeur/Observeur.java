package observeur;

import drawing.Oval;

public interface Observeur {

  public Oval actualiser(Observable o, Oval oval);

}
