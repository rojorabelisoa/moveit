package com.formation.game;

import com.formation.Tondeuse;
import com.formation.TondeuseHelper;

public class TondeuseInstruction {
	private Tondeuse tondeuse;
	private String action;
	private Tondeuse result;
	public TondeuseInstruction(Tondeuse tondeuse, String action) {
		super();
		this.tondeuse = tondeuse;
		this.action = action;
		Tondeuse t = new Tondeuse(tondeuse.getX(),tondeuse.getY(),tondeuse.getDirection());
		this.result = TondeuseHelper.moveWithActions(t, action);
	}
	public Tondeuse getResult() {
		return result;
	}
	public Tondeuse getTondeuse() {
		return tondeuse;
	}
	public void setTondeuse(Tondeuse tondeuse) {
		this.tondeuse = tondeuse;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	@Override
	public String toString() {
		return "TondeuseInstruction [\n tondeuse=" + tondeuse + "\n action=" + action + "\n result=" + result + "]";
	}
	
	
}
