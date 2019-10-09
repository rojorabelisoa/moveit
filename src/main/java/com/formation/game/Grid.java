package com.formation.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.formation.Tondeuse;
import com.formation.file.FileUtils;

public class Grid {
	private int maxWidth;
	private int maxHeigth;
	List<TondeuseInstruction> tondeuseInstruction;
	
	private Grid(int maxWidth, int maxHeigth, List<TondeuseInstruction> tondeuseInstruction) {
		if (maxWidth < 0 || maxHeigth < 0) {
			throw new NumberFormatException("valeur maxWidth et maxHeigth doivent être supétieur à 0");
		}
		Objects.requireNonNull(tondeuseInstruction);
		this.maxWidth = maxWidth;
		this.maxHeigth = maxHeigth;
		this.tondeuseInstruction = tondeuseInstruction;
	}
	
	public static Grid build(String filename) throws IOException {
		List<String> fileContent = FileUtils.readFile(filename);
		String[] area = fileContent.get(0).split(" ");
		int width = Integer.valueOf(area[0]);
		int heigth = Integer.valueOf(area[1]);
		List<TondeuseInstruction> tmpTondeuseInstruction = new ArrayList<>();
		for(int i = 1;i<fileContent.size(); i=i+2) {
			//valeur pour tondeuse
			String[] tondeuseInitValue = fileContent.get(i).split(" ");
			Tondeuse tmpTondeuse = new Tondeuse(tondeuseInitValue[0], tondeuseInitValue[1], tondeuseInitValue[2]);
			//valeur pour instruction
			String actionInitValue = fileContent.get(i+1);
			tmpTondeuseInstruction.add(new TondeuseInstruction(tmpTondeuse,actionInitValue));
		}
		return new Grid(width,heigth,tmpTondeuseInstruction);
	}

	public int getMaxWidth() {
		return maxWidth;
	}

	public int getMaxHeigth() {
		return maxHeigth;
	}

	public List<TondeuseInstruction> getTondeuseInstruction() {
		return tondeuseInstruction;
	}
	
	
	
	
}
