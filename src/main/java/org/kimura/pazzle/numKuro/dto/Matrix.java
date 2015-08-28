package org.kimura.pazzle.numKuro.dto;

import java.util.ArrayList;

/**
 * 初期マトリクス
 * Scanlineの集合
 * @author kimura
 *
 */
public class Matrix<T> extends ArrayList<Scanline<T>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 指定したサイズのマトリクスを生成する
	 * @param height 高さ
	 * @param width 幅
	 * @return
	 */
	public static <T> Matrix<T> create(int height, int width) {
		Matrix<T> mat = Matrix.create();
		Scanline<T> line;
		for ( int i = 0 ; i < height ; i++ ) {
			mat.add(line =createLine(width));
		}
		return mat;
	}
	/**
	 * 指定した高さのマトリクスを生成する
	 * @param height 高さ
	 * @return
	 */
	public static <T> Matrix<T> create(int height) {
		Matrix<T> mat = Matrix.create();
		Scanline<T> line;
		for ( int i = 0 ; i < height ; i++ ) {
			mat.add(line=Matrix.createLine());
		}
		return mat;
	}
	/**
	 * 空のマトリクスを生成する。
	 * @return
	 */
	public static <T> Matrix<T> create() {
		return new Matrix<T>();
	}
	/**
	 * マトリクス中の１行を長さ指定で生成する
	 * @param length 長さ
	 * @return
	 */
	public static <T> Scanline<T> createLine(int length) {
		Scanline<T> line = createLine();
		line.ensureCapacity(length);
		return line;
	}
	/**
	 * マトリクス中の１行を生成する
	 * @return
	 */
	public static <T> Scanline<T> createLine() {
		return new Scanline<T>();
	}
	/**
	 * 指定した行を取得する
	 * @return
	 */
	public Scanline<T>	get(int index) {
		return this.get(index);
	}
	/**
	 * 指定した行/列の文字を取得する
	 * @param row 行
	 * @param col 列
	 * @return
	 */
	public T get(int row, int col) {
		return this.get(row).get(col);
	}
}
