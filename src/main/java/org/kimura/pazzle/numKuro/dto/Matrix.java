package org.kimura.pazzle.numKuro.dto;

import java.util.ArrayList;

public class Matrix extends ArrayList<Scanline> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static Matrix create(int height, int width) {
		Matrix mat = Matrix.create();
		for ( int i = 0 ; i < height ; i++ ) {
			mat.add(createLine(width));
		}
		return mat;
	}
	public static Matrix create(int height) {
		Matrix mat = Matrix.create();
		for ( int i = 0 ; i < height ; i++ ) {
			mat.add(createLine());
		}
		return mat;
	}
	public static Matrix create() {
		return new Matrix();
	}
	public static Scanline createLine(int length) {
		Scanline line = createLine();
		line.ensureCapacity(length);
		return line;
	}
	public static Scanline createLine() {
		return new Scanline();
	}
	
	public Scanline	get(int index) {
		return this.get(index);
	}
	public Character get(int row, int col) {
		return this.get(row).get(col);
	}
}
