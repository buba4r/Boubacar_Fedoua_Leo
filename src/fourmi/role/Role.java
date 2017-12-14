package fourmi.role;

import fourmi.Fourmi;

public abstract class Role {

  protected Fourmi fourmi;

  public Role(Fourmi fourmi) {
    this.fourmi = fourmi;

  }

  public abstract void action();
}
