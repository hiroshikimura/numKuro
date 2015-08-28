package org.kimura.pazzle.numKuro.operator;

import java.util.Comparator;

import org.kimura.pazzle.numKuro.container.Analyzed;
import org.kimura.pazzle.numKuro.container.InputFieldSet;

/**
 * 入力欄集合の比較
 * <p>
 * 比較そのものは下記要領で行う。
 * それぞれの『すでに文字が埋まっている割合』を算出
 * それぞれの入力欄数を算出
 * 割合の大きい(より埋まっている入力欄集合)方が優先順位は上
 * 同率なら入力欄数で勝負
 * それでも同点の場合はゼロを返す
 * </p>
 * @author kimura
 *
 */
public class InputFieldSetComparator implements Comparator<InputFieldSet> {
	
	public Analyzed analyzed;

	public int compare(InputFieldSet o1, InputFieldSet o2) {
		int i1, i2;
		i1 = o1.fillRatio(analyzed);
		i2 = o2.fillRatio(analyzed);
		if ( i1 != i2 ) {
			return i1 - i2;
		}
		return o1.len() - o2.len();
	}

}
