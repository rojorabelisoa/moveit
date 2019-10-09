package com.formation;

public class TondeuseHelper {
	/**
	 * Fais bouger la tondeuse durant une liste d'action
	 * @param t la tondeur à faire bouger
	 * @param listAction liste des instruction pour bouger la tondeuse
	 * @return la tondeuse avec sa position final
	 */
	public static Tondeuse moveWithActions(Tondeuse t, String listAction) {
		// parse orders
		Action[] actions = new Action[listAction.length()];
		for (int i = 0; i < listAction.length(); i++) {
			actions[i] = Action.parse(listAction.charAt(i));
		}
		// for each orders, make the action
		for (Action action : actions) {
			action.move(t);
		}
		return t;
	}
}
