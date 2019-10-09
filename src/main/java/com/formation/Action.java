package com.formation;

public enum Action {
	GAUCHE('G') {
	    @Override
	    public void move(Tondeuse t) {
	      t.moveLeft();
	    }
	  },
	  DROITE('D') {
	    @Override
	    public void move(Tondeuse t) {
	      t.moveRigth();
	    }
	  },
	  AVANCE('A') {
	    @Override
	    public void move(Tondeuse t) {
	      t.moveForward();
	    }
	  };

	  private final char value;

	  Action(final char val) {
		  value = val;
	  }

	  @Override
	  public String toString() {
	    return String.valueOf(value);
	  }

	  /***
	   * Initialise la valeur de l'action avec un entrée de char
	   * @param value valeur de la tondeuse
	   * @return l'orientation après affectation de valeur
	   * @throws IllegalArgumentException si le parametre ne correspond pas à la valeur d'action existante
	   */
	  public static Action parse(final char value) throws IllegalArgumentException {
		  for (int i =0;i<Action.values().length;i++) {
				if (value == Action.values()[i].value) {
					return Action.values()[i];
				}
			}
	    throw new IllegalArgumentException("Valeur pour l'action inconnu");
	  }

	  /***
	   * Initialise la valeur de l'action avec un entrée de String
	   * @param value valeur de la tondeuse
	   * @return l'orientation après affectation de valeur
	   * @throws IllegalArgumentException si le parametre ne correspond pas à la valeur d'action existante
	   */
	  public static Action parse(final String val) throws IllegalArgumentException {
	    return parse(val.toUpperCase().charAt(0));
	  }

	  /**
	   * change l'orientation du tondeuse ou le fait avancer.
	   *
	   * @param t tondeuse à faire bouger
	   */
	  abstract void move(Tondeuse t);
}
