package com.formation.main;

import java.io.IOException;

import com.formation.game.Grid;
import com.formation.game.TondeuseInstruction;

public class Main {
	public static void main(String[] args) throws IOException {
		Grid grid = Grid.buildGridWithFile("/Users/imac/Desktop/test.txt");
		System.out.println(String.format("grid for width %s and heigth %s",grid.getMaxWidth(),grid.getMaxHeigth()));
		for(TondeuseInstruction ti : grid.getTondeuseInstruction()){
			System.out.println(ti);
		}
	}
}
